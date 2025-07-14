package api.services;

import api.pojos.LoginRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LoginService {
    private static final String ENDPOINT = "/verifyLogin";

    public Response verifyLoginWithValidCreds()
    {
        LoginRequest requestBody = new LoginRequest("dviceman09@gmail.com", "Faceless2");

        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .contentType("application/x-www-form-urlencoded")
                .formParam("email", requestBody.getEmailId())
                .formParam("password", requestBody.getPassword())
                .when()
                .post(ENDPOINT)
                .then()
                .extract()
                .response();
    }

    public Response verifyWithoutEmail()
    {
        LoginRequest requestBody = new LoginRequest();

        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .contentType("application/x-www-form-urlencoded")
                .when()
                .post(ENDPOINT)
                .then()
                .extract()
                .response();
    }

    public Response verifyDeleteLogin()
    {
        LoginRequest requestBody = new LoginRequest();

        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .contentType("application/x-www-form-urlencoded")
                .when()
                .delete(ENDPOINT)
                .then()
                .extract()
                .response();
    }

    public Response verifyLoginWithInvalidCreds()
    {
        LoginRequest requestBody = new LoginRequest("sandeshkadam@gmail.com", "GGWP@123");

        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .contentType("application/x-www-form-urlencoded")
                .formParam("email", requestBody.getEmailId())
                .formParam("password", requestBody.getPassword())
                .when()
                .post(ENDPOINT)
                .then()
                .extract()
                .response();
    }
}
