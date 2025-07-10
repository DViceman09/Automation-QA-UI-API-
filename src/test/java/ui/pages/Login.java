package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    private WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement name;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement emailId;

    @FindBy(xpath = "//button[normalize-space()='Signup']")
    private WebElement signUpButton;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement loginEmailId;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement password;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[normalize-space()='Email Address already exist!']")
    private WebElement emailAlreadyExistText;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterName(String userName)
    {
        name.clear();
        name.sendKeys(userName);
    }

    public void enterPassword(String userPassword)
    {
        password.clear();
        password.sendKeys(userPassword);
    }

    public void signUpEmailId(String signUpEmailId)
    {
        emailId.clear();
        emailId.sendKeys(signUpEmailId);
    }

    public void loginEmailId(String loginEmail)
    {
        loginEmailId.clear();
        loginEmailId.sendKeys(loginEmail);
    }

    public void clickSignUp()
    {
        signUpButton.click();
    }

    public void clickLogin()
    {
        loginButton.click();
    }

    public String getEmailAlreadyExistText(WebElement locator)
    {
        return locator.getText();
    }
}
