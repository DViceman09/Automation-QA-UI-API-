package api.services;

import api.pojos.SearchProductRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SearchProductService {
    private static final String ENDPOINT = "/searchProduct";

    public Response searchProduct() {

        SearchProductRequest requestBody = new SearchProductRequest("top");

        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .contentType("application/x-www-form-urlencoded")
                .formParam("search_product", requestBody.getSearch_product())
                .when()
                .post(ENDPOINT)
                .then()
                .extract()
                .response();
    }
}
