import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public static WebDriver chromeDriver;
    public static WebDriverWait wait;

    @BeforeClass
    public static void configureDriver(){
        chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to("https://magento.softwaretestingboard.com/men/tops-men/hoodies-and-sweatshirts-men.html");
        chromeDriver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        chromeDriver.quit();
    }
}
