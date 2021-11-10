package model.parser.hashtable;

import model.parser.Album;
import model.parser.Parser;
import model.parser.hashtable.AlbumHashTable;
import net.minidev.json.JSONArray;

public class AlbumHashTableBuilder extends Parser {

    private JSONArray inputArray;

    public AlbumHashTableBuilder(JSONArray inputArray) {

        super(inputArray);
        this.inputArray = inputArray;
    }

    public void buildHashTable(AlbumHashTable albumHashTable) {

        for(int index=0; parseInfo("id").length()>index;index+=2){

            String albumID = parseInfo("id",index);
            Album albumToBeAdded = new Album(inputArray,index);
            albumHashTable.place(albumID,albumToBeAdded);
        }
    }
}
