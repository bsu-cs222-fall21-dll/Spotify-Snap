package model.parserTests;

import com.jayway.jsonpath.JsonPath;
import model.parser.type.Album;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class AlbumWithIndexesTest {


    @Test
    public void readAlbumInfoFromIndexTwoAsJsonTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("albums.json");
        JSONArray inputArray = JsonPath.read(inputStream,"$..items");

        Album album = new Album(inputArray,2);
        String testJsonString = "[[{\"name\":\"Certified Lover Boy\"," +
                "\"id\":\"6sp02aeyiwfX35xRqwNiPv\",\"uri\":\"spotify:album:6sp02aeyiwfX35xRqwNiPv\"," +
                "\"date\":\"2021-09-02\"," + "\"total_tracks\":\"21\",\"index\":\"1\"}]]";

        JSONArray albumJsonArray = album.readAlbumInfoAsJson();
        JSONArray testArray = JsonPath.read(testJsonString,"$.*");
        Assertions.assertEquals(testArray,albumJsonArray);
    }

    @Test
    public void readAlbumInfoFromIndexFourAsJsonTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("albums.json");
        JSONArray inputArray = JsonPath.read(inputStream,"$..items");

        Album album = new Album(inputArray,4);
        String testJsonString = "[[{\"name\":\"Dark Lane Demo Tapes\"," +
                "\"id\":\"6OQ9gBfg5EXeNAEwGSs6jK\",\"uri\":\"spotify:album:6OQ9gBfg5EXeNAEwGSs6jK\"," +
                "\"date\":\"2020-05-01\"," + "\"total_tracks\":\"14\",\"index\":\"2\"}]]";

        JSONArray albumJsonArray = album.readAlbumInfoAsJson();
        JSONArray testArray = JsonPath.read(testJsonString,"$.*");
        Assertions.assertEquals(testArray,albumJsonArray);
    }

}
