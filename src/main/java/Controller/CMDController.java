package Controller;

import model.*;
import net.minidev.json.JSONArray;

import java.io.IOException;

public class CMDController {

    public void run()  {
        SpotifyConnection spotifyConnection = new SpotifyConnection();
        JSONArray artistSearchResultJsonArray = spotifyConnection.searchItemRequest();
        SnapArtist resultArtist = new SnapArtist(artistSearchResultJsonArray);

        ArtistFormatter artistFormatter = new ArtistFormatter(resultArtist);
        System.out.println(artistFormatter.formatSnapArtist());

        Album album = new Album(spotifyConnection.searchAlbumRequest(resultArtist));
        AlbumFormatter albumFormatter = new AlbumFormatter(album);
        System.out.println(albumFormatter.formatAlbum());
    }
}
