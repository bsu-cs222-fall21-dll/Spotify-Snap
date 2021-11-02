package model.parser;

import com.jayway.jsonpath.JsonPath;
import model.parser.SearchResultParser;
import net.minidev.json.JSONArray;

public class Album {

    private final String name;
    private final String id;
    private final String uri;
    private final String date;
    private final String totalTracks;

    public Album(JSONArray inputArray) {
        SearchResultParser searchResultParser = new SearchResultParser(inputArray);
        this.name = searchResultParser.parseArtistInfo("name");
        this.id = searchResultParser.parseArtistInfo("id");
        this.uri = searchResultParser.parseArtistInfo("uri");
        this.date = searchResultParser.parseArtistInfo("release_date");
        this.totalTracks = searchResultParser.parseArtistInfo("total_tracks");
    }

    public JSONArray readAlbumInfoAsJson() {
        String artistArrayAsString = String.format("{\"album\": [{\"name\": \"%s\", \"id\": \"%s\",\"uri\": "
                + "\"%s\",\"date\": \"%s\" ,\"total_tracks\": \"%s\"}]}",name,id,uri,date,totalTracks);
        return JsonPath.read(artistArrayAsString,"$.*");
    }
}
