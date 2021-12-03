package model.parser.formatter;

import model.parser.Parser;
import model.type.MillisecondToMinuteConverter;
import model.type.Song;

public class SongFormatter extends Parser implements Formatter{


    public SongFormatter(Song song) {
        super(song.readInfoAsJsonArray());
    }

    public String format() {
        MillisecondToMinuteConverter millisecondToMinuteConverter = new MillisecondToMinuteConverter();


        String name = parseInfo("name");
        String id = parseInfo("id");
        String uri = parseInfo("uri");

        String duration_ms = parseInfo("duration_ms");
        String track_number = parseInfo("index");
        String explicit = parseInfo("explicit");
        // solution to unicode error found in the following thread
        // https://stackoverflow.com/questions/6198986/how-can-i-replace-non-printable-unicode-characters-in-java
        name = name.replaceAll("\uFFFD", "'");


        return String.format("\nSong Name: %s\nSong Id: %s\nUri: %s\nDuration in MIN: %s\nExplicit: %s\nTrack Number: %s\n",
                name,id,uri,millisecondToMinuteConverter.convertToMin(duration_ms),explicit,track_number);
    }
}
