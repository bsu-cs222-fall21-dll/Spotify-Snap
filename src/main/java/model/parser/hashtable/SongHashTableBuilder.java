package model.parser.hashtable;
import model.type.Song;
import net.minidev.json.JSONArray;

public class SongHashTableBuilder extends HashTableBuilder {


    public SongHashTableBuilder(JSONArray inputArray) {
        super(inputArray);


    }

    @Override
    public void buildHashTable(SnapHashTable snapHashTable) {

        for(int index=0; calculateArraySize("duration_ms")>index; index++){
            String songID = parseInfo("[*].id",index);
            Song songToBeAdded = new Song(inputArray,index);
            snapHashTable.place(songID,songToBeAdded);
        }
    }
}
