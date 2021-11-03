package model.parserTests;

import com.jayway.jsonpath.JsonPath;
import model.parser.Album;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class AlbumTest {

    @Test
    public void readAlbumInfoAsJsonTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("albums.json");
        JSONArray inputArray = JsonPath.read(inputStream,"$..items");

        Album album = new Album(inputArray,0);
        String testJsonString = "[[{\"name\":\"Certified Lover Boy\"," +
                "\"id\":\"3SpBlxme9WbeQdI9kx7KAV\",\"uri\":\"spotify:album:3SpBlxme9WbeQdI9kx7KAV\"," +
                "\"date\":\"2021-09-03\"," + "\"total_tracks\":\"21\"}]]";

        JSONArray artistJsonArray = album.readAlbumInfoAsJson();
        JSONArray testArray = JsonPath.read(testJsonString,"$.*");
        Assertions.assertEquals(testArray,artistJsonArray);
    }
}
