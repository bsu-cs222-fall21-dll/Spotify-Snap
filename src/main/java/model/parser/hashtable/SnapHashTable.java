package model.parser.hashtable;

import model.parser.Album;
import model.parser.formatter.AlbumFormatter;

import java.util.HashMap;

public abstract class SnapHashTable {
    protected HashMap<String,Object> snapHashMap = new HashMap<>();
    private String[] snapArray;

    public void place(String albumID, Object snapObj) {
        snapHashMap.put(albumID,snapObj);

    }

    public Object readAtKey(String snapId) {
        return snapHashMap.get(snapId);
    }

    public String formatTable() {
        this.snapArray = sortHashMapIntoArrayList();
        String snapsString = "";
        for (String currentSnapString : snapArray) {
            snapsString = String.format("%s%s\n", snapsString,currentSnapString);
        }

        return snapsString;
    }

    public String[] sortHashMapIntoArrayList(){
        int sizeOfArrayList = snapHashMap.size();

        String[] sortedAlbumArray = new String[sizeOfArrayList];
        snapHashMap.forEach((snapId, snapObject) -> {

            AlbumFormatter albumFormatter = new AlbumFormatter((Album) snapObject);
            String albumString = albumFormatter.format();
            int index = Integer.parseInt(albumFormatter.parseInfo("index"));

            sortedAlbumArray[index] = albumString;

        });
        return sortedAlbumArray;
    }
}
