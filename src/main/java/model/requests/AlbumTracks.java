package model.requests;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONArray;



public class AlbumTracks extends AuthorizeCredentials {

    private final String accessToken = getAccessToken();

    public JSONArray getAlbumsTracks(String id) {
        /*
          This method sends a GET request to the /albums/{id}/tracks endpoint.

          The request must contain the following headers and parameters:
                      @header: Authorization: Access Token
         *             @param:  id : String
         *
         * @return: Spotify catalog information for an album tracks.
         */

        RestAssured.baseURI = "https://api.spotify.com/v1";

        RequestSpecification http = RestAssured.given();
        String response = http.given()
                .header("Authorization", String.format("Bearer %s" , accessToken)).given()
                .request(Method.GET, String.format("/albums/%s/tracks", id)).asString();

        return JsonPath.read(response, "$..items");
    }
}
