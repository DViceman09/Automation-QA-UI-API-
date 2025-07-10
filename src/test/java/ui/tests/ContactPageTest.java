package ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.ContactPage;
import ui.pages.HomePage;
import ui.utility.BrowserUtility;

public class ContactPageTest {
    private BrowserUtility browser;
    private ContactPage contactPage;
    private HomePage homePage;
    private WebDriver driver;

    @Test(priority = 0)
    public void checkContactPage()
    {
        browser = new BrowserUtility();
        browser.launchBrowser("chrome", false);
        browser.maximizeWindow();
        browser.navigateTo("http://automationexercise.com");
        String browserTitle = browser.getTitle();
        Assert.assertEquals(browserTitle, "Automation Exercise");
        homePage = new HomePage(browser.getDriver());
        homePage.contactUs();

        driver = browser.getDriver();
        WebElement contactUsText = driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]"));
        String contactText = contactUsText.getText();
        Assert.assertEquals(contactText, "CONTACT US");

        contactPage = new ContactPage(browser.getDriver());
        contactPage.enterName("FrogManIceman");
        contactPage.enterEmail("dviceman09@gmail.com");
        contactPage.enterSubject("This is just a Test Subject");
        contactPage.enterMessage("This is a Test message, trying to learn Automation from Automation Exercise website");
//        contactPage.uploadFile("SandeshKadam_SDET");
        contactPage.clickSubmitButton();

        browser.acceptAlert(driver);

        WebElement successText = driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        String succText = successText.getText();
        Assert.assertEquals(succText, "Success! Your details have been submitted successfully.");

        contactPage.clickHomeButton();


    }
}
