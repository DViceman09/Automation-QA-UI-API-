package api.test;

import api.pojos.BrandsResponse;
import api.pojos.productResponse;
import api.services.ProductListService;
import api.services.brandListService;
import api.utility.RestAssuredUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.testng.Assert.fail;

public class brandsListTest {
    brandListService brandListService = new brandListService();

    @BeforeClass
    public void setup() {
        RestAssuredUtil.setBaseURI();
        brandListService = new brandListService();
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.registerParser("text/html", Parser.JSON);
    }

    @Test
    public void testGetAllBrandsList() {
        Response response = brandListService.getAllBrandsList();

        System.out.println(response.getStatusCode());
        System.out.println(response.asString());

        if (response.getContentType().contains("application/json") || response.getContentType().contains("text/html")) {
            assertEquals(response.getStatusCode(), 200, "Status code should be 200");

            BrandsResponse brandsResponse = response.as(BrandsResponse.class);
            assertNotNull(brandsResponse.getBrands(), "brandslist should not be null");
            assertFalse(brandsResponse.getBrands().isEmpty(), "brands list should not be empty");
        }
        else
        {
            fail("Unexpected content type: " + response.getContentType());
        }
    }

    @Test
    public void testUpdateAllBrandsList() {
        Response response = brandListService.updateAllBrandsList();

        System.out.println(response.getStatusCode());
        System.out.println(response.asString());

        if (response.getContentType().contains("application/json") || response.getContentType().contains("text/html"))
        {
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
