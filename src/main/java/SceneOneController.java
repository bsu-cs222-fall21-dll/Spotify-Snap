import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.parser.hashtable.AlbumHashTable;
import model.parser.hashtable.AlbumHashTableBuilder;
import model.requests.ArtistAlbums;
import model.requests.ArtistID;
import model.type.Artist;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.util.Objects;

public class SceneOneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public Label spotifySnapLabel;
    @FXML
    public Button searchButton;
    @FXML
    public TextField userInputField;
    @FXML
    public ImageView spotifyImage;


    public void searchButtonHandler(ActionEvent event) throws IOException {
        if (userInputField.getText().isEmpty()) {
            validateFieldIsEmpty();
        } else {

            switchScene(event);
        }

    }

    public void switchScene(ActionEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SecondaryScene.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void validateFieldIsEmpty(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Warning");
        alert.setHeaderText("Empty Field");
        alert.setContentText("Enter search");
        alert.showAndWait();
    }
}
