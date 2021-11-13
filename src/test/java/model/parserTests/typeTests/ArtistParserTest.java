package model.parserTests.typeTests;

import com.jayway.jsonpath.JsonPath;
import model.type.SearchResult;
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
        SearchResult searchResult = new SearchResult(testArray);

        String result = searchResult.parseInfo("id");
        Assertions.assertEquals("3TVXtAsR1Inumwj472S9r4",result);

    }

    @Test
    public void parseNameTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("newResults.json");
        JSONArray testArray = JsonPath.read(inputStream,"$..items");
        SearchResult searchResult = new SearchResult(testArray);

        String result = searchResult.parseInfo("name");
        Assertions.assertEquals("Drake",result);

    }
    @Test
    public void parseUriTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("newResults.json");
        JSONArray testArray = JsonPath.read(inputStream,"$..items");
        SearchResult searchResult = new SearchResult(testArray);

        String result = searchResult.parseInfo("uri");
        Assertions.assertEquals("spotify:artist:3TVXtAsR1Inumwj472S9r4",result);

    }

    @Test
    public void parseFollowerTotalTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("newResults.json");
        JSONArray testArray = JsonPath.read(inputStream,"$..items");
        SearchResult searchResult = new SearchResult(testArray);

        String result = searchResult.parseInfo("total");
        Assertions.assertEquals("58055243",result);
    }


}
