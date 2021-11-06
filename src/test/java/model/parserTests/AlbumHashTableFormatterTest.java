package model.parserTests;

import com.jayway.jsonpath.JsonPath;
import model.parser.AlbumHashTable;
import model.parser.AlbumHashTableBuilder;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class AlbumHashTableFormatterTest {

    @Test
    public void formatDrakeAlbumsTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("albums.json");
        JSONArray inputArray = JsonPath.read(inputStream,"$..items");

        AlbumHashTable albumHashTable = new AlbumHashTable();
        AlbumHashTableBuilder albumHashTableBuilder = new AlbumHashTableBuilder(inputArray);
        albumHashTableBuilder.buildHashTable(albumHashTable);

        String formattedHashTable = albumHashTable.formatTable();
        Assertions.assertEquals(expectedString(),formattedHashTable);

    }

    private String expectedString(){
        return """

                Album Name: Certified Lover Boy
                Album Id: 3SpBlxme9WbeQdI9kx7KAV
                Uri: spotify:album:3SpBlxme9WbeQdI9kx7KAV
                Release Date: 2021-09-03
                Total Tracks: 21

                Album Name: Certified Lover Boy
                Album Id: 6sp02aeyiwfX35xRqwNiPv
                Uri: spotify:album:6sp02aeyiwfX35xRqwNiPv
                Release Date: 2020-05-01
                Total Tracks: 14

                Album Name: Dark Lane Demo Tapes
                Album Id: 6OQ9gBfg5EXeNAEwGSs6jK
                Uri: spotify:album:6OQ9gBfg5EXeNAEwGSs6jK
                Release Date: 2019-08-02
                Total Tracks: 17

                Album Name: Dark Lane Demo Tapes
                Album Id: 45c1tgTktunRMmfh3WVh8U
                Uri: spotify:album:45c1tgTktunRMmfh3WVh8U
                Release Date: 2019-02-14
                Total Tracks: 18

                Album Name: Care Package
                Album Id: 7dqpveMVcWgbzqYrOdkFTD
                Uri: spotify:album:7dqpveMVcWgbzqYrOdkFTD
                Release Date: 2018-06-29
                Total Tracks: 25

                Album Name: Care Package
                Album Id: 6CY70qRxPutN3VKfYhNREa
                Uri: spotify:album:6CY70qRxPutN3VKfYhNREa
                Release Date: 2017-03-18
                Total Tracks: 22

                Album Name: So Far Gone
                Album Id: 2podUJIFG8hLfFz7Kqe8yJ
                Uri: spotify:album:2podUJIFG8hLfFz7Kqe8yJ
                Release Date: 2016-05-06
                Total Tracks: 20

                Album Name: Scorpion
                Album Id: 1ATL5GLyefJaxhQzSPVrLX
                Uri: spotify:album:1ATL5GLyefJaxhQzSPVrLX
                Release Date: 2015-09-20
                Total Tracks: 11

                Album Name: Scorpion
                Album Id: 42wvKYHFezpmDuAP43558f
                Uri: spotify:album:42wvKYHFezpmDuAP43558f
                Release Date: 2015-02-12
                Total Tracks: 17

                Album Name: More Life
                Album Id: 1lXY618HWkwYKJWBRYR4MK
                Uri: spotify:album:1lXY618HWkwYKJWBRYR4MK
                Release Date: 2013-01-01
                Total Tracks: 15
                """;
    }
}
