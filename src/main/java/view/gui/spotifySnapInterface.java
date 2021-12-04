package view.gui;

import Controller.ModelController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.parser.formatter.ArtistFormatter;
import model.parser.hashtable.AlbumHashTable;
import model.parser.hashtable.SongHashTable;
import model.type.Artist;
import view.gui.requests.SetGUIButtonAction;
import view.gui.styling.GUIText;
import view.gui.styling.SetGUIBackgroundColor;
import view.gui.styling.SetSpotifyLogo;

public class spotifySnapInterface extends Application {
    @Override
    public void start(Stage primaryStage)  {
        VBox parent = new VBox();
        SetSpotifyLogo setSpotifyLogo = new SetSpotifyLogo();
        SetGUIButtonAction setGUIButtonAction = new SetGUIButtonAction();
        GUIText guiText = new GUIText();
        SetGUIBackgroundColor setGUIBackgroundColor = new SetGUIBackgroundColor();

        Text titleText = new Text("Spotify-Snap");
        Text artistSearchBoxDescriptionText = new Text("Enter Artist: ");
        Text albumSearchBoxDescriptionText = new Text("Enter Album Index: ");

        TextField artistInputField = new TextField();
        TextField albumIndexInputField = new TextField();

        TextArea outputField = new TextArea();
        outputField.setPrefSize(180,200);

        Button artistButton = new Button("Search Artist");
        artistButton.setBackground(setGUIBackgroundColor.modifyBackgroundGreen());

        Button albumButton = new Button("Search Songs");
        albumButton.setBackground(setGUIBackgroundColor.modifyBackgroundGreen());

        artistButton.setOnAction(event -> {
            ModelController modelController = new ModelController();
            Artist resultArtist = setGUIButtonAction.getArtist(artistInputField.getText());
            if(resultArtist!=null){
                ArtistFormatter artistFormatter = new ArtistFormatter(resultArtist);

                AlbumHashTable albumHashTable = modelController.searchForAlbums(resultArtist);
                outputField.setText(artistFormatter.format() + "\n" + albumHashTable.formatTable());

                albumButton.setOnAction(event1 -> {
                    SongHashTable songHashTable = modelController.createSongHashTable(albumHashTable, albumIndexInputField.getText());
                    outputField.setText(songHashTable.formatTable());
                });
            }

        });

        HBox artistInputHBox = new HBox(8);
        artistInputHBox.setAlignment(Pos.TOP_CENTER);
        artistInputHBox.getChildren().addAll(guiText.modifyText(artistSearchBoxDescriptionText, 15),
                artistInputField,
                artistButton);

        HBox albumIndexInputHbox = new HBox(8);
        albumIndexInputHbox.setAlignment(Pos.TOP_CENTER);
        albumIndexInputHbox.getChildren().addAll(guiText.modifyText(albumSearchBoxDescriptionText, 15),
                albumIndexInputField,
                albumButton);

        parent.setAlignment(Pos.TOP_CENTER);
        parent.setSpacing(8);
        parent.setBackground(setGUIBackgroundColor.modifyBackgroundBlack());
        parent.getChildren().addAll(
                setSpotifyLogo.getLogo(),
                guiText.modifyText(titleText,25),
                artistInputHBox,
                albumIndexInputHbox,
                outputField);

        Scene scene = new Scene(parent, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
