package ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import ui.pages.AccountCreated;
import ui.pages.HomePage;
import ui.pages.Login;
import ui.pages.SignUp;
import ui.utility.BrowserUtility;

public class LoginTest {
    private BrowserUtility browser;
    private Login loginPage;
    private SignUp signUp;
    private AccountCreated accountCreated;
    private HomePage homePage;
    private WebDriver driver;

    @Test(priority = 0)
    public void testUserRegistration() throws InterruptedException {
        browser = new BrowserUtility();
        browser.launchBrowser("chrome", false);
        browser.maximizeWindow();
        browser.navigateTo("http://automationexercise.com");
        String browserTitle = browser.getTitle();
        Assert.assertEquals(browserTitle, "Automation Exercise");

        browser.clickElement(By.xpath("//a[normalize-space()='Signup / Login']"));
        browser.waitForElementVisible(By.xpath("//input[@placeholder='Name']"), 3000);

        loginPage = new Login(browser.getDriver());
        loginPage.enterName("FrogMan");
        loginPage.signUpEmailId("dviceman09@gmail.com");
        loginPage.clickSignUp();

        browser.waitForElementVisible(By.id("id_gender1"), 3000);
        String signUpTitle = browser.getTitle();
        Assert.assertEquals(signUpTitle, "Automation Exercise - Signup");

        signUp = new SignUp(browser.getDriver());
        signUp.selectRadioBox("male");
        signUp.enterName("Iceman");
        signUp.enterPassword("Faceless2");
        signUp.enterDate("19");
        signUp.enterMonth("August");
        signUp.enterYear("1989");

        browser.scrollByPixels(0, 400);
        signUp.selectNewsLetter();
        signUp.selectOffers();
        signUp.enterFirstName("Ganesh");
        signUp.enterLastName("Gaikwad");
        signUp.enterCompany("XYZ Private Ltd");

        browser.scrollByPixels(0, 300);
        signUp.enterAddress1("ABC, XYZ, 123, 14/6");
        signUp.enterAddress2("123, 445, 131");
        signUp.enterCountry("India");
        signUp.enterState("Gujarat");
        signUp.enterCity("Ahmedabad");

        browser.scrollByPixels(0, 300);
        signUp.enterZipCode("4125125");
        signUp.enterMobileNumber("+919251168901");

        signUp.createAccount();

        String title = browser.getTitle();
        Assert.assertEquals(title, "Automation Exercise - Account Created");

        accountCreated = new AccountCreated(browser.getDriver());
        accountCreated.tapContinue();

//        homePage = new HomePage(browser.getDriver());
//
////        homePage.deleteAccount();
////
////        browser.waitForElementVisible(By.xpath("//b[normalize-space()='Account Deleted!']"), 3000);
////        driver = browser.getDriver();
////        WebElement text1 = driver.findElement(By.xpath("//b[normalize-space()='Account Deleted!']"));
////        String deletionText = text1.getText();
////        Assert.assertEquals(deletionText, "ACCOUNT DELETED!");
////
////        accountCreated.tapContinue();

        browser.closeBrowser();
    }

    @Test(priority = 1)
    public void checkUserAlreadyExist()
    {
        browser = new BrowserUtility();
        browser.launchBrowser("chrome", false);
        browser.maximizeWindow();
        browser.navigateTo("http://automationexercise.com");

        browser.clickElement(By.xpath("//a[normalize-space()='Signup / Login']"));
        browser.waitForElementVisible(By.xpath("//input[@placeholder='Name']"), 3000);

        loginPage = new Login(browser.getDriver());
        loginPage.enterName("FrogMan");
        loginPage.signUpEmailId("dviceman09@gmail.com");
        loginPage.clickSignUp();

        driver = browser.getDriver();
        WebElement text = driver.findElement(By.xpath("//p[normalize-space()='Email Address already exist!']"));
        String alertText = loginPage.getEmailAlreadyExistText(text);

        Assert.assertEquals(alertText, "Email Address already exist!");

        browser.closeBrowser();
    }

    @Test(priority = 2)
    public void ValidLogin()
    {
        browser = new BrowserUtility();
        browser.launchBrowser("chrome", false);
        browser.maximizeWindow();
        browser.navigateTo("http://automationexercise.com");

        browser.clickElement(By.xpath("//a[normalize-space()='Signup / Login']"));

        loginPage = new Login(browser.getDriver());
        loginPage.loginEmailId("dviceman09@gmail.com");
        loginPage.enterPassword("Faceless2");
        loginPage.clickLogin();

        /*browser.waitForElementVisible(By.xpath("//a[normalize-space()='Delete Account']"), 3000);
        homePage = new HomePage(browser.getDriver());
        homePage.deleteAccount();*/

        browser.closeBrowser();
    }

    @Test(priority = 4)
    public void InvalidLogin()
    {
        browser = new BrowserUtility();
        browser.launchBrowser("chrome", false);
        browser.maximizeWindow();
        browser.navigateTo("http://automationexercise.com");

        browser.clickElement(By.xpath("//a[normalize-space()='Signup / Login']"));

        loginPage = new Login(browser.getDriver());
        loginPage.loginEmailId("dviceman0911@gmail.com");
        loginPage.enterPassword("Faceless2");
        loginPage.clickLogin();
        browser.closeBrowser();
    }

    @Test(priority = 3)
    public void Logout()
    {
        browser = new BrowserUtility();
        browser.launchBrowser("chrome", false);
        browser.maximizeWindow();
        browser.navigateTo("http://automationexercise.com");

        browser.clickElement(By.xpath("//a[normalize-space()='Signup / Login']"));

        loginPage = new Login(browser.getDriver());
        loginPage.loginEmailId("dviceman09@gmail.com");
        loginPage.enterPassword("Faceless2");
        loginPage.clickLogin();

        homePage = new HomePage(browser.getDriver());
        homePage.logoutUser();

        String text1 = browser.getTitle();
        Assert.assertEquals(text1, "Automation Exercise - Signup / Login");

        browser.closeBrowser();

    }

    @AfterTest
    public void deleteUser()
    {
        browser = new BrowserUtility();
        browser.launchBrowser("chrome", false);
        browser.maximizeWindow();
        browser.navigateTo("http://automationexercise.com");

        browser.clickElement(By.xpath("//a[normalize-space()='Signup / Login']"));

        loginPage = new Login(browser.getDriver());
        loginPage.loginEmailId("dviceman09@gmail.com");
        loginPage.enterPassword("Faceless2");
        loginPage.clickLogin();

        homePage = new HomePage(browser.getDriver());
        homePage.deleteAccount();

        browser.closeBrowser();
    }
}

