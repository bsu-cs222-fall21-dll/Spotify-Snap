package view.gui.requests;

import javafx.scene.control.Alert;
import model.requests.ArtistID;
import model.type.Artist;
import net.minidev.json.JSONArray;
import view.gui.errorHandling.GUIArtistErrorHandler;

import java.util.Objects;

public class SetGUIButtonAction {

    public Artist getArtist(String artist) {

        ArtistID artistID = new ArtistID();
        if (Objects.equals(artist, "")) {
            Alert inputAlert = new Alert(Alert.AlertType.ERROR);
            inputAlert.setHeaderText("Error Code 1");
            inputAlert.setContentText("Missing Artist Input: Error Code 1");
            inputAlert.showAndWait();
        }
        JSONArray artistSearchResultJsonArray = artistID.getArtistID(artist);
        GUIArtistErrorHandler guiArtistErrorHandler = new GUIArtistErrorHandler(artistSearchResultJsonArray);

        return guiArtistErrorHandler.checkIfArtistIsvalid();
    }
}
