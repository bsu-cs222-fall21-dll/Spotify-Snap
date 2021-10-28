package model;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONArray;
import view.ClientCredentials;
import view.UserInput;

import java.nio.charset.StandardCharsets;
import java.util.Base64;


public class SpotifyConnection {

    private String authorizeCredentials() {
        /**
         * This method sends a POST request to the https://accounts.spotify.com/api/token endpoint of the Spotify OAuth 2.0 Service.
         *
         * The request must contain the following headers and parameters:
         *             @header: Authorization: Base64 encoded Client Credentials
         *             @header: Content-Type: Encodes parameters to URL format
         *             @Param:  grant_Type: Client Credentials
         *
         * @return: Access Token in Json format from Spotify Web Api
         */

        RestAssured.baseURI = "https://accounts.spotify.com/";

        RequestSpecification http = RestAssured.given();
        return http.given()
                .header("Authorization",String.format("Basic %s", encodeClientCredentials())).given()
                .header("Content-Type", "application/x-www-form-urlencoded").given()
                .param("grant_type","client_credentials")
                .request(Method.POST, "api/token").asString();
    }


    public JSONArray searchItemRequest() {
        /**
         *This method sends a GET request to the /search endpoint that match a keyword string.
         *
         * The request must contain the following headers and parameters:
         *              @header: Authorization: Access Token
         *              @param:  q: String
         *              @param:  type: Album, artist, playlist, track, show and episode.
         *
         * @return: Top 20 artist information in Json format from Spotify Web Api
         */

        UserInput input = new UserInput();
        RestAssured.baseURI = "https://api.spotify.com/v1";

        RequestSpecification http = RestAssured.given();
        String response =  http.given()
                .header("Authorization", String.format("Bearer %s" , accessToken())).given()
                .param("q",input.getArtist())
                .param("type", "artist")

                .request(Method.GET, "/search").asString();
        return JsonPath.read(response,"$..items");
    }

    public JSONArray searchAlbumRequest(SnapArtist snapArtist) {
        /**
         * This method sends a GET request to the /albums/{id} endpoint.
         *
         * The request must contain the following headers and parameters:
         *             @header: Authorization: Access Token
         *             @param:  id : String
         *
         * @return: Spotify catalog information for a single album.
         */
        String id = JsonPath.read(snapArtist.readArtistInfoAsJson(), "$..id");
        RestAssured.baseURI = "https://api.spotify.com/v1";

        RequestSpecification http = RestAssured.given();

        String response = http.given()
                .header("Authorization", String.format("Bearer %s" , accessToken())).given()
                .request(Method.GET, String.format("/artists/%s/albums", id)).asString();
        return JsonPath.read(response, "$..items");

    }

    private String accessToken() {
        /**
         * This method gets the parse access token in AccessTokenParser class
         *
         * @return: Parsed access token
         */
        AccessTokenParser parse = new AccessTokenParser();
        return parse.parseAccessToken(authorizeCredentials());
    }

    private String encodeClientCredentials() {
        /**
         * This method gets the clientID and client Secret from the command line.

         * @return: Base 64 encoded string that contains the client ID and client secret key.
         */
        ClientCredentials credentials = new ClientCredentials();
        String clientID = credentials.getClientID();
        String clientSecret = credentials.getClientSecretID();

        return Base64.getEncoder().encodeToString((clientID + ":" + clientSecret).getBytes(StandardCharsets.UTF_8));
    }


}

