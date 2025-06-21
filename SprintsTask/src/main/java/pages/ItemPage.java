package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemPage {
    public WebDriver driver;
    WebDriverWait wait;

    public ItemPage(WebDriver driver)
    {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(id = "option-label-size-143-item-168")
    public WebElement itemSizeBtn;
    @FindBy(id = "option-label-color-93-item-58")
    public WebElement itemColorBtn;
    @FindBy(id = "product-addtocart-button")
    public WebElement addToCartBtn;
    @FindBy(xpath = "//a[normalize-space(@class)='action showcart']")
    public WebElement goToCartBtn;
    @FindBy(xpath = "//span[normalize-space(@class)='counter-number']")
    public WebElement counterCartNumber;
    @FindBy(id = "top-cart-btn-checkout")
    public WebElement proccedToCheckoutBtn;

    public void selectItemData(){
        wait.until(ExpectedConditions.elementToBeClickable(itemSizeBtn));
        itemSizeBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(itemColorBtn));
        itemColorBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        addToCartBtn.click();
    }

    public void clickOnCartButton(){
        wait.until(ExpectedConditions.elementToBeClickable(goToCartBtn));
        String counterValue = counterCartNumber.getText();
        wait.until(ExpectedConditions.textToBePresentInElement(counterCartNumber,"1"));
        wait.until(ExpectedConditions.elementToBeClickable(counterCartNumber));
        goToCartBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(proccedToCheckoutBtn));
        proccedToCheckoutBtn.click();
    }
}
