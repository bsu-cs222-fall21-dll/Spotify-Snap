package view.console;

import Controller.ModelController;
import model.parser.Parser;
import model.type.Artist;
import net.minidev.json.JSONArray;
import view.ArtistErrorHandler;

public class CMDArtistErrorHandler extends Parser implements ArtistErrorHandler {

    public CMDArtistErrorHandler(JSONArray infoArray) {

        super(infoArray);
    }


    public Artist checkIfArtistIsvalid(){

        if (calculateArraySize("*")<2){
            ModelController modelController = new ModelController();
            System.err.println("Artist Not found");
            return modelController.searchForArtistInCMD();
        } else {
            return new Artist(this.infoArray);
        }
    }

}
