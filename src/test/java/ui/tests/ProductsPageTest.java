package ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.ProductDetailsPage;
import ui.pages.ProductPage;
import ui.utility.BrowserUtility;

public class ProductsPageTest {
    private BrowserUtility browser;
    private ProductPage productPage;
    private ProductDetailsPage productDetails;
    private WebDriver driver;

    @Test
    public void testProductPageVisibility()
    {
        browser = new BrowserUtility();
        browser.launchBrowser("chrome", false);
        browser.maximizeWindow();
        browser.navigateTo("http://automationexercise.com");
        String browserTitle = browser.getTitle();
        Assert.assertEquals(browserTitle, "Automation Exercise");

        browser.clickElement(By.xpath("//a[@href='/products']"));

        String productPageTitle = browser.getTitle();

        Assert.assertEquals("Automation Exercise - All Products", productPageTitle);

        productPage = new ProductPage(browser.getDriver());

        productPage.checkItemListVisibility();

        browser.scrollByPixels(0, 600);

        driver = browser.getDriver();

        WebElement buttonclick = driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[1]"));

        buttonclick.click();

        String productDetailPage = browser.getTitle();
        Assert.assertEquals("Automation Exercise - Product Details", productDetailPage);

        productDetails = new ProductDetailsPage(browser.getDriver());

        productDetails.checkProductNameVisibility();
        productDetails.checkPriceVisibility();
        productDetails.checkCategoryVisibility();
        productDetails.checkBrandVisibility();
        productDetails.checkConditionVisibility();
        productDetails.checkAvailabilityVisibility();

        browser.closeBrowser();

    }

}
