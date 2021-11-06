package model.parser;

public class ArtistFormatter extends Parser {


    public ArtistFormatter(Artist artist) {
        super(artist.readArtistInfoAsJson());
    }

    public String formatSnapArtist() {

        String name = parseInfo("name");
        String id = parseInfo("id");
        String uri = parseInfo("uri");

        String url = parseInfo("url");
        String total = parseInfo("total");

        return String.format("\nArtist Name: %s\nArtist Id: %s\nExternal URL: %s\nUri: %s\nFollower Count: %s",
                name,id,url,uri,total);
    }
}
