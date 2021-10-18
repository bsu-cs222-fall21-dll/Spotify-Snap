package model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class Searcher {


    //Assume accurate Search, and thus parses for the id of the most relevant search result
    public String parseId(JSONArray testArray) {
        JSONArray idList = JsonPath.read(testArray, "$..id");
        return idList.get(0).toString();
    }



}
