package Controller;

import model.parser.Album;
import model.parser.AlbumFormatter;
import model.parser.ArtistFormatter;
import model.parser.Artist;
import model.requests.ArtistAlbums;
import model.requests.ArtistID;
import net.minidev.json.JSONArray;

public class CMDController {

    public void run()  {
        ArtistID artistID = new ArtistID();
        JSONArray artistSearchResultJsonArray = artistID.getArtistID();
        Artist resultArtist = new Artist(artistSearchResultJsonArray);

        ArtistFormatter artistFormatter = new ArtistFormatter(resultArtist);
        System.out.println(artistFormatter.formatSnapArtist());

        ArtistAlbums albums = new ArtistAlbums();
        Album album = new Album(albums.getArtistAlbums(resultArtist),0);
        AlbumFormatter albumFormatter = new AlbumFormatter(album);
        System.out.println(albumFormatter.formatAlbum());
    }
}
