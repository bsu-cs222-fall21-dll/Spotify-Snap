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
        SearchResultParser searchResultParser = new SearchResultParser(inputArray);
        this.name = searchResultParser.parseArtistInfo("name");
        this.id = searchResultParser.parseArtistInfo("id");
        this.uri = searchResultParser.parseArtistInfo("uri");
        this.externalURL = searchResultParser.parseArtistInfo("spotify");
        this.followerCount = searchResultParser.parseArtistInfo("total");
    }

    public JSONArray readArtistInfoAsJson() {

        String artistArrayAsString = String.format("{\"artist\": [{\"name\": \"%s\", \"id\": \"%s\",\"uri\": " + "\"%s\",\"url\": \"%s\" ,\"total\": \"%s\"}]}",name,id,uri,externalURL,followerCount);
        return JsonPath.read(artistArrayAsString,"$.*");
    }
}
