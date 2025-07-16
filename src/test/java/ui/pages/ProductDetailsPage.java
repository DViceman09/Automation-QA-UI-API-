package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
    private WebDriver driver;

    @FindBy(xpath = "//h2[normalize-space()='Blue Top']")
    private WebElement productName;

    @FindBy(xpath = "//p[normalize-space()='Category: Women > Tops']")
    private WebElement category;

    @FindBy(xpath = "//p[normalize-space()='Category: Women > Tops']")
    private WebElement price;

    @FindBy(xpath = "//div[@class='product-details']//p[2]")
    private WebElement availability;

    @FindBy(xpath = "//body//section//p[3]")
    private WebElement condition;

    @FindBy(xpath = "//body//section//p[3]")
    private WebElement brand;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkProductNameVisibility()
    {
        assert productName.isDisplayed();
    }

    public void checkCategoryVisibility()
    {
        assert category.isDisplayed();
    }

    public void checkPriceVisibility()
    {
        assert price.isDisplayed();
    }

    public void checkAvailabilityVisibility()
    {
        assert availability.isDisplayed();
    }

    public void checkConditionVisibility()
    {
        assert condition.isDisplayed();
    }

    public void checkBrandVisibility()
    {
        assert brand.isDisplayed();
    }
}
