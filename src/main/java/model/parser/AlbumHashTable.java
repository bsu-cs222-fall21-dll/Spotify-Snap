package model.parser;

import net.minidev.json.JSONArray;

import java.util.HashMap;

public class AlbumHashTable {

    private HashMap<String,Album> albumHashMap = new HashMap<>();

    public void place(String albumName, Album album) {
        albumHashMap.put(albumName,album);
    }

    public Album readAtKey(String albumName) {
        return albumHashMap.get(albumName);
    }
}
