package view.gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class spotifySnapInterface extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox parent = new VBox();
        parent.setAlignment(Pos.TOP_CENTER);
        parent.setSpacing(8);
        parent.getChildren().add(new Label("Spotify-Snap"));

        HBox urlArea = new HBox(new Label("Enter Artist: "));
        urlArea.setAlignment(Pos.TOP_CENTER);

        TextField textField = new TextField();
        urlArea.getChildren().add(textField);
        parent.getChildren().add(urlArea);

        TextField outputField = new TextField();

        Button button = new Button("Search Artist");
        button.setOnAction(event -> {
            outputField.setText("I would like artist info on " + textField.getText());
        });

        parent.getChildren().addAll(button, outputField);

        primaryStage.setScene(new Scene(parent, 370, 425));
        primaryStage.show();
    }
}
