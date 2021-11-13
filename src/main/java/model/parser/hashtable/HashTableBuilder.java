package model.parser.hashtable;

import model.parser.Album;
import model.parser.Parser;
import net.minidev.json.JSONArray;

public abstract class HashTableBuilder extends Parser {

    private JSONArray inputArray;

    public HashTableBuilder(JSONArray inputArray) {

        super(inputArray);
        this.inputArray = inputArray;
    }

    public void buildHashTable(SnapHashTable snapHashTable) {

        for(int index=0; parseInfo("id").length()>index;index+=2){

            String snapID = parseInfo("id",index);
            Album albumToBeAdded = new Album(inputArray,index);
            snapHashTable.place(snapID,albumToBeAdded);
        }
    }
}
