package model.parserTests;

import com.jayway.jsonpath.JsonPath;
import model.parser.SearchResultParser;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class ArtistParserTest {

    @Test
    public void parseIdTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("newResults.json");
        JSONArray testArray = JsonPath.read(inputStream,"$..items");
        SearchResultParser searchResultParser = new SearchResultParser(testArray);

        String result = searchResultParser.parseArtistInfo("id");
        Assertions.assertEquals("3TVXtAsR1Inumwj472S9r4",result);

    }

    @Test
    public void parseNameTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("newResults.json");
        JSONArray testArray = JsonPath.read(inputStream,"$..items");
        SearchResultParser searchResultParser = new SearchResultParser(testArray);

        String result = searchResultParser.parseArtistInfo("name");
        Assertions.assertEquals("Drake",result);

    }
    @Test
    public void parseUriTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("newResults.json");
        JSONArray testArray = JsonPath.read(inputStream,"$..items");
        SearchResultParser searchResultParser = new SearchResultParser(testArray);

        String result = searchResultParser.parseArtistInfo("uri");
        Assertions.assertEquals("spotify:artist:3TVXtAsR1Inumwj472S9r4",result);

    }

    @Test
    public void parseFollowerTotalTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("newResults.json");
        JSONArray testArray = JsonPath.read(inputStream,"$..items");
        SearchResultParser searchResultParser = new SearchResultParser(testArray);

        String result = searchResultParser.parseArtistInfo("total");
        Assertions.assertEquals("58055243",result);
    }


}
