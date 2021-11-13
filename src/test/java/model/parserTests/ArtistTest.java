package model.parserTests;

import com.jayway.jsonpath.JsonPath;
import model.type.Artist;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class ArtistTest {

    @Test
    public void readArtistInfoAsJsonTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("newResults.json");
        JSONArray inputArray = JsonPath.read(inputStream,"$..items");

        Artist testArtist = new Artist(inputArray);
        String testJsonString = "[[{\"name\":\"Drake\"," +
                "\"id\":\"3TVXtAsR1Inumwj472S9r4\",\"uri\":\"spotify:artist:3TVXtAsR1Inumwj472S9r4\"," +
                "\"url\":\"https:\\/\\/open.spotify.com\\/artist\\/3TVXtAsR1Inumwj472S9r4\"," +
                "\"total\":\"58055243\"}]]";

        JSONArray artistJsonArray = testArtist.readArtistInfoAsJson();
        JSONArray testArray = JsonPath.read(testJsonString,"$.*");
        Assertions.assertEquals(testArray,artistJsonArray);
    }
}
