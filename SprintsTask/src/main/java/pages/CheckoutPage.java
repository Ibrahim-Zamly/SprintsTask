package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    public WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver)
    {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(xpath = "(//input[contains(@id, 'customer-email')])[1]")
    public WebElement emailInputField;
    @FindBy(xpath = "//input[contains(@name, 'firstname')]")
    public WebElement firstNameInputField;
    @FindBy(xpath = "//input[contains(@name, 'lastname')]")
    public WebElement lastNameInputField;
    @FindBy(xpath = "//input[contains(@name, 'company')]")
    public WebElement companyInputField;
    @FindBy(xpath = "//input[contains(@name, 'street[0]')]")
    public WebElement streetInputField;
    @FindBy(xpath = "//input[contains(@name, 'city')]")
    public WebElement cityInputField;
    @FindBy(xpath = "//select[contains(@name, 'region_id')]")
    public WebElement stateDropList;
    @FindBy(xpath = "//input[contains(@name, 'postcode')]")
    public WebElement zipCodeInputField;
    @FindBy(xpath = "//select[contains(@name, 'country_id')]")
    public WebElement countryDropList;
    @FindBy(xpath = "//input[contains(@name, 'telephone')]")
    public WebElement phoneNumberInputField;
    @FindBy(xpath = "//input[contains(@name, 'ko_unique_3')]")
    public WebElement shippingMethodRadioButton;
    @FindBy(xpath = "//button[normalize-space(@class)='button action continue primary']")
    public WebElement nextBtn;
    @FindBy(xpath = "//span[contains(text(),'Place Order')]/parent::button[normalize-space(@class)='action primary checkout']")
    public WebElement placeOrderBtn;
    @FindBy(xpath = "//*[contains(@class, 'ajax-loading')]")
    public WebElement loaderLocator;

    public void shoppingAddress(String Email,String firstName,String lastName,String Company,String Street,String City,String zipCode,String phoneNumber){
        wait.until(ExpectedConditions.elementToBeClickable(emailInputField));
        emailInputField.sendKeys(Email);
        firstNameInputField.sendKeys(firstName);
        lastNameInputField.sendKeys(lastName);
        companyInputField.sendKeys(Company);
        streetInputField.sendKeys(Street);
        cityInputField.sendKeys(City);
        Select selectState = new Select(stateDropList);
        selectState.selectByVisibleText("California");
        zipCodeInputField.sendKeys(zipCode);
        Select selectCountry = new Select(countryDropList);
        selectCountry.selectByVisibleText("United States");
        phoneNumberInputField.sendKeys(phoneNumber);
        wait.until(ExpectedConditions.elementToBeClickable(shippingMethodRadioButton));
        shippingMethodRadioButton.click();
    }
    public void clickOnNextButton(){
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        nextBtn.click();
    }
    public void clickOnPlaceOrderButton()  {
        wait.until(ExpectedConditions.invisibilityOf(loaderLocator));
        placeOrderBtn.click();
    }
}
