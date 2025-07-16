package api.services;

import api.pojos.CreateAccountRequest;
import api.pojos.UpdateAccountRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class UpdateAccountService {
    private static final String ENDPOINT = "/updateAccount";

    public Response updateAccount()
    {
        UpdateAccountRequest requestBody = new UpdateAccountRequest("Saussarav", "saurav@gmail.com","qwerty123","Mr",21,05,1990,"Sauyrav","Gangyuly", "Gamling", "xyzlzy", "xyzzly", "Inldia", "123123h12", "Gujaarat", "Ahmdkavad", "1324234k234");

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
                .put(ENDPOINT)
                .then()
                .extract()
                .response();
    }
}
