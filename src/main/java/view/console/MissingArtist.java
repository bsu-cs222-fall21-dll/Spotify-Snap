package view.console;

import net.minidev.json.JSONArray;

public class MissingArtist {

    public void checkForMissingArtist(JSONArray searchedArtist) {

        if (searchedArtist.size() <= 0) {
            printErrorMessage();
        }
    }
    public void printErrorMessage(){

        System.err.println("Artist Not Found: Error Code 2");
    }
}
