package Controller;

import model.parser.formatter.ArtistFormatter;
import model.parser.hashtable.AlbumHashTable;
import model.parser.hashtable.AlbumHashTableBuilder;
import model.requests.ArtistAlbums;
import model.requests.ArtistID;
import model.type.Artist;
import net.minidev.json.JSONArray;


public class CMDController {

    public void run() {


        ArtistID artistID = new ArtistID();
        JSONArray artistSearchResultJsonArray = artistID.getArtistID();
        Artist resultArtist = new Artist(artistSearchResultJsonArray);

        ArtistFormatter artistFormatter = new ArtistFormatter(resultArtist);
        System.out.println(artistFormatter.format());
        AlbumHashTable albumHashTable = new AlbumHashTable();

        ArtistAlbums albums = new ArtistAlbums();
        AlbumHashTableBuilder hashTableBuilder = new AlbumHashTableBuilder(albums.getArtistAlbums(resultArtist));
        hashTableBuilder.buildHashTable(albumHashTable);

        System.out.println(albumHashTable.formatTable());

    }
}
