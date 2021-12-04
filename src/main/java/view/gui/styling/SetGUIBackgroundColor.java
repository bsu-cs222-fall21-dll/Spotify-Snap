package view.gui.styling;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class SetGUIBackgroundColor {

    public Background modifyBackgroundBlack() {
        BackgroundFill backgroundFill = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        return new Background(backgroundFill);
    }

    public Background modifyBackgroundGreen() {
        BackgroundFill backgroundFill = new BackgroundFill(Color.MEDIUMSEAGREEN, CornerRadii.EMPTY, Insets.EMPTY);
        return new Background(backgroundFill);
    }
}
