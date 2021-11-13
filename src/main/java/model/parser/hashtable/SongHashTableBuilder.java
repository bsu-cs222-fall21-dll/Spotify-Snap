package model.parser.hashtable;

import model.parser.Album;
import model.parser.Song;
import net.minidev.json.JSONArray;

public class SongHashTableBuilder extends HashTableBuilder {

    private JSONArray inputArray;

    public SongHashTableBuilder(JSONArray inputArray) {
        super(inputArray);
        this.inputArray = inputArray;
    }

    @Override
    public void buildHashTable(SnapHashTable snapHashTable) {
        /**
         * Loops over the JsonArray Provided from Spotify, and parses each Object into the input HashTable
         * The construction is handled via the Parser super class.
         *
         * @param snapHashTable the Hashtable used to store the Objects
         */

        for(int index=0; parseInfo("track_number").length()>index;index++){

            String songID = parseInfo("id",index);
            Song songToBeAdded = new Song(inputArray,index);
            snapHashTable.place(songID,songToBeAdded);
        }
    }
}
