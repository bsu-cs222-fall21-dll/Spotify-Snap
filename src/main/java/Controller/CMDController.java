package Controller;

import model.parser.formatter.ArtistFormatter;
import model.parser.hashtable.AlbumHashTable;
import model.parser.hashtable.SongHashTable;
import model.type.Artist;


public class CMDController {

    public void run() {
        ModelController modelController = new ModelController();
        Artist resultArtist = modelController.searchForArtist();
        ArtistFormatter artistFormatter = new ArtistFormatter(resultArtist);
        System.out.println(artistFormatter.format());

        AlbumHashTable albumHashTable = modelController.searchForAlbums(resultArtist);
        System.out.println(albumHashTable.formatTable());
        SongHashTable songHashTable = modelController.createSongHashTable(albumHashTable);
        System.out.println(songHashTable.formatTable());

    }

}
