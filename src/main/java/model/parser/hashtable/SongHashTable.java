package model.parser.hashtable;

import model.parser.Album;
import model.parser.Song;
import model.parser.formatter.AlbumFormatter;
import model.parser.formatter.SongFormatter;

public class SongHashTable extends SnapHashTable {

    @Override
    public void sortHashMapIntoArrayList(){
        int sizeOfArrayList = snapHashMap.size();
        String[] sortedAlbumArray = new String[sizeOfArrayList];
        snapHashMap.forEach((songID, song) -> {

            SongFormatter songFormatter = new SongFormatter((Song) song);
            String songString = songFormatter.format();
            int index = Integer.parseInt(songFormatter.parseInfo("index"))-1;

            sortedAlbumArray[index] = songString;

        });
        this.snapArray = sortedAlbumArray;
    }
}
