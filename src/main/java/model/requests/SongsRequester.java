package model.requests;

import model.parser.formatter.AlbumFormatter;
import model.parser.hashtable.AlbumHashTable;
import model.parser.hashtable.SongHashTable;
import model.parser.hashtable.SongHashTableBuilder;
import model.type.Album;
import view.console.UserInput;

public class SongsRequester {
    public SongHashTable requestSongs(AlbumHashTable albumHashTableToBeSelectedFrom){

        String id = getIdOfAlbum(albumHashTableToBeSelectedFrom);
        return searchForSongs(id);
    }

    private String getIdOfAlbum(AlbumHashTable albumHashTableToBeSelectedFrom){
        UserInput userInput = new UserInput();
        String albumIndex = userInput.getAlbum();
        Album selectedAlbum = (Album) albumHashTableToBeSelectedFrom.readAtKey(albumIndex);
        AlbumFormatter albumFormatter = new AlbumFormatter(selectedAlbum);
        return albumFormatter.parseInfo("id");

    }

    private SongHashTable searchForSongs(String id){

        AlbumTracks albumTracks = new AlbumTracks();
        SongHashTable songHashTable = new SongHashTable();
        SongHashTableBuilder songHashTableBuilder = new SongHashTableBuilder(albumTracks.getAlbumsTracks(id));
        songHashTableBuilder.buildHashTable(songHashTable);
        songHashTable.sortHashMapIntoArrayList();
        return songHashTable;
    }
}
