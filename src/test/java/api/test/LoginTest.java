package api.test;

import api.pojos.SearchProductResponse;
import api.services.LoginService;
import api.services.ProductListService;
import api.utility.RestAssuredUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.pages.Login;

import static org.testng.Assert.fail;

public class LoginTest {
    LoginService loginService;

    @BeforeClass
    public void setup() {
        RestAssuredUtil.setBaseURI();
        loginService = new LoginService();
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.registerParser("text/html", Parser.JSON);
        RestAssured.registerParser("x-www-form-urlencoded", Parser.JSON);
    }

    @Test
    public void testValidLogin()
    {
        Response response = loginService.verifyLoginWithValidCreds();

        System.out.println(response.getStatusCode());
        System.out.println(response.asString());

        if (response.getContentType().contains("application/json") || response.getContentType().contains("text/html"))
        {
            // Deserialize response
            SearchProductResponse searchResponse = response.as(SearchProductResponse.class);

            // Validate products are returned
            String responseStr = "{\"responseCode\": 200, \"message\": \"User exists!\"}";
            JsonObject jsonObj = JsonParser.parseString(responseStr).getAsJsonObject();
            int code = jsonObj.get("responseCode").getAsInt();
            String message = jsonObj.get("message").getAsString();
            System.out.println("The extracted code is " + code);
            System.out.println("The extracted message is " + message);
            Assert.assertEquals(code, 200);
            Assert.assertEquals(message, "User exists!");

        }
        else
        {
            fail("Unexpected content type: " + response.getContentType());
        }
    }

    @Test
    public void testLoginWithoutEmail()
    {
        Response response = loginService.verifyWithoutEmail();
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());

        if (response.getContentType().contains("application/json") || response.getContentType().contains("text/html"))
        {
            // Deserialize response
            SearchProductResponse searchResponse = response.as(SearchProductResponse.class);

            // Validate products are returned
            String responseStr = "{\"responseCode\": 400, \"message\": \"Bad request, email or password parameter is missing in POST request.\"}";
            JsonObject jsonObj = JsonParser.parseString(responseStr).getAsJsonObject();
            int code = jsonObj.get("responseCode").getAsInt();
            String message = jsonObj.get("message").getAsString();
            System.out.println("The extracted code is " + code);
            System.out.println("The extracted message is " + message);
            Assert.assertEquals(code, 400);
            Assert.assertEquals(message, "Bad request, email or password parameter is missing in POST request.");
        }
        else
        {
            fail("Unexpected content type: " + response.getContentType());
        }
    }

    @Test
    public void testDeleteLogin()
    {
        Response response = loginService.verifyDeleteLogin();
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());

        if (response.getContentType().contains("application/json") || response.getContentType().contains("text/html"))
        {
            // Deserialize response
            SearchProductResponse searchResponse = response.as(SearchProductResponse.class);

            // Validate products are returned
            String responseStr = "{\"responseCode\": 405, \"message\": \"This request method is not supported.\"}";
            JsonObject jsonObj = JsonParser.parseString(responseStr).getAsJsonObject();
            int code = jsonObj.get("responseCode").getAsInt();
            String message = jsonObj.get("message").getAsString();
            System.out.println("The extracted code is " + code);
            System.out.println("The extracted message is " + message);
            Assert.assertEquals(code, 405);
            Assert.assertEquals(message, "This request method is not supported.");
        }
        else
        {
            fail("Unexpected content type: " + response.getContentType());
        }
    }

    @Test
    public void testInvalidLogin()
    {
        Response response = loginService.verifyLoginWithInvalidCreds();

        System.out.println(response.getStatusCode());
        System.out.println(response.asString());

        if (response.getContentType().contains("application/json") || response.getContentType().contains("text/html"))
        {
            // Deserialize response
            SearchProductResponse searchResponse = response.as(SearchProductResponse.class);

            // Validate products are returned
            String responseStr = "{\"responseCode\": 404, \"message\": \"User not found!\"}";
            JsonObject jsonObj = JsonParser.parseString(responseStr).getAsJsonObject();
            int code = jsonObj.get("responseCode").getAsInt();
            String message = jsonObj.get("message").getAsString();
            System.out.println("The extracted code is " + code);
            System.out.println("The extracted message is " + message);
            Assert.assertEquals(code, 404);
            Assert.assertEquals(message, "User not found!");

        }
        else
        {
            fail("Unexpected content type: " + response.getContentType());
        }
    }
}
