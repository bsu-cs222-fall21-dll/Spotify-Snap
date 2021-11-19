package model.parserTests.hashTableTests;

import com.jayway.jsonpath.JsonPath;
import model.type.Song;
import model.parser.hashtable.*;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class SongHashTableBuilderTest {


    @Test
    public void readSongInfoAsJsonFromSecondFileTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("diabolusInMusicaSongsTest.json");
        JSONArray inputArray = JsonPath.read(inputStream,"$..[*]");

        SongHashTable songHashTable = new SongHashTable();
        HashTableBuilder hashTableBuilder = new SongHashTableBuilder(inputArray);
        hashTableBuilder.buildHashTable(songHashTable);

        String testJsonString = "[[{\"name\":\"Bitter Peace\",\"id\":\"7Amiwp5D26ULS0qgMRPkpa\",\"uri\":" +
                "\"spotify:track:7Amiwp5D26ULS0qgMRPkpa\",\"duration_ms\":\"272080\",\"index\":\"1\",\"explicit\":\"true\"}]]";

        Song song = (Song) songHashTable.readAtKey("7Amiwp5D26ULS0qgMRPkpa");

        JSONArray albumJsonArray = song.readSongInfoAsJson();
        JSONArray testArray = JsonPath.read(testJsonString,"$.*");
        Assertions.assertEquals(testArray,albumJsonArray);
    }

    @Test
    public void readSongInfoAsJsonTest() throws IOException {
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


