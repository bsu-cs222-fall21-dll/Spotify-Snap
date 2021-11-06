package model.parser;

public class AlbumFormatter extends Parser {

    public AlbumFormatter(Album album) {
        super(album.readAlbumInfoAsJson());
    }

    public String formatAlbum() {
        String name = parseInfo("name");
        String id = parseInfo("id");
        String uri = parseInfo("uri");

        String date = parseInfo("date");
        String total = parseInfo("total_tracks");

        return String.format("\nAlbum Name: %s\nAlbum Id: %s\nUri: %s\nRelease Date: %s\nTotal Tracks: %s",
                name,id,uri,date,total);
    }

}
