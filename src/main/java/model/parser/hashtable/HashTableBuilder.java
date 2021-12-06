package model.parser.hashtable;

import model.parser.Parser;
import model.type.Artist;
import model.type.SnapObject;
import net.minidev.json.JSONArray;

public abstract class HashTableBuilder extends Parser {

    protected final JSONArray inputArray;

    public HashTableBuilder(JSONArray inputArray) {

        super(inputArray);
        this.inputArray = inputArray;
    }

    public void buildHashTable(SnapHashTable snapHashTable) {

        for(int index=0; calculateArraySize("name")>index;index++){

            SnapObject snapObject = new Artist(inputArray);
            snapHashTable.place(String.format("%d",index),snapObject);
        }
    }
}
