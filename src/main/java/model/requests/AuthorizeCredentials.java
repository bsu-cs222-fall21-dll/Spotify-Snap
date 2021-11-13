package model.requests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import model.parser.type.AccessToken;

public abstract class AuthorizeCredentials {
    //TODO Network Error Handler

    private String authorizeCredentials() {
        /*
          This method sends a POST request to the https://accounts.spotify.com/api/token endpoint of the Spotify OAuth 2.0 Service.

          The request must contain the following headers and parameters:
                      @header: Authorization: Base64 encoded Client Credentials
         *            @header: Content-Type: Encodes parameters to URL format
         *            @Param:  grant_Type: Client Credentials
         *
         * @return: Access Token in Json format from Spotify Web Api
         */
        RestAssured.baseURI = "https://accounts.spotify.com/";

        RequestSpecification http = RestAssured.given();
        return http.given()
                .header("Authorization", String.format("Basic %s", clientCredentials())).given()
                .header("Content-Type", "application/x-www-form-urlencoded").given()
                .param("grant_type", "client_credentials")
                .request(Method.POST, "api/token").asString();
    }

    public String getAccessToken() {
        /*
          This method gets the parse access token in AccessTokenParser class

          @return: Parsed access token
         */
        AccessToken parse = new AccessToken();
        return parse.parseAccessToken(authorizeCredentials());
    }

    private String clientCredentials() {
        /*
          @return: Base 64 encoded string that contains the client ID and client secret key.
         */

        return "MTVhZDNhZTM5NWZkNDRmMGEwNTlkZjJmZTNlYWJhZTE6MGU0NzcwYTQxMzk3NGEyNDg1M2M5MmE3NjI2ZWQwOTU=";
    }



}

