package model.requests;

import Controller.ModelController;
import model.parser.Parser;
import model.type.Artist;
import net.minidev.json.JSONArray;

public class ArtistErrorHandler extends Parser {
    public ArtistErrorHandler(JSONArray infoArray) {
        super(infoArray);

    }

    public Artist checkIfArtistIsvalid(){
        if (calculateArraySize("*")<2){
            ModelController modelController = new ModelController();
            return modelController.searchForArtist();
        } else {
            return new Artist(this.infoArray);
        }

    }


}
