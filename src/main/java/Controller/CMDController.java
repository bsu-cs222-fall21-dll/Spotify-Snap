package Controller;

import model.ArtistFormatter;
import model.SnapArtist;
import model.SpotifyConnection;
import net.minidev.json.JSONArray;

import java.io.IOException;

public class CMDController {

    public void run() throws IOException {
        SpotifyConnection spotifyConnection = new SpotifyConnection();
        JSONArray artistSearchResultJsonArray = spotifyConnection.searchItemRequest();
        SnapArtist resultArtist = new SnapArtist(artistSearchResultJsonArray);

        ArtistFormatter artistFormatter = new ArtistFormatter(resultArtist);
        System.out.println(artistFormatter.formatSnapArtist());
    }
}
