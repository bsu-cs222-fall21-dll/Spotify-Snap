import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class SceneTwoController  {
    @FXML
    public AnchorPane hbox;

    public javafx.scene.control.Button songs;
    public AnchorPane vbox;
    public javafx.scene.control.Button back;
    public javafx.scene.control.TextArea AlbumArea;
    public javafx.scene.control.TextArea SongsArea;
    public javafx.scene.control.TextField albumIndex;
    public javafx.scene.control.TextField songIndex;
    public javafx.scene.control.Button albumsButton;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void backButtonHandler(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainScene.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
