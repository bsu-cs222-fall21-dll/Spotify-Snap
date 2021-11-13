package model.parser.formatter;

import model.parser.type.Album;
import model.parser.Parser;

public class AlbumFormatter extends Parser implements Formatter{

    public AlbumFormatter(Album album) {
        super(album.readAlbumInfoAsJson());
    }

    public String format() {
        String name = parseInfo("name");
        String id = parseInfo("id");
        String uri = parseInfo("uri");

        String date = parseInfo("date");
        String total = parseInfo("total_tracks");

        return String.format("\nAlbum Name: %s\nAlbum Id: %s\nUri: %s\nRelease Date: %s\nTotal Tracks: %s",
                name,id,uri,date,total);
    }

}
