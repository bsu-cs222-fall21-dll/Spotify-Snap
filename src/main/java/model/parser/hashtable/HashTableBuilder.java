package model.parser.hashtable;

import model.parser.Parser;
import model.type.Album;
import net.minidev.json.JSONArray;

public abstract class HashTableBuilder extends Parser {

    private final JSONArray inputArray;

    public HashTableBuilder(JSONArray inputArray) {

        super(inputArray);
        this.inputArray = inputArray;
    }

    public void buildHashTable(SnapHashTable snapHashTable) {

        for(int index=0; parseInfo("id").length()>index;index+=2){

            String snapID = parseInfo("id",index);
            Album albumToBeAdded = new Album(inputArray,index);
            snapHashTable.place(String.format("%d",index/2),albumToBeAdded);
        }
    }
}
