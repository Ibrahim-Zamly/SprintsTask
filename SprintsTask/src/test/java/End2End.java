import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ItemPage;

import java.io.Console;

public class End2End extends BaseTest{

@Test (priority =1)
    public void productSearch(){
    HomePage homePageObject = new HomePage(chromeDriver);
    homePageObject.searchForItem("Ajax Full-Zip Sweatshirt");
    homePageObject.selectSearchedItem();
}
@Test(dependsOnMethods = "productSearch")
public void addingItemsToCart(){
    ItemPage itemPageObject = new ItemPage(chromeDriver);
    itemPageObject.selectItemData();
    itemPageObject.clickOnCartButton();
}
@Test(dependsOnMethods ="addingItemsToCart" )
public void completingPurchase(){
    CheckoutPage checkoutPageObject = new CheckoutPage(chromeDriver);
    checkoutPageObject.shoppingAddress("ibrahim@gmail.com","ibrahim","zamly","Testing Company","LA, California ","LA","12345-6789","01009031479");
    checkoutPageObject.clickOnNextButton();
    checkoutPageObject.clickOnPlaceOrderButton();
}
}
