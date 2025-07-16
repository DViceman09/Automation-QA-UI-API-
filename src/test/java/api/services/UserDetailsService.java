package api.services;

import api.pojos.UserDetailsRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserDetailsService {
    private static final String ENDPOINT = "/getUserDetailByEmail";

    public Response getUserDetailsByEmail()
    {
        UserDetailsRequest requestBody = new UserDetailsRequest("saurav@gmail.com");

        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .contentType("application/x-www-form-urlencoded")
                .queryParam("email", requestBody.getEmail())
                .when()
                .get(ENDPOINT)
                .then()
                .extract()
                .response();
    }
}
