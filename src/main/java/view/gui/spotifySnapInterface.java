package view.gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class spotifySnapInterface extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox parent = new VBox();

        GUIText guiText = new GUIText();
        setGUIBackgroundColor setGUIBackgroundColor = new setGUIBackgroundColor();

        Text titleText = new Text("Spotify-Snap");
        Text descriptionText = new Text("Enter Artist: ");

        TextField textField = new TextField();
        TextField outputField = new TextField();
        outputField.setPrefSize(180,200);


        HBox urlArea = new HBox();
        urlArea.setAlignment(Pos.TOP_CENTER);
        urlArea.getChildren().addAll(guiText.modifyText(descriptionText, 15), textField);

        Button button = new Button("Search Artist");
        button.setOnAction(event -> {
            outputField.setText("I would like artist info on " + textField.getText());
        });

        parent.setAlignment(Pos.TOP_CENTER);
        parent.setSpacing(8);
        parent.setBackground(setGUIBackgroundColor.modifyBackground());
        parent.getChildren().addAll(
                guiText.modifyText(titleText,25),
                urlArea,
                button,
                outputField);

        Scene scene = new Scene(parent, 450, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
