package model.parser;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class Song extends Parser {

    private String name;
    private String id;
    private String uri;
    private String duration_ms;
    private String track_number;
    private String explicit;

    public Song(JSONArray inputArray, int index) {
        super(inputArray);
        this.name = parseInfo("[*].name", index);
        this.id = parseInfo("id", index);

        this.uri = parseInfo("uri", index);
        this.duration_ms = parseInfo("duration_ms", index);
        this.track_number = parseInfo("track_number", index);

        this.explicit = parseInfo("explicit",0);
    }

    public JSONArray readSongInfoAsJson() {
        String artistArrayAsString = String.format("{\"album\": [{\"name\": \"%s\", \"id\": \"%s\",\"uri\": "
                + "\"%s\",\"duration_ms\": \"%s\" ,\"track_number\": \"%s\",\"explicit\": \"%s\"}]}",name,id,uri,duration_ms,track_number,explicit);
        return JsonPath.read(artistArrayAsString,"$.*");
    }
}
