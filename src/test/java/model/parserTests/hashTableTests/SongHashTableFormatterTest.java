package model.parserTests.hashTableTests;

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
    @Test
    public void formatSongsTableSlayerTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("diabolusInMusicaSongsTest.json");
        JSONArray inputArray = JsonPath.read(inputStream,"$..items");

        SongHashTable songHashTable = new SongHashTable();
        HashTableBuilder hashTableBuilder = new SongHashTableBuilder(inputArray);
        hashTableBuilder.buildHashTable(songHashTable);

        songHashTable.sortHashMapIntoArrayList();
        String formattedHashTable = songHashTable.formatTable();
        Assertions.assertEquals(secondExpectedString(),formattedHashTable);

    }

    private String expectedString(){
        return """
                Index: 1
                Song Name: Champagne Poetry
                Song Id: 2HSmyk2qMN8WQjuGhaQgCk
                Uri: spotify:track:2HSmyk2qMN8WQjuGhaQgCk
                Duration in MS: 336511
                Explicit: true
                Track Number: 1
                                
                                
                Index: 2
                Song Name: Papi's Home
                Song Id: 6jy9yJfgCsMHdu2Oz4BGKX
                Uri: spotify:track:6jy9yJfgCsMHdu2Oz4BGKX
                Duration in MS: 178623
                Explicit: true
                Track Number: 2
                                
                                
                Index: 3
                Song Name: Girls Want Girls (with Lil Baby)
                Song Id: 37Nqx7iavZpotJSDXZWbJ3
                Uri: spotify:track:37Nqx7iavZpotJSDXZWbJ3
                Duration in MS: 221979
                Explicit: true
                Track Number: 3
                                
                                
                Index: 4
                Song Name: In The Bible (with Lil Durk & Giveon)
                Song Id: 61S79KIVA4I9FXbnsylEHT
                Uri: spotify:track:61S79KIVA4I9FXbnsylEHT
                Duration in MS: 296568
                Explicit: true
                Track Number: 4
                                
                                
                Index: 5
                Song Name: Love All (with JAY-Z)
                Song Id: 4VCbgIdr8ptegWeJpqLVHH
                Uri: spotify:track:4VCbgIdr8ptegWeJpqLVHH
                Duration in MS: 228461
                Explicit: true
                Track Number: 5
                                
                                
                Index: 6
                Song Name: Fair Trade (with Travis Scott)
                Song Id: 40iJIUlhi6renaREYGeIDS
                Uri: spotify:track:40iJIUlhi6renaREYGeIDS
                Duration in MS: 291175
                Explicit: true
                Track Number: 6
                                
                                
                Index: 7
                Song Name: Way 2 Sexy (with Future & Young Thug)
                Song Id: 0k1WUmIRnG3xU6fvvDVfRG
                Uri: spotify:track:0k1WUmIRnG3xU6fvvDVfRG
                Duration in MS: 257604
                Explicit: true
                Track Number: 7
                                
                                
                Index: 8
                Song Name: TSU
                Song Id: 4s7QLoImIwmPi9L6dq1nVW
                Uri: spotify:track:4s7QLoImIwmPi9L6dq1nVW
                Duration in MS: 308755
                Explicit: true
                Track Number: 8
                                
                                
                Index: 9
                Song Name: N 2 Deep
                Song Id: 34D6FJysnQioVingDKufuf
                Uri: spotify:track:34D6FJysnQioVingDKufuf
                Duration in MS: 273577
                Explicit: true
                Track Number: 9
                                
                                
                Index: 10
                Song Name: Pipe Down
                Song Id: 11pEKMLmavDu8fxOB5QjbQ
                Uri: spotify:track:11pEKMLmavDu8fxOB5QjbQ
                Duration in MS: 205721
                Explicit: true
                Track Number: 10
                                
                                
                Index: 11
                Song Name: Yebba's Heartbreak
                Song Id: 1PDP7mLiAMwhfmgIwzhOm2
                Uri: spotify:track:1PDP7mLiAMwhfmgIwzhOm2
                Duration in MS: 133762
                Explicit: true
                Track Number: 11
                                
                                
                Index: 12
                Song Name: No Friends In The Industry
                Song Id: 2tUL6dZf1mywCj5WvCPZw6
                Uri: spotify:track:2tUL6dZf1mywCj5WvCPZw6
                Duration in MS: 204346
                Explicit: true
                Track Number: 12
                                
                                
                Index: 13
                Song Name: Knife Talk (with 21 Savage ft. Project Pat)
                Song Id: 2BcMwX1MPV6ZHP4tUT9uq6
                Uri: spotify:track:2BcMwX1MPV6ZHP4tUT9uq6
                Duration in MS: 242965
                Explicit: true
                Track Number: 13
                                
                                
                Index: 14
                Song Name: 7am On Bridle Path
                Song Id: 42m3eP1JJhtzffal9B136J
                Uri: spotify:track:42m3eP1JJhtzffal9B136J
                Duration in MS: 239635
                Explicit: true
                Track Number: 14
                                
                                
                Index: 15
                Song Name: Race My Mind
                Song Id: 2Q3jFbyE61mCjS3SkW4toJ
                Uri: spotify:track:2Q3jFbyE61mCjS3SkW4toJ
                Duration in MS: 269883
                Explicit: true
                Track Number: 15
                                
                                
                Index: 16
                Song Name: Fountains (with Tems)
                Song Id: 08XWh5c0BMyD1nKVxxl91z
                Uri: spotify:track:08XWh5c0BMyD1nKVxxl91z
                Duration in MS: 192417
                Explicit: true
                Track Number: 16
                                
                                
                Index: 17
                Song Name: Get Along Better
                Song Id: 5ScbulRnixQ2XAdvrPMFjz
                Uri: spotify:track:5ScbulRnixQ2XAdvrPMFjz
                Duration in MS: 229303
                Explicit: true
                Track Number: 17
                                
                                
                Index: 18
                Song Name: You Only Live Twice (with Lil Wayne & Rick Ross)
                Song Id: 50ceCGZ3oD3U5caQV5bP6f
                Uri: spotify:track:50ceCGZ3oD3U5caQV5bP6f
                Duration in MS: 213103
                Explicit: true
                Track Number: 18
                                
                                
                Index: 19
                Song Name: IMY2 (with Kid Cudi)
                Song Id: 7F9cT6hIRhnFCYP6GKS0tf
                Uri: spotify:track:7F9cT6hIRhnFCYP6GKS0tf
                Duration in MS: 252378
                Explicit: true
                Track Number: 19
                                
                                
                Index: 20
                Song Name: F*****g Fans
                Song Id: 3RkNXZvOSMMElmmXztDc94
                Uri: spotify:track:3RkNXZvOSMMElmmXztDc94
                Duration in MS: 245131
                Explicit: true
                Track Number: 20
                                
                                
                """;
    }

    private String secondExpectedString(){
        return """
                Index: 1
                Song Name: Bitter Peace
                Song Id: 7Amiwp5D26ULS0qgMRPkpa
                Uri: spotify:track:7Amiwp5D26ULS0qgMRPkpa
                Duration in MS: 272080
                Explicit: true
                Track Number: 1
                                
                                
                Index: 2
                Song Name: Death's Head
                Song Id: 5Y64EBsSx34nTB4gB1kAFv
                Uri: spotify:track:5Y64EBsSx34nTB4gB1kAFv
                Duration in MS: 209373
                Explicit: true
                Track Number: 2
                                
                                
                Index: 3
                Song Name: Stain Of Mind
                Song Id: 35CwMBsnwRDHpAY9F9wY6e
                Uri: spotify:track:35CwMBsnwRDHpAY9F9wY6e
                Duration in MS: 205093
                Explicit: true
                Track Number: 3
                                
                                
                Index: 4
                Song Name: Overt Enemy
                Song Id: 7vlEsbJ73GcQtz6sMzZmEP
                Uri: spotify:track:7vlEsbJ73GcQtz6sMzZmEP
                Duration in MS: 281533
                Explicit: true
                Track Number: 4
                                
                                
                Index: 5
                Song Name: Perversions Of Pain
                Song Id: 0G1jkkBpIo6GO7Tl4fC6zq
                Uri: spotify:track:0G1jkkBpIo6GO7Tl4fC6zq
                Duration in MS: 210573
                Explicit: true
                Track Number: 5
                                
                                
                Index: 6
                Song Name: Love To Hate
                Song Id: 4iVPjXyOfqZq5Yr5dRY6vW
                Uri: spotify:track:4iVPjXyOfqZq5Yr5dRY6vW
                Duration in MS: 185840
                Explicit: true
                Track Number: 6
                                
                                
                Index: 7
                Song Name: Desire
                Song Id: 4wXvXAdwC7549nwLmlsp65
                Uri: spotify:track:4wXvXAdwC7549nwLmlsp65
                Duration in MS: 258653
                Explicit: true
                Track Number: 7
                                
                                
                Index: 8
                Song Name: In The Name Of God
                Song Id: 5Tpe1VCcAfrUBNlXOiz51p
                Uri: spotify:track:5Tpe1VCcAfrUBNlXOiz51p
                Duration in MS: 218066
                Explicit: true
                Track Number: 8
                                
                                
                Index: 9
                Song Name: Scrum
                Song Id: 15OQUYrEXrWIFWoycUjp16
                Uri: spotify:track:15OQUYrEXrWIFWoycUjp16
                Duration in MS: 138760
                Explicit: true
                Track Number: 9
                                
                                
                Index: 10
                Song Name: Screaming From The Sky
                Song Id: 2UcpWK46N1M3Nlrddpd2Up
                Uri: spotify:track:2UcpWK46N1M3Nlrddpd2Up
                Duration in MS: 192600
                Explicit: true
                Track Number: 10
                                
                                
                Index: 11
                Song Name: Point
                Song Id: 5N78cLYc3piYCFvwSEljjD
                Uri: spotify:track:5N78cLYc3piYCFvwSEljjD
                Duration in MS: 252586
                Explicit: true
                Track Number: 11
                                
                                                
                """;
    }
}
