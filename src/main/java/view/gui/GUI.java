package view.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


public class GUI extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Spotify Snap");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainScene.fxml"));

        VBox parent = new VBox();
        parent.getChildren().add(loader.load());

        primaryStage.setScene(new Scene(parent));
        primaryStage.show();

    }

}
