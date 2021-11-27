package model.parser.hashtable;


import model.parser.formatter.AlbumFormatter;
import model.type.Album;
import model.type.SnapObject;

import java.util.HashMap;

public abstract class SnapHashTable {
    protected HashMap<String, SnapObject> snapHashMap = new HashMap<>();
    protected String[] snapArray;

    public void place(String snapIndex, SnapObject snapObject) {
        snapHashMap.put(snapIndex,snapObject);

    }

    public Object readAtKey(String snapIndex) {
        return snapHashMap.get(snapIndex);
    }

    public String formatTable() {
        /*
          Loops over the elements in the array of sorted elements and converts them into a string

          @return snapsString The Hashtable information sorted and then converted into a string using the objects built in method
         */
        sortHashMapIntoArrayList();
        String snapsString = "";
        for (int index=0;index<snapArray.length;index++) {

            snapsString = String.format("%sIndex: %d%s\n\n", snapsString,index+1,snapArray[index]);
        }

        return snapsString;
    }

    public void sortHashMapIntoArrayList(){
        /*
          Loops over the elements in the HashMap and assigns them an index value into an array.
          The index value is associated with a value stored in the Object
         */
        int sizeOfArrayList = snapHashMap.size();
        String[] sortedAlbumArray = new String[sizeOfArrayList];
        snapHashMap.forEach((snapIndex, snapObject) -> {

            AlbumFormatter albumFormatter = new AlbumFormatter((Album) snapObject);
            String albumString = albumFormatter.format();
            int index = Integer.parseInt(albumFormatter.parseInfo("index"));
            sortedAlbumArray[index] = albumString;

        });
        this.snapArray = sortedAlbumArray;
    }
}
