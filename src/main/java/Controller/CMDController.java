package Controller;

import model.parser.formatter.ArtistFormatter;
import model.parser.hashtable.AlbumHashTable;
import model.parser.hashtable.SongHashTable;
import model.type.Artist;
import view.console.UserInput;


public class CMDController {

    public void run() {
        ModelController modelController = new ModelController();
        Artist resultArtist = modelController.searchForArtist();
        ArtistFormatter artistFormatter = new ArtistFormatter(resultArtist);
        System.out.println(artistFormatter.format());

        AlbumHashTable albumHashTable = modelController.searchForAlbums(resultArtist);
        System.out.println(albumHashTable.formatTable());
        UserInput userInput = new UserInput();
        String albumIndex = userInput.getAlbum();
        SongHashTable songHashTable = modelController.createSongHashTable(albumHashTable, albumIndex);
        System.out.println(songHashTable.formatTable());

    }

}
