package model.parserTests;

import com.jayway.jsonpath.JsonPath;
import model.parser.SearchResultParser;
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

        SearchResultParser searchResultParser = new SearchResultParser(testArray);
        String result = searchResultParser.parseArtistInfo("name");
        Assertions.assertEquals("Certified Lover Boy",result);
    }

    @Test
    public void parseIdTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("albums.json");
        JSONArray testArray = JsonPath.read(inputStream,"$..items");
        SearchResultParser searchResultParser = new SearchResultParser(testArray);

        String result = searchResultParser.parseArtistInfo("id");
        Assertions.assertEquals("3SpBlxme9WbeQdI9kx7KAV",result);

    }

    @Test
    public void parseUriTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("albums.json");
        JSONArray testArray = JsonPath.read(inputStream,"$..items");
        SearchResultParser searchResultParser = new SearchResultParser(testArray);

        String result = searchResultParser.parseArtistInfo("uri");
        Assertions.assertEquals("spotify:album:3SpBlxme9WbeQdI9kx7KAV",result);

    }
    @Test
    public void parseReleaseDate() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("albums.json");
        JSONArray testArray = JsonPath.read(inputStream,"$..items");
        SearchResultParser searchResultParser = new SearchResultParser(testArray);

        String result = searchResultParser.parseArtistInfo("release_date");
        Assertions.assertEquals("2021-09-03",result);
    }
    @Test
    public void parseTotalTracks() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("albums.json");
        JSONArray testArray = JsonPath.read(inputStream,"$..items");
        SearchResultParser searchResultParser = new SearchResultParser(testArray);

        String result = searchResultParser.parseArtistInfo("total_tracks");
        Assertions.assertEquals("21",result);
    }

}
