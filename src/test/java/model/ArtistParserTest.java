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

        String result = artistParser.parseId(testArray);
        Assertions.assertEquals("1IQ2e1buppatiN1bxUVkrk",result);

    }

    @Test
    public void parseNameTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("TestArtist.json");
        JSONArray testArray = JsonPath.read(inputStream,"$.*");
        ArtistParser artistParser = new ArtistParser();

        String result = artistParser.parseName(testArray);
        Assertions.assertEquals("Slayer",result);

    }
    @Test
    public void parseUriTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("TestArtist.json");
        JSONArray inputArray = JsonPath.read(inputStream,"$.*");
        ArtistParser artistParser = new ArtistParser();

        String result = artistParser.parseUri(inputArray);
        Assertions.assertEquals("spotify:artist:1IQ2e1buppatiN1bxUVkrk",result);

    }

}
