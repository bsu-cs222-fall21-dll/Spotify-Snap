package model.parserTests.hashTableTests;

import com.jayway.jsonpath.JsonPath;
import model.parser.hashtable.AlbumHashTableBuilder;
import model.parser.hashtable.HashTableBuilder;
import model.type.Album;
import model.parser.hashtable.AlbumHashTable;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class HashTableBuilderTest {

    @Test
    public void readAlbumInfoAsJsonTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("albums.json");
        JSONArray inputArray = JsonPath.read(inputStream,"$..items");

        AlbumHashTable albumHashTable = new AlbumHashTable();
        HashTableBuilder hashTableBuilder = new AlbumHashTableBuilder(inputArray);
        hashTableBuilder.buildHashTable(albumHashTable);

        String testJsonString = "[[{\"name\":\"Dark Lane Demo Tapes\"," +
                "\"id\":\"6OQ9gBfg5EXeNAEwGSs6jK\",\"uri\":\"spotify:album:6OQ9gBfg5EXeNAEwGSs6jK\"," +
                "\"date\":\"2020-05-01\"," + "\"total_tracks\":\"14\",\"index\":\"2\"}]]";
        Album album = (Album) albumHashTable.readAtKey("6OQ9gBfg5EXeNAEwGSs6jK");

        JSONArray albumJsonArray = album.readAlbumInfoAsJson();
        JSONArray testArray = JsonPath.read(testJsonString,"$.*");
        Assertions.assertEquals(testArray,albumJsonArray);
    }
}
