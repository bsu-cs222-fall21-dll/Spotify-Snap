package model.parser;

import java.util.HashMap;

public class AlbumHashTable {

    private HashMap<String,Album> albumHashMap = new HashMap<>();

    public void place(String albumID, Album album) {

        albumHashMap.put(albumID,album);
    }

    public Album readAtKey(String albumID) {
        return albumHashMap.get(albumID);
    }

    public String formatTable() {

        String[] albumArray = sortHashMapIntoArrayList();
        String albumsString = "";

        for (String currentAlbumString : albumArray) {
            albumsString = String.format("%s%s\n", albumsString, currentAlbumString);
        }

        return albumsString;
    }

    private String[] sortHashMapIntoArrayList(){
        int sizeOfArrayList = albumHashMap.size();

        String[] sortedAlbumArray = new String[sizeOfArrayList];
        albumHashMap.forEach((albumID,album) -> {

            AlbumFormatter albumFormatter = new AlbumFormatter(album);
            String albumString = albumFormatter.formatAlbum();
            int index = Integer.parseInt(albumFormatter.parseInfo("index"));

            sortedAlbumArray[index] = albumString;

        });
        return sortedAlbumArray;
    }
}
