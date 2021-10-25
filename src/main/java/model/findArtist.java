package model;


public class findArtist {
    /*
    AccessToken getAccessToken = new AccessToken();
    ArtistFinder artistFinder = new ArtistFinder();

    public String clientAccessToken = getAccessToken.connect();

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
 /*
    public void searchArtists_Sync() throws IOException, ParseException, SpotifyWebApiException {
        final String searchResult = searchArtistsRequest.execute();
        System.out.println(searchResult);
    }

  */

}
