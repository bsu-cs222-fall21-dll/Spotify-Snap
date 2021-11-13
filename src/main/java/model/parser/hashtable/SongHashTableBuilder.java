package model.parser.hashtable;

import model.parser.type.Song;
import net.minidev.json.JSONArray;

public class SongHashTableBuilder extends HashTableBuilder {

    private final JSONArray inputArray;

    public SongHashTableBuilder(JSONArray inputArray) {
        super(inputArray);
        this.inputArray = inputArray;
    }

    @Override
    public void buildHashTable(SnapHashTable snapHashTable) {

        for(int index=0; parseInfo("track_number").length()>index;index++){

            String songID = parseInfo("id",index);
            Song songToBeAdded = new Song(inputArray,index);
            snapHashTable.place(songID,songToBeAdded);
        }
    }
}
