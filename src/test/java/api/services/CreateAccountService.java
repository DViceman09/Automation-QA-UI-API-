package api.services;

import api.pojos.CreateAccountRequest;
import api.pojos.SearchProductRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.cucumber.core.internal.com.fasterxml.jackson.databind.type.LogicalType.Map;
import static io.restassured.RestAssured.*;

public class CreateAccountService {
    private static final String ENDPOINT = "/createAccount";

    public Response createAccount()
    {
        CreateAccountRequest requestBody = new CreateAccountRequest("Saurav", "saurav@gmail.com","qwerty123","Mr",24,06,1990,"Saurav","Ganguly", "Gaming", "xyzzy", "xyzzy", "India", "12312312", "Gujaarat", "Ahmdavad", "1324234234");

        Map<String, Object> formData = new HashMap<>();
        formData.put("name", requestBody.getName());
        formData.put("email", requestBody.getEmail());
        formData.put("password", requestBody.getPassword());
        formData.put("title", requestBody.getTitle());
        formData.put("birth_date", requestBody.getBirth_date());
        formData.put("birth_month", requestBody.getBirth_month());
        formData.put("birth_year", requestBody.getBirth_year());
        formData.put("firstname", requestBody.getFirstname());
        formData.put("lastname", requestBody.getLastname());
        formData.put("company", requestBody.getCompany());
        formData.put("address1", requestBody.getAddress1());
        formData.put("address2", requestBody.getAddress2());
        formData.put("country", requestBody.getCountry());
        formData.put("zipcode", requestBody.getZipcode());
        formData.put("city", requestBody.getCity());
        formData.put("state", requestBody.getState());
        formData.put("mobile_number", requestBody.getMobile_number());

        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .contentType("application/x-www-form-urlencoded")
                .formParams(formData)
                .when()
                .post(ENDPOINT)
                .then()
                .extract()
                .response();
    }
}
