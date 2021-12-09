package model.requests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import model.type.AccessToken;

public abstract class AuthorizeCredentials {

    private String authorizeCredentials() {

        RestAssured.baseURI = "https://accounts.spotify.com/";
        RequestSpecification http = RestAssured.given();
        return http.given()
                .header("Authorization", String.format("Basic %s", clientCredentials())).given()
                .header("Content-Type", "application/x-www-form-urlencoded").given()
                .param("grant_type", "client_credentials")
                .request(Method.POST, "api/token").asString();
    }

    public String getAccessToken() {

        AccessToken parse = new AccessToken();
        return parse.parseAccessToken(authorizeCredentials());
    }

    private String clientCredentials() {

        return "MTVhZDNhZTM5NWZkNDRmMGEwNTlkZjJmZTNlYWJhZTE6MGU0NzcwYTQxMzk3NGEyNDg1M2M5MmE3NjI2ZWQwOTU=";
    }



}

