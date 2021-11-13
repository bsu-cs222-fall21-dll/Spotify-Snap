package model.parserTests;

import com.jayway.jsonpath.JsonPath;
import model.parser.type.SearchResult;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class AlbumParserTest {

    @Test
    public void parseAlbumNameTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("albums.json");
        JSONArray testArray = JsonPath.read(inputStream,"$..items");

        SearchResult searchResult = new SearchResult(testArray);
        String result = searchResult.parseInfo("name");
        Assertions.assertEquals("Certified Lover Boy",result);
    }

    @Test
    public void parseIdTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("albums.json");
        JSONArray testArray = JsonPath.read(inputStream,"$..items");
        SearchResult searchResult = new SearchResult(testArray);

        String result = searchResult.parseInfo("id");
        Assertions.assertEquals("3SpBlxme9WbeQdI9kx7KAV",result);

    }

    @Test
    public void parseUriTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("albums.json");
        JSONArray testArray = JsonPath.read(inputStream,"$..items");
        SearchResult searchResult = new SearchResult(testArray);

        String result = searchResult.parseInfo("uri");
        Assertions.assertEquals("spotify:album:3SpBlxme9WbeQdI9kx7KAV",result);

    }
    @Test
    public void parseReleaseDate() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("albums.json");
        JSONArray testArray = JsonPath.read(inputStream,"$..items");
        SearchResult searchResult = new SearchResult(testArray);

        String result = searchResult.parseInfo("release_date");
        Assertions.assertEquals("2021-09-03",result);
    }
    @Test
    public void parseTotalTracks() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("albums.json");
        JSONArray testArray = JsonPath.read(inputStream,"$..items");
        SearchResult searchResult = new SearchResult(testArray);

        String result = searchResult.parseInfo("total_tracks");
        Assertions.assertEquals("21",result);
    }

}
