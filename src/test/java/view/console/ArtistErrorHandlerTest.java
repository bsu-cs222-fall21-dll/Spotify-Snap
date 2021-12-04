package view.console;

import com.jayway.jsonpath.JsonPath;
import model.type.Artist;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class ArtistErrorHandlerTest {

    @Test
    public void testValidArtist() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("newResults.json");
        JSONArray inputArray = JsonPath.read(inputStream,"$..items");

        CMDArtistErrorHandler cmdArtistErrorHandler = new CMDArtistErrorHandler(inputArray);
        Artist testArtist = cmdArtistErrorHandler.checkIfArtistIsvalid();
        String testJsonString = "[[{\"name\":\"Drake\"," +
                "\"id\":\"3TVXtAsR1Inumwj472S9r4\",\"uri\":\"spotify:artist:3TVXtAsR1Inumwj472S9r4\"," +
                "\"url\":\"https:\\/\\/open.spotify.com\\/artist\\/3TVXtAsR1Inumwj472S9r4\"," +
                "\"total\":\"58055243\"}]]";

        JSONArray artistJsonArray = testArtist.readInfoAsJsonArray();
        JSONArray testArray = JsonPath.read(testJsonString,"$.*");
        Assertions.assertEquals(testArray,artistJsonArray);
    }
}
