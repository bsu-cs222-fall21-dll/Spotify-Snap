package model;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONArray;
import view.ClientCredentials;
import view.UserInput;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


public class SpotifyConnection {

    private String accessToken() throws IOException {

        AccessTokenParser parse = new AccessTokenParser();
        return parse.parseAccessToken(authorizeCredentials());
    }

    private String encodeClientCredentials() {
        ClientCredentials credentials = new ClientCredentials();
        String clientID = credentials.getClientID();
        String clientSecret = credentials.getClientSecretID();

        return Base64.getEncoder().encodeToString((clientID + ":" + clientSecret).getBytes(StandardCharsets.UTF_8));
    }


    private String authorizeCredentials() throws IOException {
        //This method is authorizing the credentials and reading the access token sent from spotify
        URL url = new URL("https://accounts.spotify.com/api/token");
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setDoOutput(true);

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization",String.format("Basic %s", encodeClientCredentials()));
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        String parameter = "grant_type=client_credentials";

        byte[] output = parameter.getBytes(StandardCharsets.UTF_8);
        int length = output.length;
        connection.setFixedLengthStreamingMode(length);
        connection.connect();

        try (OutputStream outputStream = connection.getOutputStream()){
            outputStream.write(output);
        }

        InputStream inputStream = connection.getInputStream();
        return new String(inputStream.readAllBytes());
    }


    public JSONArray searchItemRequest() throws IOException {
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

    public void searchAlbumRequest() throws IOException {
        String id = "3TVXtAsR1Inumwj472S9r4";
        RestAssured.baseURI = "https://api.spotify.com/v1";

        RequestSpecification http = RestAssured.given();

        String response = http.given()
                .header("Authorization", String.format("Bearer %s" , accessToken())).given()
                .request(Method.GET, String.format("/artists/%s/albums", id)).asString();
        System.out.println(response);

    }

    public static void main(String[] args) throws IOException {
        SpotifyConnection connection = new SpotifyConnection();
        connection.searchAlbumRequest();
    }


}

