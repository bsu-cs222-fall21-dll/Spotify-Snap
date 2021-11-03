package Controller;

import model.parser.Album;
import model.parser.AlbumFormatter;
import model.parser.ArtistFormatter;
import model.parser.Artist;
import model.requests.SpotifyConnection;
import net.minidev.json.JSONArray;

public class CMDController {

    public void run()  {
        SpotifyConnection spotifyConnection = new SpotifyConnection();
        JSONArray artistSearchResultJsonArray = spotifyConnection.getArtistID();
        Artist resultArtist = new Artist(artistSearchResultJsonArray);

        ArtistFormatter artistFormatter = new ArtistFormatter(resultArtist);
        System.out.println(artistFormatter.formatSnapArtist());

        Album album = new Album(spotifyConnection.getArtistAlbums(resultArtist),0);
        AlbumFormatter albumFormatter = new AlbumFormatter(album);
        System.out.println(albumFormatter.formatAlbum());
    }
}
