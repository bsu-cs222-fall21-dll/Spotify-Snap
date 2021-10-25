package model;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
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

    ClientCredentials credentials = new ClientCredentials();
    String clientID = credentials.getClientID();
    String clientSecret = credentials.getClientSecretID();

    private String accessToken() throws IOException {

        AccessTokenParser parse = new AccessTokenParser();
        return parse.parseAccessToken(authorizeCredentials());
    }

    private String encodeClientCredentials() {
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


    public String searchItemRequest() throws IOException {
        UserInput input = new UserInput();
        RestAssured.baseURI = "https://api.spotify.com/v1";

        RequestSpecification http = RestAssured.given();
        String response =  http.given()
                .header("Authorization", String.format("Bearer %s" , accessToken())).given()
                .param("q",input.getArtist())
                .param("type", input.getTypes())

                .request(Method.GET, "/search").asString();
        System.out.println(response);

        return response;
    }

    public static void main(String[] args) throws IOException {
        SpotifyConnection spotifyConnection = new SpotifyConnection();
        spotifyConnection.searchItemRequest();
    }

}

