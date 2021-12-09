package view.gui.errorHandling;

import javafx.scene.control.Alert;

public class CheckNetworkConnection {

    public void NetworkError() {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Error Code 3");
        alert.setContentText("Missing Network Connection: Error Code 3");
        alert.showAndWait();
    }
}
