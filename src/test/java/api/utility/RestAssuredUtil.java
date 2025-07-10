package api.utility;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;
import org.testng.Assert;

import static io.restassured.RestAssured.*;


public class RestAssuredUtil {
        public static void setBaseURI()
        {
            RestAssured.baseURI = "https://automationexercise.com/api";
        }
        // Add more as needed...
}
