package model.type;

import com.jayway.jsonpath.JsonPath;
import model.parser.Parser;
import net.minidev.json.JSONArray;

public class Artist extends Parser implements SnapObject {
    private final String name;
    private final String id;
    private final String uri;
    private final String externalURL;
    private final String followerCount;

    public Artist(JSONArray inputArray) {
        /*
          Constructs Artist object using info from JSONArray obtained via Spotify.
          The construction is handled via the Parser super class.

          @param inputArray the JsonArray used to assign values
         */
        super(inputArray);
        this.name = parseInfo("name");
        this.id = parseInfo("id");

        this.uri = parseInfo("uri");
        this.externalURL = parseInfo("spotify");
        this.followerCount = parseInfo("total");
    }

    public JSONArray readInfoAsJsonArray() {
        /*
          Builds a Json array with the info from the variable in the class
          @return JsonArray the Artist's stored information as a JsonArray
         */
        String artistArrayAsString = String.format("{\"artist\": [{\"name\": \"%s\", \"id\": \"%s\",\"uri\": " + "\"%s\",\"url\": \"%s\" ,\"total\": \"%s\"}]}",name,id,uri,externalURL,followerCount);
        return JsonPath.read(artistArrayAsString,"$.*");
    }
}