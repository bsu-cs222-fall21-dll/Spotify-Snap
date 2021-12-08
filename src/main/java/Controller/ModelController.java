package Controller;

import model.parser.hashtable.AlbumHashTable;
import model.parser.hashtable.AlbumHashTableBuilder;
import model.parser.hashtable.SongHashTable;
import model.requests.ArtistAlbums;
import view.console.CMDArtistErrorHandler;
import model.requests.ArtistID;
import model.requests.SongsRequester;
import model.type.Artist;
import net.minidev.json.JSONArray;
import view.console.UserInput;

public class ModelController {


    public Artist searchForArtistInCMD(){

        ArtistID artistID = new ArtistID();
        UserInput userInput = new UserInput();
        JSONArray artistSearchResultJsonArray = artistID.getArtistID(userInput.getArtist());
        CMDArtistErrorHandler CMDArtistErrorHandler = new CMDArtistErrorHandler(artistSearchResultJsonArray);
        return CMDArtistErrorHandler.checkIfArtistIsvalid();
    }


    public AlbumHashTable searchForAlbums(Artist resultArtist){

        AlbumHashTable albumHashTable = new AlbumHashTable();
        ArtistAlbums albums = new ArtistAlbums();
        AlbumHashTableBuilder hashTableBuilder = new AlbumHashTableBuilder(albums.getArtistAlbums(resultArtist));

        hashTableBuilder.buildHashTable(albumHashTable);
        albumHashTable.sortHashMapIntoArrayList();
        return albumHashTable;
    }


    public SongHashTable createSongHashTable(AlbumHashTable albumHashTable, String userInput){
        SongsRequester songsRequester = new SongsRequester();
        return songsRequester.requestSongs(albumHashTable, userInput);
    }
}
