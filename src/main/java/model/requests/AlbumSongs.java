package model.requests;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONArray;

public class AlbumSongs extends AuthorizeCredentials {

    private final String accessToken = getAccessToken();

    public JSONArray getAlbumsTracks(String id) {

        RestAssured.baseURI = "https://api.spotify.com/v1";

        RequestSpecification http = RestAssured.given();
        String response = http.given()
                .header("Authorization", String.format("Bearer %s" , accessToken)).given()
                .request(Method.GET, String.format("/albums/%s/tracks", id)).asString();

        return JsonPath.read(response, "$..items");
    }
}
