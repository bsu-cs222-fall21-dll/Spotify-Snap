package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class GUIController {

    @FXML
    public Label spotifySnapLabel;
    @FXML
    public Button searchButton;
    @FXML
    public TextField userInputField;
    @FXML
    public ImageView spotifyImage;
    @FXML
    private Label lblOutput;



    public void sayHello(){
        lblOutput.setText("Hello FXML!");
    }
}
