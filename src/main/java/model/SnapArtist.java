package model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class SnapArtist {
    private final String name;
    private final String id;
    private final String uri;
    private final String externalURL;
    private final String followerCount;

    public SnapArtist(JSONArray inputArray) {
        ArtistParser artistParser = new ArtistParser();
        this.name = artistParser.parseArtistName(inputArray);
        this.id = artistParser.parseArtistId(inputArray);
        this.uri = artistParser.parseArtistUri(inputArray);
        this.externalURL = artistParser.parseExternalUrl(inputArray);
        this.followerCount = artistParser.parseArtistFollowersTotal(inputArray);
    }

    public JSONArray readArtistInfoAsJson() {

        String artistArrayAsString = String.format("{\"artist\": [{\"name\": \"%s\", \"id\": \"%s\",\"uri\": " + "\"%s\",\"url\": \"%s\" ,\"total\": \"%s\"}]}",name,id,uri,externalURL,followerCount);
        return JsonPath.read(artistArrayAsString,"$.*");
    }
}
