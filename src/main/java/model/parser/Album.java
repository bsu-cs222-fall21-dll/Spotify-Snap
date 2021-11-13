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
        super(inputArray);
        this.name = parseInfo("name", index);
        this.id = parseInfo("id", index);

        this.uri = parseInfo("uri", index);
        this.index = calculateIndex(index);
        this.date = parseInfo("release_date", this.index);
        this.totalTracks = parseInfo("total_tracks", this.index);

    }

    public JSONArray readAlbumInfoAsJson() {

        String artistArrayAsString = String.format("{\"album\": [{\"name\": \"%s\", \"id\": \"%s\",\"uri\": "
                + "\"%s\",\"date\": \"%s\" ,\"total_tracks\": \"%s\",\"index\": \"%d\"}]}",name,id,uri,date,totalTracks,index);
        return JsonPath.read(artistArrayAsString,"$.*");
    }

    private int calculateIndex(int index){

        if(index<=0){
            return 0;
        }
        return index/2;
    }
}
