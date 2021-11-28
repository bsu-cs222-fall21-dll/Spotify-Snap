package model.parser;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import view.console.ParsingErrorHandler;

public abstract class Parser {

    protected final JSONArray infoArray;

    public Parser(JSONArray infoArray) {
        this.infoArray = infoArray;
    }

    public String parseInfo(String valueToBeRead){
        /*
          Returns the parsed String from a Json array using the default index of zero

          @param valueToBeRead the key of the parsed values in the JsonArray
         * @return              the parsed String in Json form
         */
        return handleError(valueToBeRead,0);
    }

    public String parseInfo(String valueToBeRead,int index){
        /*
          Returns the parsed String from a Json array

          @param valueToBeRead the key of the parsed values in the JsonArray
         * @param index         the index of the value to be parsed from the JsonArray
         * @return              the parsed String in Json form
         */
        return handleError(valueToBeRead,index);
    }

    private String parseFromJson(String valueToBeRead,int index){
        JSONArray itemArray = JsonPath.read(infoArray, String.format("$..%s", valueToBeRead));
        return itemArray.get(index).toString();
    }

    private void readErrorMessage(){
        ParsingErrorHandler parsingErrorHandler = new ParsingErrorHandler();
        parsingErrorHandler.printError();
    }

    private String handleError(String valueToBeRead, int index){
        try {
            return parseFromJson(valueToBeRead,index);
        } catch (IndexOutOfBoundsException e){
            readErrorMessage();
            return "Info Not Found";
        }
    }

    public int calculateArraySize(String elementSizeToBeCalculated){
        JSONArray itemArray = JsonPath.read(infoArray, String.format("$..%s", elementSizeToBeCalculated));
        return itemArray.size();
    }
}
