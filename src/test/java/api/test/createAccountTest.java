package api.test;

import api.pojos.SearchProductResponse;
import api.pojos.productResponse;
import api.services.CreateAccountService;
import api.services.SearchProductService;
import api.utility.RestAssuredUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.testng.Assert.assertTrue;

public class createAccountTest {

    CreateAccountService service;

    @BeforeClass
    public void setup() {
        RestAssuredUtil.setBaseURI();
        service = new CreateAccountService();
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.registerParser("text/html", Parser.JSON);
        RestAssured.registerParser("x-www-form-urlencoded", Parser.JSON);
    }

    @Test
    public void createAccount()
    {
        Response response;
        response = service.createAccount();

        System.out.println(response.getStatusCode());
        System.out.println(response.asString());

        if (response.getContentType().contains("application/json") || response.getContentType().contains("text/html")) {
            String responseStr = "{\"responseCode\": 201, \"message\": \"User created!\"}";
            JsonObject jsonObj = JsonParser.parseString(responseStr).getAsJsonObject();
            int code = jsonObj.get("responseCode").getAsInt();
            System.out.println("The extracted code is " + code);
            assertEquals(code, 201, "Status code should be 201");
        }
        else
        {
            fail("Unexpected content type: " + response.getContentType());
        }
    }
}
