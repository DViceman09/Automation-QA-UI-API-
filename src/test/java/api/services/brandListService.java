package api.services;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class brandListService {
    private static final String ENDPOINT = "/brandsList";

    public Response getAllBrandsList() {
        return given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .get(ENDPOINT);
    }

    public Response updateAllBrandsList() {
        return given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .put(ENDPOINT);
    }

}
