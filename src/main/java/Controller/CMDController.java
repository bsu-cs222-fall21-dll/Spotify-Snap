package Controller;

import model.parser.*;
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

        AlbumHashTable albumHashTable = new AlbumHashTable();
        ArtistAlbums albums = new ArtistAlbums();
        AlbumHashTableBuilder albumHashTableBuilder = new AlbumHashTableBuilder(albums.getArtistAlbums(resultArtist));

        albumHashTableBuilder.buildHashTable(albumHashTable);
        System.out.println(albumHashTable.formatTable());

    }
}
