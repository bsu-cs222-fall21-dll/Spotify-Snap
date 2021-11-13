package model.parser;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import view.MissingArtist;
import view.ParsingErrorHandler;

public abstract class Parser {

    private JSONArray infoArray;

    public Parser(JSONArray infoArray) {
        this.infoArray = infoArray;
    }

    public String parseInfo(String valueToBeRead){
        try {
            return parseFromJson(valueToBeRead,0);
        } catch (IndexOutOfBoundsException e){
            handleErrorMessage();
            return "Artist Not Found";
        }
    }

    public String parseInfo(String valueToBeRead,int index){
        try {
            return parseFromJson(valueToBeRead,index);
        } catch (IndexOutOfBoundsException e){
            handleErrorMessage();
            return "Artist Not Found";
        }
    }

    private String parseFromJson(String valueToBeRead,int index){
        JSONArray itemArray = JsonPath.read(infoArray, String.format("$..%s", valueToBeRead));
        return itemArray.get(index).toString();
    }

    private void handleErrorMessage(){
        ParsingErrorHandler parsingErrorHandler = new ParsingErrorHandler();
        parsingErrorHandler.printError();
    }
}
