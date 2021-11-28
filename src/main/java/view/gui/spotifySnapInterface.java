package view.gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.parser.formatter.ArtistFormatter;
import model.type.Artist;

public class spotifySnapInterface extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox parent = new VBox();
        setSpotifyLogo setSpotifyLogo = new setSpotifyLogo();
        setGUIButtonAction setGUIButtonAction = new setGUIButtonAction();

        GUIText guiText = new GUIText();
        setGUIBackgroundColor setGUIBackgroundColor = new setGUIBackgroundColor();

        Text titleText = new Text("Spotify-Snap");
        Text descriptionText = new Text("Enter Artist: ");

        TextField textField = new TextField();
        TextArea outputField = new TextArea();
        outputField.setPrefSize(180,200);

        HBox urlArea = new HBox();
        urlArea.setAlignment(Pos.TOP_CENTER);
        urlArea.getChildren().addAll(guiText.modifyText(descriptionText, 15), textField);

        Button button = new Button("Search Artist");
        button.setBackground(setGUIBackgroundColor.modifyBackgroundGreen());
        button.setOnAction(event -> {
            Artist resultArtist = setGUIButtonAction.getArtist(textField.getText());
            ArtistFormatter artistFormatter = new ArtistFormatter(resultArtist);
            outputField.setText(artistFormatter.format());
        });

        parent.setAlignment(Pos.TOP_CENTER);
        parent.setSpacing(8);
        parent.setBackground(setGUIBackgroundColor.modifyBackgroundBlack());
        parent.getChildren().addAll(
                setSpotifyLogo.getLogo(),
                guiText.modifyText(titleText,25),
                urlArea,
                button,
                outputField);

        Scene scene = new Scene(parent, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
