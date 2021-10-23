package model;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.enums.ModelObjectType;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Artist;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.requests.data.search.simplified.SearchArtistsRequest;
import org.apache.hc.core5.http.ParseException;
import view.ArtistFinder;

import java.io.IOException;


public class findArtist {
    GetAccessToken getAccessToken = new GetAccessToken();
    ArtistFinder artistFinder = new ArtistFinder();

    public String clientAccessToken = getAccessToken.getAccessToken();

    private final String q = artistFinder.getArtist();
    private final String type = ModelObjectType.ARTIST.getType();

    private final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setAccessToken(clientAccessToken)
            .build();


    //private final SearchItemRequest searchItemRequest = spotifyApi.searchItem(q, type).build();

    private final SearchArtistsRequest searchArtistsRequest = spotifyApi.searchArtists(q)
//          .market(CountryCode.SE)
            .limit(1)
//          .offset(0)
//          .includeExternal("audio")
            .build();

    public findArtist() throws IOException, ParseException, SpotifyWebApiException {
    }

    public void searchArtists_Sync() {
        try {
            final Paging<Artist> searchResult = searchArtistsRequest.execute();

            System.out.println("Artist: " + searchResult);

        } catch (IOException | SpotifyWebApiException | org.apache.hc.core5.http.ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
