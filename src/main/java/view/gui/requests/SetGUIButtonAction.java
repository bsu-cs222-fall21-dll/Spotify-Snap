package view.gui.requests;

import javafx.scene.control.Alert;
import model.requests.ArtistErrorHandler;
import model.requests.ArtistID;
import model.type.Artist;
import net.minidev.json.JSONArray;
import view.gui.errorHandling.MissingInput;

import java.util.Objects;

public class SetGUIButtonAction {
    public Artist getArtist(String artist) {
        ArtistID artistID = new ArtistID();
        if (Objects.equals(artist, "")) {
            Alert inputAlert = new Alert(Alert.AlertType.ERROR);
            inputAlert.setHeaderText("Error Code 1");
            inputAlert.setContentText("Missing Artist Input: Error Code 1");
            inputAlert.showAndWait();
            System.exit(1);
        }
        JSONArray artistSearchResultJsonArray = artistID.getArtistID(artist);
        ArtistErrorHandler artistErrorHandler = new ArtistErrorHandler(artistSearchResultJsonArray);

        return artistErrorHandler.checkIfArtistIsvalid();
    }
}
