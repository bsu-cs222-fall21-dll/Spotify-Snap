package view.gui.styling;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class GUIText {

    public Text modifyText(Text text, Integer fontSize) {
        text.setFill(Color.MEDIUMSEAGREEN);
        Font font = Font.font("Verdana", FontWeight.EXTRA_BOLD, fontSize);
        text.setFont(font);
        return text;
    }

}
