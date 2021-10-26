package model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class SnapArtist {
    private String name;
    private String id;
    private String uri;
    private String followerCount;

    public SnapArtist(JSONArray inputArray) {
        ArtistParser artistParser = new ArtistParser();
        this.name = artistParser.parseArtistName(inputArray);
        this.id = artistParser.parseArtistId(inputArray);
        this.uri = artistParser.parseArtistUri(inputArray);
        this.followerCount = artistParser.parseArtistFollowersTotal(inputArray);
    }

    public JSONArray readArtistInfoAsJson() {

        String artistArrayAsString = String.format("{\"artist\": [{\"name\": \"%s\", \"id\": \"%s\",\"uri\": " +
                     "\"%s\", \"total\": \"%s\"}]}",name,id,uri,followerCount);
        return JsonPath.read(artistArrayAsString,"$.*");
    }
}
