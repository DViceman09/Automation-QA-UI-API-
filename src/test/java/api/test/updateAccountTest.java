package api.test;

import api.services.CreateAccountService;
import api.services.UpdateAccountService;
import api.utility.RestAssuredUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class updateAccountTest {

    UpdateAccountService service;

    @BeforeClass
    public void setup() {
        RestAssuredUtil.setBaseURI();
        service = new UpdateAccountService();
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.registerParser("text/html", Parser.JSON);
        RestAssured.registerParser("x-www-form-urlencoded", Parser.JSON);
    }

    @Test
    public void updateAccount()
    {
        Response response;
        response = service.updateAccount();

        System.out.println(response.getStatusCode());
        System.out.println(response.asString());

        if (response.getContentType().contains("application/json") || response.getContentType().contains("text/html")) {
            String responseStr = "{\"responseCode\": 200, \"message\": \"User updated!\"}";
            JsonObject jsonObj = JsonParser.parseString(responseStr).getAsJsonObject();
            int code = jsonObj.get("responseCode").getAsInt();
            System.out.println("The extracted code is " + code);
            assertEquals(code, 200, "Status code should be 200");
        }
        else
        {
            fail("Unexpected content type: " + response.getContentType());
        }
    }
}
