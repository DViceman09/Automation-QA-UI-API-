package api.test;

import api.pojos.Product;
import api.pojos.SearchProductResponse;
import api.services.ProductListService;
import api.services.SearchProductService;
import api.utility.RestAssuredUtil;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class SearchProductTest {

    SearchProductService service;

    @BeforeClass
    public void setup() {
        RestAssuredUtil.setBaseURI();
        service = new SearchProductService();
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.registerParser("text/html", Parser.JSON);
        RestAssured.registerParser("x-www-form-urlencoded", Parser.JSON);
    }

    @Test
    public void testSearchProduct() {


        Response response;
        response = service.searchProduct();

        System.out.println(response.getStatusCode());
        System.out.println(response.asString());

        if (response.getContentType().contains("application/json") || response.getContentType().contains("text/html"))
        {
            // Validate status code
            Assert.assertEquals(response.getStatusCode(), 200);

            // Deserialize response
            SearchProductResponse searchResponse = response.as(SearchProductResponse.class);

            // Validate products are returned
            Assert.assertNotNull(searchResponse.getProducts());
            Assert.assertTrue(searchResponse.getProducts().size() > 0, "No products found for the search keyword.");

            // Example: Validate product name contains the search keyword
//            for (Product product : searchResponse.getProducts()) {
//                System.out.println(product.getName());
//                Assert.assertTrue(product.getName().toLowerCase().contains("top"),
//                        "Product name does not contain the search keyword.");
//            }
        }
        else
        {
            fail("Unexpected content type: " + response.getContentType());
        }
    }
}
