package ui.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.HomePage;
import ui.utility.BrowserUtility;

@Test
public class TestCasePageTest {
    private BrowserUtility browser;
    private HomePage homePage;

    public void testNavigationToTestcasePage()
    {
        browser = new BrowserUtility();
        browser.launchBrowser("chrome", false);
        browser.maximizeWindow();
        browser.navigateTo("http://automationexercise.com");
        String browserTitle = browser.getTitle();
        Assert.assertEquals(browserTitle, "Automation Exercise");

        browser.clickElement(By.xpath("//a[contains(text(),'Test Cases')]"));

        String testcasePageTitle = browser.getTitle();
        Assert.assertEquals(testcasePageTitle, "Automation Practice Website for UI Testing - Test Cases");
    }
}
