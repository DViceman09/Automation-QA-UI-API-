package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp {
    private WebDriver driver;

    @FindBy(id = "id_gender1")
    private WebElement radioButtonMale;

    @FindBy(id = "id_gender2")
    private WebElement radioButtonFemale;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "days")
    private WebElement day;

    @FindBy(id = "months")
    private WebElement month;

    @FindBy(id = "years")
    private WebElement year;

    @FindBy(id = "newsletter")
    private WebElement newsLetterSignUpCheckBox;

    @FindBy(id = "optin")
    private WebElement receiveOffers;

    @FindBy(id = "first_name")
    private WebElement firstName;

    @FindBy(id = "last_name")
    private WebElement lastName;

    @FindBy(id = "company")
    private WebElement company;

    @FindBy(id = "address1")
    private WebElement address1;

    @FindBy(id = "address2")
    private WebElement address2;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "state")
    private WebElement state;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "zipcode")
    private WebElement zipCode;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumber;

    @FindBy(xpath = "//button[normalize-space()='Create Account']")
    private WebElement createAccountButton;

    public SignUp(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectRadioBox(String gender)
    {
        if(gender.equals("male"))
        {
            radioButtonMale.click();
        }
        else if(gender.equals("female"))
        {
            radioButtonFemale.click();
        }
    }

    public void enterName(String username)
    {
        name.sendKeys(username);
    }

    public void enterPassword(String setpassword)
    {
        password.sendKeys(setpassword);
    }

    public void enterMonth(String setmonth)
    {
        month.sendKeys(setmonth);
    }

    public void enterDate(String setdate)
    {
        day.sendKeys(setdate);
    }

    public void enterYear(String setYear)
    {
        year.sendKeys(setYear);
    }

    public void selectNewsLetter()
    {
        newsLetterSignUpCheckBox.click();
    }

    public void selectOffers()
    {
        receiveOffers.click();
    }

    public void enterFirstName(String firstname)
    {
        firstName.sendKeys(firstname);
    }

    public void enterLastName(String lastname)
    {
        lastName.sendKeys(lastname);
    }

    public void enterCompany(String companyName)
    {
        company.sendKeys(companyName);
    }

    public void enterAddress1(String mainAddress)
    {
        address1.sendKeys(mainAddress);
    }

    public void enterAddress2(String secondaryAddress)
    {
        address2.sendKeys(secondaryAddress);
    }

    public void enterCountry(String country1)
    {
        country.sendKeys(country1);
    }

    public void enterState(String state1)
    {
        state.sendKeys(state1);
    }

    public void enterCity(String city1)
    {
        city.sendKeys(city1);
    }

    public void enterZipCode(String zipcode1)
    {
        zipCode.sendKeys(zipcode1);
    }

    public void enterMobileNumber(String mobile)
    {
        mobileNumber.sendKeys(mobile);
    }

    public void createAccount()
    {
        createAccountButton.click();
    }
}
