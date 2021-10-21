package model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class ArtistParser {
    //Becomes of how Spotify Structures its Json Files, the keys are lost when it is parsed from an input stream. Thus
    //indexes are used to find the correct position of the data we need in the json

    public String parseId(JSONArray inputArray) {
        JSONArray idList = JsonPath.read(inputArray, "$..[4]");
        return idList.get(0).toString();
    }

    public String parseName(JSONArray inputArray) {
        JSONArray idList = JsonPath.read(inputArray, "$..[6]");
        return idList.get(0).toString();
    }

    public String parseUri(JSONArray inputArray) {
        JSONArray idList = JsonPath.read(inputArray, "$..[9]");
        return idList.get(0).toString();
    }
}
