package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//b[normalize-space()='FrogManIceman']")
    private WebElement username;

    @FindBy(xpath = "//a[normalize-space()='Delete Account']")
    private WebElement deleteAccountButton;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//a[normalize-space()='Contact us']")
    private WebElement contactUs;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    public String getuserName(WebElement locator)
//    {
//        return locator.getText();
//    }

    public void deleteAccount()
    {
        deleteAccountButton.click();
    }

    public void logoutUser()
    {
        logoutButton.click();
    }

    public void contactUs()
    {
        contactUs.click();
    }
}
