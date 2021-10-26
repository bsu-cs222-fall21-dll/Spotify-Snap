package model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class ArtistParser {


    public String parseArtistId(JSONArray inputArray) {
        JSONArray arrayContents = JsonPath.read(inputArray, "$..id");
        return arrayContents.get(0).toString();
    }

    public String parseArtistName(JSONArray inputArray) {
        JSONArray arrayContents = JsonPath.read(inputArray, "$..name");
        return arrayContents.get(0).toString();
    }

    public String parseArtistUri(JSONArray inputArray) {
        JSONArray arrayContents = JsonPath.read(inputArray, "$..uri");
        return arrayContents.get(0).toString();
    }

    public String parseExternalUrl(JSONArray inputArray) {
        JSONArray arrayContents = JsonPath.read(inputArray, "$..spotify");
        return arrayContents.get(0).toString();
    }

    public String parseArtistFollowersTotal(JSONArray inputArray) {
        JSONArray arrayContents = JsonPath.read(inputArray, "$..total");
        return arrayContents.get(0).toString();
    }
}
