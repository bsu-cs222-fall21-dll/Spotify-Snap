package Controller;

import model.parser.Album;
import model.parser.AlbumFormatter;
import model.parser.ArtistFormatter;
import model.parser.SnapArtist;
import model.requests.SpotifyConnection;
import net.minidev.json.JSONArray;

public class CMDController {

    public void run()  {
        SpotifyConnection spotifyConnection = new SpotifyConnection();
        JSONArray artistSearchResultJsonArray = spotifyConnection.getArtistID();
        SnapArtist resultArtist = new SnapArtist(artistSearchResultJsonArray);

        ArtistFormatter artistFormatter = new ArtistFormatter(resultArtist);
        System.out.println(artistFormatter.formatSnapArtist());

        Album album = new Album(spotifyConnection.getArtistAlbums(resultArtist));
        AlbumFormatter albumFormatter = new AlbumFormatter(album);
        System.out.println(albumFormatter.formatAlbum());
    }
}
