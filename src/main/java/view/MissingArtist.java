package view;

import net.minidev.json.JSONArray;

public class MissingArtist {
    public void checkForMissingArtist(JSONArray searchedArtist) {
        if (searchedArtist.size() <= 0) {
            System.err.println("Artist Not Found: Error Code 2");
            System.exit(2);
        }
    }
}
