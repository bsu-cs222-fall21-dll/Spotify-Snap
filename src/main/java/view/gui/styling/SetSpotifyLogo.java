package view.gui.styling;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class SetSpotifyLogo {
    public HBox getLogo() {

        Image image = new Image(Thread.currentThread().getContextClassLoader().getResourceAsStream("Spotify_Icon_Green.png"));
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitHeight(100);
        imageView.setPreserveRatio(true);

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.TOP_CENTER);
        hBox.getChildren().addAll(imageView);

        return hBox;
    }
}
