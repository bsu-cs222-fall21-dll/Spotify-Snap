package model.requests;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import model.type.Artist;
import net.minidev.json.JSONArray;

public class ArtistAlbums extends AuthorizeCredentials {

private final String accessToken = getAccessToken();

    public JSONArray getArtistAlbums(Artist artist) {

        JSONArray idArray = JsonPath.read(artist.readInfoAsJsonArray(), "$..id");
        String id = idArray.get(0).toString();
        RestAssured.baseURI = "https://api.spotify.com/v1";

        RequestSpecification http = RestAssured.given();

        String response = http.given()
                .header("Authorization", String.format("Bearer %s" , accessToken)).given()
                .request(Method.GET, String.format("/artists/%s/albums", id)).asString();

        return JsonPath.read(response, "$..items");
    }
}
