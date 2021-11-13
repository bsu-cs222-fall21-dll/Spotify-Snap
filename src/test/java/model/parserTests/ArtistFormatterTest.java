package model.parserTests;

import com.jayway.jsonpath.JsonPath;
import model.parser.formatter.ArtistFormatter;
import model.parser.type.Artist;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class ArtistFormatterTest {

    @Test public void formatSnapArtistTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("newResults.json");
        JSONArray testArray = JsonPath.read(inputStream,"$..items");


        Artist artist = new Artist(testArray);
        ArtistFormatter artistFormatter = new ArtistFormatter(artist);
        String formattedArtist = artistFormatter.format();

        String expected = "\nArtist Name: Drake\nArtist Id: 3TVXtAsR1Inumwj472S9r4\nExternal URL: https://open.spotify.com/artist/3TVXtAsR1Inumwj472S9r4\nUri: spotify:artist:3TVXtAsR1Inumwj472S9r4\nFollower Count: 58055243";
        Assertions.assertEquals(expected,formattedArtist);
    }
}
