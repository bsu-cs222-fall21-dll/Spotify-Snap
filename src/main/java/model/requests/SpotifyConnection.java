package model.requests;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import model.parser.AccessTokenParser;
import model.parser.Artist;
import net.minidev.json.JSONArray;
import view.MissingArtist;
import view.UserInput;

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
                .header("Authorization",String.format("Basic %s", clientCredentials())).given()
                .header("Content-Type", "application/x-www-form-urlencoded").given()
                .param("grant_type","client_credentials")
                .request(Method.POST, "api/token").asString();
    }


    public JSONArray getArtistID() {
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
        MissingArtist missingArtist = new MissingArtist();
        RestAssured.baseURI = "https://api.spotify.com/v1";

        RequestSpecification http = RestAssured.given();
        String response =  http.given()
                .header("Authorization", String.format("Bearer %s" , getAccessToken())).given()
                .param("q",input.getArtist())
                .param("type", "artist")

                .request(Method.GET, "/search").asString();
        JSONArray artistSearchRequest = JsonPath.read(response,"$..items");
        missingArtist.checkForMissingArtist(artistSearchRequest);
        return artistSearchRequest;
    }

    public JSONArray getArtistAlbums(Artist artist) {
        /**
         * This method sends a GET request to the /albums/{id} endpoint.
         *
         * The request must contain the following headers and parameters:
         *             @header: Authorization: Access Token
         *             @param:  id : String
         *
         * @return: Spotify catalog information for a single album.
         */
        JSONArray idArray = JsonPath.read(artist.readArtistInfoAsJson(), "$..id");
        String id = idArray.get(0).toString();
        RestAssured.baseURI = "https://api.spotify.com/v1";

        RequestSpecification http = RestAssured.given();

        String response = http.given()
                .header("Authorization", String.format("Bearer %s" , getAccessToken())).given()
                .request(Method.GET, String.format("/artists/%s/albums", id)).asString();
        return JsonPath.read(response, "$..items");
    }

    public JSONArray getAlbumsTracks(String id) {
        RestAssured.baseURI = "https://api.spotify.com/v1";

        RequestSpecification http = RestAssured.given();
        String response = http.given()
                .header("Authorization", String.format("Bearer %s" , getAccessToken())).given()
                .request(Method.GET, String.format("/albums/%s/tracks", id)).asString();
        System.out.println(response);
        return JsonPath.read(response, "$..items");
    }

    private String getAccessToken() {
        /**
         * This method gets the parse access token in AccessTokenParser class
         *
         * @return: Parsed access token
         */
        AccessTokenParser parse = new AccessTokenParser();
        return parse.parseAccessToken(authorizeCredentials());
    }

    private String clientCredentials() {
        /**
         * @return: Base 64 encoded string that contains the client ID and client secret key.
         */

        return "MTVhZDNhZTM5NWZkNDRmMGEwNTlkZjJmZTNlYWJhZTE6MGU0NzcwYTQxMzk3NGEyNDg1M2M5MmE3NjI2ZWQwOTU=";
    }

    public static void main(String[] args) {
        SpotifyConnection connection = new SpotifyConnection();
        connection.getAlbumsTracks("3SpBlxme9WbeQdI9kx7KAV");
    }


}

