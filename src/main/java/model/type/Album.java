package model.type;

import com.jayway.jsonpath.JsonPath;
import model.parser.Parser;
import net.minidev.json.JSONArray;

public class Album extends Parser implements SnapObject {

    private String name;
    private final String id;
    private final String uri;
    private final String date;
    private final String totalTracks;
    private final int index;

    public Album(JSONArray inputArray, int index) {
        super(inputArray);
        this.name = parseInfo("[*].name", index);
        this.id = parseInfo("[*].id", index);

        this.uri = parseInfo("[*].uri", index);
        this.index = index;
        this.date = parseInfo("release_date", index);
        this.totalTracks = parseInfo("total_tracks", index);


    }

    public JSONArray readInfoAsJsonArray() {
        name = name.replaceAll("\""," ");
        String artistArrayAsString = String.format("{\"album\": [{\"name\": \"%s\", \"id\": \"%s\",\"uri\": "
                + "\"%s\",\"date\": \"%s\" ,\"total_tracks\": \"%s\",\"index\": \"%d\"}]}",name,id,uri,date,totalTracks,index);
        return JsonPath.read(artistArrayAsString,"$.*");
    }

}
