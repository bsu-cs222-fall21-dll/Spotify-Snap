package model.parser;

import net.minidev.json.JSONArray;

import java.util.HashMap;

public class AlbumHashTable {

    private HashMap<String,Album> albumHashMap = new HashMap<>();

    public void place(String albumID, Album album) {
        albumHashMap.put(albumID,album);
    }

    public Album readAtKey(String albumID) {
        return albumHashMap.get(albumID);
    }

}
