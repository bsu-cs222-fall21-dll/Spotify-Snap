package model.parserTests;

import com.jayway.jsonpath.JsonPath;
import model.parser.hashtable.*;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class SongHashTableFormatterTest {
    @Test
    public void formatSongsTableTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("songs.json");
        JSONArray inputArray = JsonPath.read(inputStream,"$..items");

        SongHashTable songHashTable = new SongHashTable();
        HashTableBuilder hashTableBuilder = new SongHashTableBuilder(inputArray);
        hashTableBuilder.buildHashTable(songHashTable);

        songHashTable.sortHashMapIntoArrayList();
        String formattedHashTable = songHashTable.formatTable();
        Assertions.assertEquals(expectedString(),formattedHashTable);

    }

    private String expectedString(){
        return """
                                
                Song Name: Champagne Poetry
                Song Id: 2HSmyk2qMN8WQjuGhaQgCk
                Uri: spotify:track:2HSmyk2qMN8WQjuGhaQgCk
                Duration in MS: 336511
                Explicit: true
                Track Number: 1
                                
                                
                Song Name: Papi\uFFFDs Home
                Song Id: 6jy9yJfgCsMHdu2Oz4BGKX
                Uri: spotify:track:6jy9yJfgCsMHdu2Oz4BGKX
                Duration in MS: 178623
                Explicit: true
                Track Number: 2
                                
                                
                Song Name: Girls Want Girls (with Lil Baby)
                Song Id: 37Nqx7iavZpotJSDXZWbJ3
                Uri: spotify:track:37Nqx7iavZpotJSDXZWbJ3
                Duration in MS: 221979
                Explicit: true
                Track Number: 3
                                
                                
                Song Name: In The Bible (with Lil Durk & Giveon)
                Song Id: 61S79KIVA4I9FXbnsylEHT
                Uri: spotify:track:61S79KIVA4I9FXbnsylEHT
                Duration in MS: 296568
                Explicit: true
                Track Number: 4
                                
                                
                Song Name: Love All (with JAY-Z)
                Song Id: 4VCbgIdr8ptegWeJpqLVHH
                Uri: spotify:track:4VCbgIdr8ptegWeJpqLVHH
                Duration in MS: 228461
                Explicit: true
                Track Number: 5
                                
                                
                Song Name: Fair Trade (with Travis Scott)
                Song Id: 40iJIUlhi6renaREYGeIDS
                Uri: spotify:track:40iJIUlhi6renaREYGeIDS
                Duration in MS: 291175
                Explicit: true
                Track Number: 6
                                
                                
                Song Name: Way 2 Sexy (with Future & Young Thug)
                Song Id: 0k1WUmIRnG3xU6fvvDVfRG
                Uri: spotify:track:0k1WUmIRnG3xU6fvvDVfRG
                Duration in MS: 257604
                Explicit: true
                Track Number: 7
                                
                                
                Song Name: TSU
                Song Id: 4s7QLoImIwmPi9L6dq1nVW
                Uri: spotify:track:4s7QLoImIwmPi9L6dq1nVW
                Duration in MS: 308755
                Explicit: true
                Track Number: 8
                                
                                
                Song Name: N 2 Deep
                Song Id: 34D6FJysnQioVingDKufuf
                Uri: spotify:track:34D6FJysnQioVingDKufuf
                Duration in MS: 273577
                Explicit: true
                Track Number: 9
                                
                                
                Song Name: Pipe Down
                Song Id: 11pEKMLmavDu8fxOB5QjbQ
                Uri: spotify:track:11pEKMLmavDu8fxOB5QjbQ
                Duration in MS: 205721
                Explicit: true
                Track Number: 10
                                
                                
                Song Name: Yebba\uFFFDs Heartbreak
                Song Id: 1PDP7mLiAMwhfmgIwzhOm2
                Uri: spotify:track:1PDP7mLiAMwhfmgIwzhOm2
                Duration in MS: 133762
                Explicit: true
                Track Number: 11
                                
                                
                Song Name: No Friends In The Industry
                Song Id: 2tUL6dZf1mywCj5WvCPZw6
                Uri: spotify:track:2tUL6dZf1mywCj5WvCPZw6
                Duration in MS: 204346
                Explicit: true
                Track Number: 12
                                
                                
                Song Name: Knife Talk (with 21 Savage ft. Project Pat)
                Song Id: 2BcMwX1MPV6ZHP4tUT9uq6
                Uri: spotify:track:2BcMwX1MPV6ZHP4tUT9uq6
                Duration in MS: 242965
                Explicit: true
                Track Number: 13
                                
                                
                Song Name: 7am On Bridle Path
                Song Id: 42m3eP1JJhtzffal9B136J
                Uri: spotify:track:42m3eP1JJhtzffal9B136J
                Duration in MS: 239635
                Explicit: true
                Track Number: 14
                                
                                
                Song Name: Race My Mind
                Song Id: 2Q3jFbyE61mCjS3SkW4toJ
                Uri: spotify:track:2Q3jFbyE61mCjS3SkW4toJ
                Duration in MS: 269883
                Explicit: true
                Track Number: 15
                                
                                
                Song Name: Fountains (with Tems)
                Song Id: 08XWh5c0BMyD1nKVxxl91z
                Uri: spotify:track:08XWh5c0BMyD1nKVxxl91z
                Duration in MS: 192417
                Explicit: true
                Track Number: 16
                                
                """;
    }
}
