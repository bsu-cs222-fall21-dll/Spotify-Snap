package model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class ArtistFormatter {
    public String formatSnapArtist(SnapArtist snapArtist) {
        JSONArray artistArray = snapArtist.readArtistInfoAsJson();
        String name = formatName(artistArray);

        String id = formatID(artistArray);
        String uri = formatUri(artistArray);
        String total = formatTotal(artistArray);

        return String.format("Name: %s\nId: %s\nUri: %s\nFollower Total: %s",
                name,id,uri,total);
    }

    private String formatName(JSONArray artistArray){
        JSONArray nameArray = JsonPath.read(artistArray, "$..name");
        return nameArray.get(0).toString();
    }
    private String formatID(JSONArray artistArray){
        JSONArray idArray = JsonPath.read(artistArray, "$..id");
        return idArray.get(0).toString();
    }
    private String formatUri(JSONArray artistArray){
        JSONArray uriArray = JsonPath.read(artistArray, "$..uri");
        return uriArray.get(0).toString();
    }
    private String formatTotal(JSONArray artistArray){
        JSONArray totalArray = JsonPath.read(artistArray, "$..total");
        return totalArray.get(0).toString();
    }
}
