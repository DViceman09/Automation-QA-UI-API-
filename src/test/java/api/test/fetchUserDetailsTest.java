package api.test;

import api.pojos.BrandsResponse;
import api.pojos.UserDetailsResponse;
import api.services.UserDetailsService;
import api.services.brandListService;
import api.utility.RestAssuredUtil;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.testng.Assert.fail;

public class fetchUserDetailsTest {

    UserDetailsService service;

    @BeforeClass
    public void setup() {
        RestAssuredUtil.setBaseURI();
        service = new UserDetailsService();
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.registerParser("text/html", Parser.JSON);
    }

    @Test
    public void getUserDetailsByEmail()
    {
        Response response = service.getUserDetailsByEmail();

        System.out.println(response.getStatusCode());
        System.out.println(response.asString());

        if (response.getContentType().contains("application/json") || response.getContentType().contains("text/html")) {
            assertEquals(response.getStatusCode(), 200, "Status code should be 200");

            UserDetailsResponse userDetails = response.as(UserDetailsResponse.class);
            Assert.assertEquals(userDetails.getUser().getEmail(), "saurav@gmail.com");
            Assert.assertEquals(userDetails.getUser().getName(), "Saussarav");
            Assert.assertEquals(userDetails.getResponseCode(), "200");
        }
        else
        {
            fail("Unexpected content type: " + response.getContentType());
        }
    }
}
