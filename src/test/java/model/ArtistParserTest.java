package model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class ArtistParserTest {

    @Test
    public void parseIdTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("TestArtist.json");
        JSONArray testArray = JsonPath.read(inputStream,"$.*");
        ArtistParser artistParser = new ArtistParser();

        String result = artistParser.parseArtistId(testArray);
        Assertions.assertEquals("1IQ2e1buppatiN1bxUVkrk",result);

    }

    @Test
    public void parseNameTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("TestArtist.json");
        JSONArray testArray = JsonPath.read(inputStream,"$.*");
        ArtistParser artistParser = new ArtistParser();

        String result = artistParser.parseArtistName(testArray);
        Assertions.assertEquals("Slayer",result);
    }

    @Test
    public void parseUriTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("TestArtist.json");
        JSONArray inputArray = JsonPath.read(inputStream,"$.*");
        ArtistParser artistParser = new ArtistParser();

        String result = artistParser.parseArtistUri(inputArray);
        Assertions.assertEquals("spotify:artist:1IQ2e1buppatiN1bxUVkrk",result);

    }
    @Test
    public void parseArtistFollowersTotalTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("TestArtist.json");
        JSONArray inputArray = JsonPath.read(inputStream,"$.*");
        ArtistParser artistParser = new ArtistParser();

        String result = artistParser.parseArtistFollowersTotal(inputArray);
        Assertions.assertEquals("2751373",result);

    }

}
