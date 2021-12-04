package model.requests;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONArray;
import view.console.MissingArtist;
import view.console.UserInput;

public class ArtistID extends AuthorizeCredentials {

    private final String accessToken = getAccessToken();

    public JSONArray getArtistID(String artist) {
        /*
         This method sends a GET request to the /search endpoint that match a keyword string.

          The request must contain the following headers and parameters:
                       @header: Authorization: Access Token
         *              @param:  q: String
         *              @param:  type: Album, artist, playlist, track, show and episode.
         *
         * @return: Top 20 artist information in Json format from Spotify Web Api
         */

        MissingArtist missingArtist = new MissingArtist();
        RestAssured.baseURI = "https://api.spotify.com/v1";

        RequestSpecification http = RestAssured.given();
        String response =  http.given()
                .header("Authorization", String.format("Bearer %s" , accessToken)).given()
                .param("q",artist)
                .param("type", "artist")

                .request(Method.GET, "/search").asString();

        JSONArray artistSearchRequest = JsonPath.read(response,"$..items");
        missingArtist.checkForMissingArtist(artistSearchRequest);
        return artistSearchRequest;
    }
}
