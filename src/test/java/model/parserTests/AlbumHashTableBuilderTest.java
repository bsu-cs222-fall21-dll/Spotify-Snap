package model.parserTests;

import com.jayway.jsonpath.JsonPath;
import model.parser.AlbumHashTableBuilder;
import model.parser.Album;
import model.parser.AlbumHashTable;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class AlbumHashTableBuilderTest {

    @Test
    public void readAlbumInfoAsJsonTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("albums.json");
        JSONArray inputArray = JsonPath.read(inputStream,"$..items");

        AlbumHashTable albumHashTable = new AlbumHashTable();
        AlbumHashTableBuilder albumHashTableBuilder = new AlbumHashTableBuilder(inputArray);
        albumHashTableBuilder.buildHashTable(albumHashTable);

        String testJsonString = "[[{\"name\":\"Dark Lane Demo Tapes\"," +
                "\"id\":\"6OQ9gBfg5EXeNAEwGSs6jK\",\"uri\":\"spotify:album:6OQ9gBfg5EXeNAEwGSs6jK\"," +
                "\"date\":\"2019-08-02\"," + "\"total_tracks\":\"17\",\"index\":\"2\"}]]";
        Album album = albumHashTable.readAtKey("6OQ9gBfg5EXeNAEwGSs6jK");

        JSONArray albumJsonArray = album.readAlbumInfoAsJson();
        JSONArray testArray = JsonPath.read(testJsonString,"$.*");
        Assertions.assertEquals(testArray,albumJsonArray);
    }
}
