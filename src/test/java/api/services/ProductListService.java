package api.services;

import api.pojos.Product;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductListService {
    private static final String ENDPOINT = "/productsList";

    public Response getAllProducts() {
        return given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .get(ENDPOINT);
    }

    public Response setAllProducts(){
        return given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .post(ENDPOINT);
    }

}