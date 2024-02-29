package selenium.com.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlazeMain {

    /*
    1. Navigate to https://www.demoblaze.com/
    2. Click on laptops from left hand side
    3. Click on MacBook pro
    4. On product page, validate product name, price and click on Add to cart btn
    5. Once added to cart, get text from alert, and accept that alert
    6. Click on Cart tab on top of the page
    7. On Cart page validate product name, price, and delete button and click place order
    8. Fill in customer information and click Purchase
    9. Validate Thank you message and click ok button
    10. Quit your driver


    Follow POM, and apply DataProvider for your test data (customer info).


     */

    public BlazeMain(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[.='Laptops']")
    WebElement laptopsLink;

    public void clickOnLaptops(){
        laptopsLink.click();
    }
}
