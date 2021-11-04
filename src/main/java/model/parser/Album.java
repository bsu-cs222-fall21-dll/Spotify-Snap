package model.parser;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class Album {

    private final String name;
    private final String id;
    private final String uri;
    private final String date;
    private final String totalTracks;
    private int index;

    public Album(JSONArray inputArray, int index) {
        SearchResultParser searchResultParser = new SearchResultParser(inputArray);
        this.name = searchResultParser.parseInfo("name", index);
        this.id = searchResultParser.parseInfo("id", index);
        this.uri = searchResultParser.parseInfo("uri", index);
        this.date = searchResultParser.parseInfo("release_date", index);
        this.totalTracks = searchResultParser.parseInfo("total_tracks", index);
        this.index = calculateIndex(index);
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
