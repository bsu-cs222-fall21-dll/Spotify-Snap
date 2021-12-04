package view.gui.errorHandling;

import model.parser.Parser;
import model.type.Artist;
import net.minidev.json.JSONArray;
import view.ArtistErrorHandler;

public class GUIArtistErrorHandler extends Parser implements ArtistErrorHandler {

    public GUIArtistErrorHandler(JSONArray infoArray) {
        super(infoArray);
    }

    public Artist checkIfArtistIsvalid(){
        if (calculateArraySize("*")<2){
            return null;
        } else {
            return new Artist(this.infoArray);
        }
    }
}
