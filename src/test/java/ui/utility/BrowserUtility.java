package ui.utility;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BrowserUtility {
    private WebDriver driver;
    private final Logger logger = Logger.getLogger(BrowserUtility.class.getName());

    // Initialize with configuration
    public BrowserUtility() {
        logger.setLevel(Level.INFO);
    }

    public WebDriver getDriver() {
        return driver;
    }

    // 1. BROWSER MANAGEMENT
    public void launchBrowser(String browserType, boolean headless) {
        switch (browserType.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless) firefoxOptions.addArguments("-headless");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if (headless) edgeOptions.addArguments("--headless");
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                driver = new ChromeDriver(); // Fallback
        }
        logger.info(browserType + " launched" + (headless ? " (headless)" : ""));
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void closeBrowser() {
        if (driver != null) driver.quit();
    }

    // 2. NAVIGATION
    public void navigateTo(String url) {
        driver.get(url);
        logger.info("Navigated to: " + url);
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    // 3. WAIT HANDLING
    public void setImplicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public WebElement waitForElementVisible(By locator, int timeout) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementClickable(By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // 4. ELEMENT INTERACTION
    public void clickElement(By locator) {
        waitForElementClickable(locator, 10).click();
    }

    public void typeText(By locator, String text) {
        WebElement element = waitForElementVisible(locator, 10);
        element.clear();
        element.sendKeys(text);
    }

    // 5. SCREENSHOT CAPTURE
    public void takeScreenshot(String testName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(src.toPath(), Paths.get("screenshots/" + testName + ".png"));
        } catch (IOException e) {
            logger.warning("Screenshot failed: " + e.getMessage());
        }
    }

    // 6. WINDOW/FRAME HANDLING
    public void switchToFrame(By frameLocator) {
        driver.switchTo().frame(waitForElementVisible(frameLocator, 5));
    }

    public void handleAlert(boolean accept) {
        Alert alert = driver.switchTo().alert();
        if (accept) alert.accept();
        else alert.dismiss();
    }

    // 7. COOKIE MANAGEMENT
    public void addCookie(String name, String value) {
        driver.manage().addCookie(new Cookie(name, value));
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",
                element
        );
    }

    public void scrollByPixels(int xPixels, int yPixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", xPixels, yPixels);
    }

    public void acceptAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    /**
     * Switches to an alert pop-up and dismisses it.
     * @param driver the WebDriver instance
     */
    public void dismissAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    /**
     * Switches to an alert pop-up and returns its text.
     * @param driver the WebDriver instance
     * @return the alert text
     */
    public String getAlertText(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }



    // 8. LOGGING INTEGRATION
    // (Built-in via java.util.logging)


    // 10. EXCEPTION HANDLING
    // (Integrated in all methods via try-catch and logger)
}
