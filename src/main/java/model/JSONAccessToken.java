package model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class JSONAccessToken {

    public String parseAccessToken(String dataStream) {
        JSONArray array = JsonPath.read(dataStream, "$..access_token");
        return (String) array.get(0);
    }

    public String parseBearer(String dataStream) {
        JSONArray array = JsonPath.read(dataStream, "$..Bearer");
        return array.get(0).toString();
    }

}
