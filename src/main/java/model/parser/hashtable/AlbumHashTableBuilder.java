package model.parser.hashtable;

import model.type.Album;
import net.minidev.json.JSONArray;

public class AlbumHashTableBuilder extends HashTableBuilder{
    public AlbumHashTableBuilder(JSONArray inputArray) {
        super(inputArray);
    }


    @Override
    public void buildHashTable(SnapHashTable snapHashTable) {

        for(int index=0; calculateArraySize("total_tracks")>index; index++){
            String albumIndex = String.format("%d",index);
            Album albumToBeAdded = new Album(inputArray,index);
            snapHashTable.place(albumIndex,albumToBeAdded);

        }

    }
}
