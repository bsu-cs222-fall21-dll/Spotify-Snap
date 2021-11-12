package Controller;

import model.parser.*;
import model.parser.formatter.ArtistFormatter;
import model.parser.hashtable.AlbumHashTable;
import model.parser.hashtable.AlbumHashTableBuilder;
import model.parser.hashtable.HashTableBuilder;
import model.requests.ArtistAlbums;
import model.requests.ArtistID;
import net.minidev.json.JSONArray;

public class CMDController {

    public void run()  {

        ArtistID artistID = new ArtistID();
        JSONArray artistSearchResultJsonArray = artistID.getArtistID();
        Artist resultArtist = new Artist(artistSearchResultJsonArray);

        ArtistFormatter artistFormatter = new ArtistFormatter(resultArtist);
        System.out.println(artistFormatter.format());
        AlbumHashTable albumHashTable = new AlbumHashTable();

        ArtistAlbums albums = new ArtistAlbums();
        AlbumHashTableBuilder hashTableBuilder = new AlbumHashTableBuilder(albums.getArtistAlbums(resultArtist));
        hashTableBuilder.buildHashTable(albumHashTable);
        albumHashTable.sortHashMapIntoArrayList();
        System.out.println(albumHashTable.formatTable());

    }
}
