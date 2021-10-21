package model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class ArtistTest {

    @Test
    public void readArtistInfoAsJsonTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("TestArtist.json");
        JSONArray inputArray = JsonPath.read(inputStream,"$.*");

        Artist testArtist = new Artist(inputArray);
        String testJsonString = "{\"artist\": [{\"name\": \"Slayer\", \"id\": \"1IQ2e1buppatiN1bxUVkrk\",\"uri\": " +
                "\"spotify:artist:1IQ2e1buppatiN1bxUVkrk\", \"total\": \"2751373\"}]}";

        JSONArray artistJsonArray = testArtist.readArtistInfoAsJson();
        JSONArray testArray = JsonPath.read(testJsonString,"$.*");
        Assertions.assertEquals(testArray,artistJsonArray);
    }
}
