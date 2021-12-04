package view.gui.styling;

import javafx.scene.control.TextArea;

public class TextAreaStyling {
    public void modifyTextAreaStyling(TextArea textArea) {
        textArea.setPrefSize(180,200);
        textArea.setStyle("-fx-control-inner-background:#000000; -fx-text-fill: #3cb371; ");
    }
}
