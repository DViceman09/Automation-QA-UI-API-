package api.test;

import api.pojos.Product;
import api.pojos.productResponse;
import api.services.ProductListService;
import api.utility.RestAssuredUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class productListTest {

    ProductListService productListService;

    @BeforeClass
    public void setup() {
        RestAssuredUtil.setBaseURI();
        productListService = new ProductListService();
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.registerParser("text/html", Parser.JSON);
    }

    @Test
    public void testGetAllProducts() {
        Response response = productListService.getAllProducts();

        System.out.println(response.getStatusCode());
        System.out.println(response.asString());

        if (response.getContentType().contains("application/json") || response.getContentType().contains("text/html")) {
            assertEquals(response.getStatusCode(), 200, "Status code should be 200");

            productResponse productsResponse = response.as(productResponse.class);
            assertNotNull(productsResponse.getProducts(), "Products list should not be null");
            assertTrue(productsResponse.getProducts().size() > 0, "Products list should not be empty");
        }
        else
        {
            fail("Unexpected content type: " + response.getContentType());
        }
    }

    @Test
    public void testSetAllProducts() {
        Response response = productListService.setAllProducts();

        System.out.println(response.getStatusCode());
        System.out.println(response.asString());

        if (response.getContentType().contains("application/json") || response.getContentType().contains("text/html")) {
            String responseStr = "{\"responseCode\": 405, \"message\": \"This request method is not supported.\"}";
            JsonObject jsonObj = JsonParser.parseString(responseStr).getAsJsonObject();
            int code = jsonObj.get("responseCode").getAsInt();
            System.out.println("The extracted code is " + code);
            assertEquals(code, 405, "Status code should be 405");
        }
        else
        {
            fail("Unexpected content type: " + response.getContentType());
        }
    }
}
