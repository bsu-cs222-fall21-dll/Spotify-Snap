package view.gui;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class setGUIBackgroundColor {

    public Background modifyBackgroundBlack() {
        BackgroundFill backgroundFill = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backgroundFill);
        return background;
    }

    public Background modifyBackgroundGreen() {
        BackgroundFill backgroundFill = new BackgroundFill(Color.MEDIUMSEAGREEN, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backgroundFill);
        return background;
    }

}
