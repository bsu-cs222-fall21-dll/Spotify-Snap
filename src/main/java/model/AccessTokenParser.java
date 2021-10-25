package model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class AccessTokenParser {

    public String parseAccessToken(String dataStream) {
        JSONArray array = JsonPath.read(dataStream, "$..access_token");
        return (String) array.get(0);
    }

}
