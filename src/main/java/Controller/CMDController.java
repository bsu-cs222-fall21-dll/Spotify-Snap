package Controller;

import model.parser.formatter.ArtistFormatter;
import model.parser.hashtable.AlbumHashTable;
import model.parser.hashtable.AlbumHashTableBuilder;
import model.parser.hashtable.SongHashTable;
import model.requests.ArtistAlbums;
import model.requests.ArtistID;
import model.requests.SongsRequester;
import model.type.Artist;
import net.minidev.json.JSONArray;


public class CMDController {

    public void run() {
        Artist resultArtist = searchForArtist();
        ArtistFormatter artistFormatter = new ArtistFormatter(resultArtist);
        System.out.println(artistFormatter.format());

        AlbumHashTable albumHashTable = searchForAlbums(resultArtist);
        System.out.println(albumHashTable.formatTable());
        SongsRequester songsRequester = new SongsRequester();
        SongHashTable songHashTable = songsRequester.requestSongs(albumHashTable);
        System.out.println(songHashTable.formatTable());

    }

    private Artist searchForArtist(){

        ArtistID artistID = new ArtistID();
        JSONArray artistSearchResultJsonArray = artistID.getArtistID();
        return new Artist(artistSearchResultJsonArray);
    }

    private AlbumHashTable searchForAlbums(Artist resultArtist){

        AlbumHashTable albumHashTable = new AlbumHashTable();
        ArtistAlbums albums = new ArtistAlbums();
        AlbumHashTableBuilder hashTableBuilder = new AlbumHashTableBuilder(albums.getArtistAlbums(resultArtist));

        hashTableBuilder.buildHashTable(albumHashTable);
        albumHashTable.sortHashMapIntoArrayList();
        return albumHashTable;
    }

}
