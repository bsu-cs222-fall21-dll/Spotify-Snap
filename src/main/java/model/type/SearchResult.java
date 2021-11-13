package model.type;

import model.parser.Parser;
import net.minidev.json.JSONArray;

public class SearchResult extends Parser {

    public SearchResult(JSONArray searchResultArray) {
        super(searchResultArray);
    }
}