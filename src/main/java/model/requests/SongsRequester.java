package model.requests;

import model.parser.formatter.AlbumFormatter;
import model.parser.hashtable.AlbumHashTable;
import model.parser.hashtable.SongHashTable;
import model.parser.hashtable.SongHashTableBuilder;
import model.type.Album;
import view.console.AlbumIndexCheckIfIntHandler;

public class SongsRequester {
    public SongHashTable requestSongs(AlbumHashTable albumHashTableToBeSelectedFrom){

        String id = getIdOfAlbum(albumHashTableToBeSelectedFrom);
        return searchForSongs(id);
    }

    private String getIdOfAlbum(AlbumHashTable albumHashTableToBeSelectedFrom){

        String desiredAlbumIndex = handleErrorIfInputIsLargerThanHashTable(albumHashTableToBeSelectedFrom);
        int index = Integer.parseInt(desiredAlbumIndex)-1;
        String albumIndex = String.format("%d",index);
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

    private String handleErrorIfInputIsLargerThanHashTable(AlbumHashTable albumHashTableToBeSelectedFrom){
        AlbumIndexCheckIfIntHandler albumIndexCheckIfIntHandler = new AlbumIndexCheckIfIntHandler();
        return albumIndexCheckIfIntHandler.checkIfAlbumIndexOutOfRange(albumHashTableToBeSelectedFrom);
    }
}
