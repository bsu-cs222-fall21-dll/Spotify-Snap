package model.type;

import com.jayway.jsonpath.JsonPath;
import model.parser.Parser;
import net.minidev.json.JSONArray;

public class Song extends Parser implements SnapObject {

    private String name;
    private final String id;
    private final String uri;
    private final String duration_ms;
    private final String track_number;
    private final String explicit;

    public Song(JSONArray inputArray, int index) {
        /*
          Constructs Song object using info from JSONArray obtained via Spotify.
          The construction is handled via the Parser super class.

          @param inputArray the JsonArray used to assign values
         * @param index      the index that the album occupies
         */
        super(inputArray);

        this.name = parseInfo("[*].name", index);
        this.id = parseInfo("[*].id", index);

        this.uri = parseInfo("[*].uri", index);
        this.duration_ms = parseInfo("duration_ms", index);
        this.track_number = parseInfo("track_number", index);

        this.explicit = parseInfo("explicit",0);

    }

    public JSONArray readInfoAsJsonArray() {
        /*
          Builds a Json array with the info from the variable in the class
          @return JsonArray the Song's stored information as a JsonArray
         */
        name = name.replaceAll("\""," ");
        String artistArrayAsString = String.format("{\"album\": [{\"name\": \"%s\", \"id\": \"%s\",\"uri\": "
                + "\"%s\",\"duration_ms\": \"%s\" ,\"index\": \"%s\",\"explicit\": \"%s\"}]}",name,id,uri,duration_ms,track_number,explicit);
        return JsonPath.read(artistArrayAsString,"$.*");
    }
}
