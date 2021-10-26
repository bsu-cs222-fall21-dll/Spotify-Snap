package model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class ArtistFormatter {

    private final JSONArray artistArray;

    public ArtistFormatter(SnapArtist snapArtist) {
        this.artistArray = snapArtist.readArtistInfoAsJson();
    }

    public String formatSnapArtist() {

        String name = formatValueInArtistJson("name");
        String id = formatValueInArtistJson("id");
        String uri = formatValueInArtistJson("uri");
        String url = formatValueInArtistJson("url");
        String total = formatValueInArtistJson("total");

        return String.format("Name: %s\nId: %s\nExternal URL: %s\nUri: %s\nFollower Total: %s",
                name,id,url,uri,total);
    }

    private String formatValueInArtistJson(String valueToBeRead) {
        JSONArray itemArray = JsonPath.read(artistArray, String.format("$..%s", valueToBeRead));
        return itemArray.get(0).toString();
    }
}
