package model;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import org.apache.hc.core5.http.ParseException;
import view.ClientCredentials;

import java.io.IOException;

public class getAccessToken {
    ClientCredentials clientCredentials = new ClientCredentials();

    private final String clientId = clientCredentials.getClientID();
    private final String clientSecret = clientCredentials.getClientSecretID();

    private final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId(clientId)
            .setClientSecret(clientSecret)
            .build();
    private final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials()
            .build();

    public String getAccessToken() throws IOException, ParseException, SpotifyWebApiException {
        final com.wrapper.spotify.model_objects.credentials.ClientCredentials clientCredentials = clientCredentialsRequest.execute();
        String accessToken = clientCredentials.getAccessToken();
        return accessToken;
    }
}
