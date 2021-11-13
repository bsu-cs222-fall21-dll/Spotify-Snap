package model.parser;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class Album extends Parser{

    private final String name;
    private final String id;
    private final String uri;
    private final String date;
    private final String totalTracks;
    private int index;

    public Album(JSONArray inputArray, int index) {
        /**
         * Constructs Album object using info from JSONArray obtained via Spotify.
         * The construction is handled via the Parser super class.
         * Part way through the function the index is updated to compensate for the JSONArray's of items
         *
         * @param inputArray the JsonArray used to assign values
         * @param index      the index that the album occupies
         */
        super(inputArray);
        this.name = parseInfo("name", index);
        this.id = parseInfo("id", index);

        this.uri = parseInfo("uri", index);
        this.index = calculateIndex(index);
        this.date = parseInfo("release_date", this.index);
        this.totalTracks = parseInfo("total_tracks", this.index);

    }

    public JSONArray readAlbumInfoAsJson() {
        /**
         * Builds a Json array with the info from the variable in the class
         * @return JsonArray the Album's stored information as a JsonArray
         */
        String artistArrayAsString = String.format("{\"album\": [{\"name\": \"%s\", \"id\": \"%s\",\"uri\": "
                + "\"%s\",\"date\": \"%s\" ,\"total_tracks\": \"%s\",\"index\": \"%d\"}]}",name,id,uri,date,totalTracks,index);
        return JsonPath.read(artistArrayAsString,"$.*");
    }

    private int calculateIndex(int index){
        /**
         * Divides the index of the album by two in order to compensate for how the JSONArray is looped over
         *
         * @param index      the index that the album occupies
         * @return index     the corrected value of the index
         */
        if(index<=0){
            return 0;
        }
        return index/2;
    }
}
