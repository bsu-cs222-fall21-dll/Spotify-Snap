package model;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.enums.ModelObjectType;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.special.SearchResult;
import com.wrapper.spotify.requests.data.search.SearchItemRequest;
import org.apache.hc.core5.http.ParseException;
import view.ArtistFinder;

import java.io.IOException;

public class findArtist {
    getAccessToken getAccessToken = new getAccessToken();
    ArtistFinder artistFinder = new ArtistFinder();

    public String clientAccessToken = getAccessToken.getAccessToken();

    private final String q = artistFinder.getArtist();
    private final String type = ModelObjectType.ARTIST.getType();

    private final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setAccessToken(clientAccessToken)
            .build();

    private final SearchItemRequest searchItemRequest = spotifyApi.searchItem(q, type).build();

    public findArtist() throws IOException, ParseException, SpotifyWebApiException {
    }

    public void searchArtists_Sync() {
        try {
            final SearchResult searchResult = searchItemRequest.execute();

            System.out.println("Artist: " + searchResult.getArtists());
        } catch (IOException | SpotifyWebApiException | org.apache.hc.core5.http.ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
