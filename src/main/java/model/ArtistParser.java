package model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class ArtistParser {
    //Becomes of how Spotify Structures its Json Files, the keys are lost when it is parsed from an input stream. Thus
    //indexes are used to find the correct position of the data we need in the json

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

    //since the id of total isnt lost it can just be used
    public String parseArtistFollowersTotal(JSONArray inputArray) {
        JSONArray arrayContents = JsonPath.read(inputArray, "$..total");
        return arrayContents.get(0).toString();
    }
}
