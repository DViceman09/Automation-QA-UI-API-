package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreated {
    private WebDriver driver;

    @FindBy(xpath = "//b[normalize-space()='Account Created!']")
    public WebElement accountCreatedText;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    public WebElement continueButton;

    public AccountCreated(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void tapContinue()
    {
        continueButton.click();
    }
}
