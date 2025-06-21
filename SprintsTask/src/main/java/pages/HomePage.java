package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.time.Duration;

public class HomePage {
    public WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(id = "search")
    public WebElement searchInputField;
    @FindBy(xpath = "//button[normalize-space(@class)='action search']")
    public WebElement searchBtn;
    @FindBy(xpath = "//a[contains(text(), 'Ajax')]/parent::strong[normalize-space(@class)='product name product-item-name']")
    public WebElement searchedItem;
    @FindBy(xpath = "//span[contains(text(),'$69.00')]  ")
    public String assertionValue;

    public void searchForItem(String searchWord){
        wait.until(ExpectedConditions.elementToBeClickable(searchInputField));
        searchInputField.sendKeys(searchWord);
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
        searchBtn.click();
    }
    public void selectSearchedItem(){
        wait.until(ExpectedConditions.elementToBeClickable(searchedItem));
        searchedItem.click();
    }
}
