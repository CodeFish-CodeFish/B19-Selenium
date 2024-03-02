package selenium.com.luma.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import selenium.com.luma.pages.LumaCheckOut;
import selenium.com.luma.pages.LumaMain;
import selenium.com.luma.pages.LumaProductList;
import selenium.utils.BrowserUtils;

import javax.xml.transform.sax.SAXResult;

public class LumaScript extends LumaBase {

    @Parameters({"email", "firstName", "lastName", "address",
            "city", "zipCode", "telephone"})

    @Test
    public void validatePurchase(String email, String firstName, String lastName,
                                 String address, String city, String zipCode,
                                 String telephone) throws InterruptedException {
        LumaMain lumaMain = new LumaMain(driver);
        Thread.sleep(3000);
        BrowserUtils.moveTo(driver, lumaMain.hoverOverGear());

        lumaMain.clickOnBags().click();

        LumaProductList lumaProductList = new LumaProductList(driver);
        lumaProductList.addCartCheckout(driver);

        LumaCheckOut checkOut = new LumaCheckOut(driver);
        checkOut.fillOutCustomerInfo(email, firstName, lastName,
                address, city, zipCode, telephone);

        checkOut.lastSection();


    }

}
