package selenium.com.blaze.tests;

import org.testng.annotations.Test;
import selenium.com.blaze.pages.BlazeMain;
import selenium.com.blaze.pages.CartPage;
import selenium.com.blaze.pages.LaptopPage;
import selenium.com.blaze.pages.ProductInfoPage;

public class BlazeScript extends BlazeBase{



    @Test(dataProvider = "mockData", dataProviderClass = BlazeTestData.class)
    public void validatePurchaseExperience(String name, String country, String city,
                                           String cardNumber, String month, String year, String thanksMessage) throws InterruptedException {

        BlazeMain main = new BlazeMain(driver);
        main.clickOnLaptops();

        LaptopPage laptopPage = new LaptopPage(driver);
        laptopPage.clickOnMacBookPro(driver);

        ProductInfoPage infoPage = new ProductInfoPage(driver);
        infoPage.validateHeaderPrice();
        infoPage.addProductToCart(driver);

        CartPage cartPage = new CartPage(driver);
        cartPage.validateProductTableClickPlaceOrder();
        cartPage.fillInCustomerInfo(name, country, city, cardNumber, month, year, thanksMessage);

    }

}
