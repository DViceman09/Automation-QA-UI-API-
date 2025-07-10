package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement name;

    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement email;

    @FindBy(xpath = "//input[@placeholder='Subject']")
    private WebElement subject;

    @FindBy(xpath = "//textarea[@id='message']")
    private WebElement message;

    @FindBy(xpath = "//input[@name='upload_file']")
    private WebElement chooseFile;

    @FindBy(xpath = "//input[@name='submit']")
    private WebElement submit;

    @FindBy(xpath = "//span[normalize-space()='Home']")
    private WebElement homeButton;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterName(String name1)
    {
        name.clear();
        name.sendKeys(name1);
    }

    public void enterEmail(String emailId)
    {
        email.clear();
        email.sendKeys(emailId);
    }

    public void enterSubject(String subject1)
    {
        subject.clear();
        subject.sendKeys(subject1);
    }

    public void enterMessage(String message1)
    {
        message.clear();
        message.sendKeys(message1);
    }

    public void clickSubmitButton()
    {
        submit.click();
    }

    public void openUploadDialogue()
    {
        chooseFile.click();
    }

    public void uploadFile(String fileName)
    {
        chooseFile.sendKeys(fileName);
    }

    public void clickHomeButton()
    {
        homeButton.click();
    }

}
