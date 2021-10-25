package model;

import view.ClientCredentials;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class SpotifyConnection {

    JSONAccessToken parse = new JSONAccessToken();

    public String getAccessToken() throws IOException {

        return parse.parseAccessToken(authorizeCredentials());
    }


    ClientCredentials credentials = new ClientCredentials();
    String clientID = credentials.getClientID();
    String clientSecret = credentials.getClientSecretID();
    String encodedClient = Base64.getEncoder().encodeToString((clientID + ":" + clientSecret).getBytes(StandardCharsets.UTF_8));



    public String authorizeCredentials() throws IOException {
        URL url = new URL("https://accounts.spotify.com/api/token");
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

        connection.setDoOutput(true);
        connection.setDoInput(true);

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization",String.format("Basic %s", encodedClient));
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        String urlBody = "grant_type=client_credentials";

        byte[] out = urlBody.getBytes(StandardCharsets.UTF_8);
        int length = out.length;
        connection.setFixedLengthStreamingMode(length);
        connection.connect();

        try (OutputStream outputStream = connection.getOutputStream()){
            outputStream.write(out);
        }

        InputStream inputStream = connection.getInputStream();
        String accessToken = new String(inputStream.readAllBytes());
        System.out.println(accessToken);
        return accessToken;
    }


}

