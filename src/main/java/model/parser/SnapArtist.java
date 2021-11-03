package model.parser;

import com.jayway.jsonpath.JsonPath;
import model.parser.SearchResultParser;
import net.minidev.json.JSONArray;

public class SnapArtist {
    private final String name;
    private final String id;
    private final String uri;
    private final String externalURL;
    private final String followerCount;

    public SnapArtist(JSONArray inputArray) {
        SearchResultParser searchResultParser = new SearchResultParser(inputArray);
        this.name = searchResultParser.parseInfo("name");
        this.id = searchResultParser.parseInfo("id");
        this.uri = searchResultParser.parseInfo("uri");
        this.externalURL = searchResultParser.parseInfo("spotify");
        this.followerCount = searchResultParser.parseInfo("total");
    }

    public JSONArray readArtistInfoAsJson() {

        String artistArrayAsString = String.format("{\"artist\": [{\"name\": \"%s\", \"id\": \"%s\",\"uri\": " + "\"%s\",\"url\": \"%s\" ,\"total\": \"%s\"}]}",name,id,uri,externalURL,followerCount);
        return JsonPath.read(artistArrayAsString,"$.*");
    }
}