package api.services;

import api.pojos.DeleteAccountRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteAccountService {
    private static final String ENDPOINT = "/deleteAccount";

    public Response deleteAccount()
    {
        DeleteAccountRequest deleteAccountRequest = new DeleteAccountRequest("saurav@gmail.com", "qwerty123");
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .contentType("application/x-www-form-urlencoded")
                .formParam("email", deleteAccountRequest.getEmail())
                .formParam("password",deleteAccountRequest.getPassword())
                .when()
                .delete(ENDPOINT)
                .then()
                .extract()
                .response();
    }
}
