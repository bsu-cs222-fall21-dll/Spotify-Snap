package model.parser;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class SearchResultParser {

    private JSONArray searchResultArray;

    public SearchResultParser(JSONArray searchResultArray) {
        this.searchResultArray = searchResultArray;
    }

    public String parseArtistInfo(String itemToBeParsed) {
        JSONArray arrayContents = JsonPath.read(searchResultArray, String.format("$..%s",itemToBeParsed));
        return arrayContents.get(0).toString();
    }


}
