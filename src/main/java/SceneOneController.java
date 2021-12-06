import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import model.parser.formatter.ArtistFormatter;
import model.parser.hashtable.AlbumHashTable;
import model.parser.hashtable.AlbumHashTableBuilder;
import model.parser.hashtable.SongHashTable;
import model.requests.ArtistAlbums;
import model.requests.ArtistID;
import model.requests.SongsRequester;
import model.type.Artist;
import net.minidev.json.JSONArray;


public class SceneOneController {

    public TextArea albumsField;
    public TextArea tracksField;
    public TextArea profileField;
    public TextField indexField;
    public Button index;

    public Label spotifySnapLabel;
    public Button searchButton;
    public ImageView spotifyImage;
    public TextField searchField;


    public void searchButtonHandler(ActionEvent event) {
        String userInput = searchField.getText();

        if (userInput.isEmpty()) {
            validateFieldIsEmpty();
        } else {
            displayInformation(userInput);
        }

    }

    public void displayInformation(String artist) {
        Artist result = searchForArtist(artist);
        ArtistFormatter artistFormatter = new ArtistFormatter(result);
        profileField.setText(artistFormatter.format());

        AlbumHashTable albumHashTable = searchForAlbums(result);
        albumsField.setText(albumHashTable.formatTable());

        SongsRequester songsRequester = new SongsRequester();
        SongHashTable songHashTable = songsRequester.requestSongs(albumHashTable);
        tracksField.setText(songHashTable.formatTable());

    }

    public Artist searchForArtist(String userInput) {

        ArtistID artistID = new ArtistID();
        JSONArray array = artistID.getArtistID(userInput);
        return new Artist(array);
    }

    public AlbumHashTable searchForAlbums(Artist result) {
        AlbumHashTable albumHashTable = new AlbumHashTable();
        ArtistAlbums albums = new ArtistAlbums();
        AlbumHashTableBuilder hashTableBuilder = new AlbumHashTableBuilder(albums.getArtistAlbums(result));

        hashTableBuilder.buildHashTable(albumHashTable);
        albumHashTable.sortHashMapIntoArrayList();
        return albumHashTable;
    }


    public void validateFieldIsEmpty(){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Warning");
            alert.setHeaderText("Empty Field");
            alert.show();

    }

}
