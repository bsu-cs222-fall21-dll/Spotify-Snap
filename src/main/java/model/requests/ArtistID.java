package model.requests;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONArray;

public class ArtistID extends AuthorizeCredentials {

    private final String accessToken = getAccessToken();

    public JSONArray getArtistID(String artist) {

        RestAssured.baseURI = "https://api.spotify.com/v1";

        RequestSpecification http = RestAssured.given();
        String response =  http.given()
                .header("Authorization", String.format("Bearer %s" , accessToken)).given()
                .param("q",artist)
                .param("type", "artist")

                .request(Method.GET, "/search").asString();

        return JsonPath.read(response,"$..items");
    }
}
