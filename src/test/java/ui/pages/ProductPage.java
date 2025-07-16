package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='features_items']")
    private WebElement itemList;

    @FindBy(xpath = "(//a[contains(text(),'View Product')])[1]")
    private WebElement firstViewProductButton;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void checkItemListVisibility()
    {
        List<WebElement> productItems = driver.findElements(By.cssSelector(".features_items"));
        for(WebElement item : productItems)
        {
            assert item.isDisplayed();
        }
    }

}
