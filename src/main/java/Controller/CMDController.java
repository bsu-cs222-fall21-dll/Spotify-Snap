package Controller;

import model.parser.ArtistFormatter;
import model.parser.SnapArtist;
import model.requests.SpotifyConnection;
import net.minidev.json.JSONArray;

import java.io.IOException;

public class CMDController {

    public void run() {
        SpotifyConnection spotifyConnection = new SpotifyConnection();
        JSONArray artistSearchResultJsonArray = spotifyConnection.searchItemRequest();
        SnapArtist resultArtist = new SnapArtist(artistSearchResultJsonArray);

        ArtistFormatter artistFormatter = new ArtistFormatter(resultArtist);
        System.out.println(artistFormatter.formatSnapArtist());
    }
}
