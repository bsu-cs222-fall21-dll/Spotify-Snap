package model;

import view.ClientCredentials;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class SpotifyConnection {

    public String accessToken() throws IOException {

        JSONAccessToken parse = new JSONAccessToken();
        return parse.parseAccessToken(authorizeCredentials());
    }

    public String encodeClientCredentials() {
        ClientCredentials credentials = new ClientCredentials();
        String clientID = credentials.getClientID();
        String clientSecret = credentials.getClientSecretID();
        return Base64.getEncoder().encodeToString((clientID + ":" + clientSecret).getBytes(StandardCharsets.UTF_8));
    }


    public String authorizeCredentials() throws IOException {
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
        String accessToken = new String(inputStream.readAllBytes());
        //System.out.println(accessToken);
        return accessToken;
    }


    public void searchItemRequest() throws IOException {
        String query = "https://api.spotify.com/v1/search"+ "?" + "q=Drake&type=artist"; //TODO this causes error code 400, need correct format

        URL url = new URL(query);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setDoOutput(true);

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization ", String.format("Bearer %s", accessToken()));

        connection.connect();

        InputStream inputStream = connection.getInputStream();
        String data = new String(inputStream.readAllBytes());
        System.out.println(data);

    }

    public static void main(String[] args) throws IOException {
        SpotifyConnection spotifyConnection = new SpotifyConnection();
        spotifyConnection.searchItemRequest();
    }

}

