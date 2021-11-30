package view.gui.requests;

import model.requests.ArtistErrorHandler;
import model.requests.ArtistID;
import model.type.Artist;
import net.minidev.json.JSONArray;

public class setGUIButtonAction {
    public Artist getArtist(String artist) {
        ArtistID artistID = new ArtistID();
        JSONArray artistSearchResultJsonArray = artistID.getArtistID(artist);
        ArtistErrorHandler artistErrorHandler = new ArtistErrorHandler(artistSearchResultJsonArray);

        return artistErrorHandler.checkIfArtistIsvalid();
    }
}
