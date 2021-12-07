package model.type;

import com.jayway.jsonpath.JsonPath;
import model.parser.Parser;
import net.minidev.json.JSONArray;

public class Artist extends Parser implements SnapObject {

    private  String name;
    private final String id;
    private final String uri;
    private final String externalURL;
    private final String followerCount;

    public Artist(JSONArray inputArray) {
        super(inputArray);
        this.name = parseInfo("name");
        this.id = parseInfo("id");

        this.uri = parseInfo("uri");
        this.externalURL = parseInfo("spotify");
        this.followerCount = parseInfo("total");
    }


    public JSONArray readInfoAsJsonArray() {
        name = name.replaceAll("\""," ");
        String artistArrayAsString = String.format("{\"artist\": [{\"name\": \"%s\", \"id\": \"%s\",\"uri\": " + "\"%s\",\"url\": \"%s\" ,\"total\": \"%s\"}]}",name,id,uri,externalURL,followerCount);
        return JsonPath.read(artistArrayAsString,"$.*");
    }
}