package model.parserTests;

import com.jayway.jsonpath.JsonPath;
import model.parser.type.Song;
import model.parser.formatter.SongFormatter;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class SongFormatterTest {

    @Test
    public void formatAlbumTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("songs.json");
        JSONArray testArray = JsonPath.read(inputStream,"$..items");


        Song song = new Song(testArray,0);
        SongFormatter songFormatter = new SongFormatter(song);
        String formattedArtist = songFormatter.format();

        String expected = """

                Song Name: Champagne Poetry
                Song Id: 2HSmyk2qMN8WQjuGhaQgCk
                Uri: spotify:track:2HSmyk2qMN8WQjuGhaQgCk
                Duration in MS: 336511
                Explicit: true
                Track Number: 1
                """;
        Assertions.assertEquals(expected,formattedArtist);
    }
}
