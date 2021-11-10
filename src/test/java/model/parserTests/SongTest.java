package model.parserTests;

import com.jayway.jsonpath.JsonPath;
import model.parser.Song;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class SongTest {

    @Test
    public void readSongInfoAsJsonTest() throws IOException {

        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("songs.json");
        JSONArray inputArray = JsonPath.read(inputStream,"$..items");

        Song song = new Song(inputArray,0);
        String testJsonString = "[[{\"name\":\"Champagne Poetry\"," +
                "\"id\":\"2HSmyk2qMN8WQjuGhaQgCk\",\"uri\":\"spotify:track:2HSmyk2qMN8WQjuGhaQgCk\"," +
                "\"duration_ms\":\"336511\"," + "\"track_number\":\"1\",\"explicit\":\"true\"}]]";

        JSONArray songJsonArray = song.readSongInfoAsJson();
        JSONArray testArray = JsonPath.read(testJsonString,"$.*");
        Assertions.assertEquals(testArray,songJsonArray);
    }
}
