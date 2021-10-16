package model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class SearcherTest {

    @Test
    public void parseIdTest() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("TestSearch.json");
        JSONArray testArray = JsonPath.read(inputStream,"$.*");
        Searcher searcher = new Searcher();

        String result = searcher.parseId(testArray);
        Assertions.assertEquals("7dGJo4pcD2V6oG8kP0tJRR",result);

    }
}
