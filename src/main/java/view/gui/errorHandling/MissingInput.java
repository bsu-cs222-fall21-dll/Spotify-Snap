package view.gui.errorHandling;

import javafx.scene.control.Alert;

import java.util.Objects;

public class MissingInput {
    public void missingArtistInput(String artist) {
        if (Objects.equals(artist, "")) {
            Alert missingArtistAlert = new Alert(Alert.AlertType.ERROR);
            missingArtistAlert.setHeaderText("Error Code 1");
            missingArtistAlert.setContentText("Artist Input Not Found: Error Code 1");
            System.exit(1);
        }
    }
}
