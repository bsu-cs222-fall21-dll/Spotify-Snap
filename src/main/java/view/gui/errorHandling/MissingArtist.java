package view.gui.errorHandling;

import javafx.scene.control.Alert;

public class MissingArtist {

    public void artistNotFoundError() {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Error Code 2");
        alert.setContentText("Artist Not Found: Error Code 2");
        alert.showAndWait();
    }
}
