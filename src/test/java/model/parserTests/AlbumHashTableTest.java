package model.parserTests;

import com.jayway.jsonpath.JsonPath;
import model.parser.hashtable.AlbumHashTable;
import model.parser.Album;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class AlbumHashTableTest {

    @Test
    public void readAlbumInfoAsJsonTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("albums.json");
        JSONArray inputArray = JsonPath.read(inputStream,"$..items");

        Album album = new Album(inputArray,0);

        AlbumHashTable albumHashTable = new AlbumHashTable();
        JSONArray albumJsonArray = album.readAlbumInfoAsJson();
        JSONArray albumNameArray = JsonPath.read(albumJsonArray, "$..id");

        String albumName = albumNameArray.get(0).toString();
        albumHashTable.place(albumName,album);
        Assertions.assertEquals(album, albumHashTable.readAtKey("3SpBlxme9WbeQdI9kx7KAV"));
    }
}
