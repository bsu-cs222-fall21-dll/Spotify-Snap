package model.parser;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public abstract class Parser {

    private JSONArray infoArray;

    public Parser(JSONArray infoArray) {
        this.infoArray = infoArray;
    }

    public String parseInfo(String valueToBeRead){
        JSONArray itemArray = JsonPath.read(infoArray, String.format("$..%s", valueToBeRead));
        return itemArray.get(0).toString();
    }
}
