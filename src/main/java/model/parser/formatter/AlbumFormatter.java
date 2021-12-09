package model.parser.formatter;

import model.parser.Parser;
import model.type.Album;

public class AlbumFormatter extends Parser implements Formatter{

    public AlbumFormatter(Album album) {
        super(album.readInfoAsJsonArray());
    }

    public String format() {

        String name = parseInfo("name");
        String id = parseInfo("id");
        String uri = parseInfo("uri");

        String date = parseInfo("date");
        String total = parseInfo("total_tracks");

        return String.format("\nAlbum Name: %s\nAlbum Id: %s\nUri: %s\nRelease Date: %s\nTotal Tracks: %s\n",
                name,id,uri,date,total);
    }

}
