package model.parserTests;

import com.jayway.jsonpath.JsonPath;
import model.parser.Album;
import model.parser.Song;
import model.parser.hashtable.*;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class SongHashTableBuilderTest {

    @Test
    public void readAlbumInfoAsJsonTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("songs.json");
        JSONArray inputArray = JsonPath.read(inputStream,"$..items");

        SongHashTable songHashTable = new SongHashTable();
        HashTableBuilder hashTableBuilder = new SongHashTableBuilder(inputArray);
        hashTableBuilder.buildHashTable(songHashTable);

        String testJsonString = "[[{\"name\":\"Champagne Poetry\"," +
                "\"id\":\"2HSmyk2qMN8WQjuGhaQgCk\",\"uri\":\"spotify:track:2HSmyk2qMN8WQjuGhaQgCk\"," +
                "\"duration_ms\":\"336511\"," + "\"index\":\"1\",\"explicit\":\"true\"}]]";
        Song song = (Song) songHashTable.readAtKey("2HSmyk2qMN8WQjuGhaQgCk");

        JSONArray albumJsonArray = song.readSongInfoAsJson();
        JSONArray testArray = JsonPath.read(testJsonString,"$.*");
        Assertions.assertEquals(testArray,albumJsonArray);
    }
}


