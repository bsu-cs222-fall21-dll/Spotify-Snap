package model.parser.hashtable;

import model.type.Album;
import model.type.Song;
import net.minidev.json.JSONArray;

public class AlbumHashTableBuilder extends HashTableBuilder{
    public AlbumHashTableBuilder(JSONArray inputArray) {
        super(inputArray);
    }


    @Override
    public void buildHashTable(SnapHashTable snapHashTable) {
        /*
          Loops over the JsonArray Provided from Spotify, and parses each Object into the input HashTable
          The construction is handled via the Parser super class.

          @param snapHashTable the Hashtable used to store the Objects
         */


        for(int index=0; calculateArraySize("total_tracks")>index; index++){
            String albumIndex = String.format("%d",index);
            Album albumToBeAdded = new Album(inputArray,index);
            snapHashTable.place(albumIndex,albumToBeAdded);

        }

    }
}
