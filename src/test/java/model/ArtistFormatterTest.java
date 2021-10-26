package model;

import com.jayway.jsonpath.JsonPath;
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


        SnapArtist snapArtist = new SnapArtist(testArray);
        ArtistFormatter artistFormatter = new ArtistFormatter(snapArtist);
        String formattedArtist = artistFormatter.formatSnapArtist();

        String expected = "Name: Drake\nId: 3TVXtAsR1Inumwj472S9r4\nUri: spotify:artist:3TVXtAsR1Inumwj472S9r4\nFollower Total: 58055243";
        Assertions.assertEquals(expected,formattedArtist);
    }
}
