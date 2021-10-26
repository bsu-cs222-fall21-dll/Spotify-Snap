package model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class SnapArtistTest {

    @Test
    public void readArtistInfoAsJsonTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("newResults.json");
        JSONArray inputArray = JsonPath.read(inputStream,"$..items");

        SnapArtist testSnapArtist = new SnapArtist(inputArray);
        String testJsonString = "{\"artist\": [{\"name\": \"Drake\", \"id\": \"3TVXtAsR1Inumwj472S9r4\",\"uri\": " +
                "\"spotify:artist:3TVXtAsR1Inumwj472S9r4\", \"total\": \"58055243\"}]}";

        JSONArray artistJsonArray = testSnapArtist.readArtistInfoAsJson();
        JSONArray testArray = JsonPath.read(testJsonString,"$.*");
        Assertions.assertEquals(testArray,artistJsonArray);
    }
}
