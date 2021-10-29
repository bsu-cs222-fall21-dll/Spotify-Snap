package model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class AlbumFormatter {

    private JSONArray albumArray;

    public AlbumFormatter(Album album) {
        this.albumArray = album.readAlbumInfoAsJson();
    }

    public String formatSnapArtist() {
        String name = formatValueInAlbumJson("name");
        String id = formatValueInAlbumJson("id");
        String uri = formatValueInAlbumJson("uri");
        String date = formatValueInAlbumJson("date");
        String total = formatValueInAlbumJson("total_tracks");

        return String.format("\nAlbum Name: %s\nAlbum Id: %s\nUri: %s\nRelease Date: %s\nTotal Tracks: %s",
                name,id,uri,date,total);
    }

    private String formatValueInAlbumJson(String valueToBeRead) {
        JSONArray itemArray = JsonPath.read(albumArray, String.format("$..%s", valueToBeRead));
        return itemArray.get(0).toString();
    }
}
