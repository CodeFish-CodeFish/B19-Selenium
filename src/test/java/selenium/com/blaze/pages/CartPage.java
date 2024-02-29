package selenium.com.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import selenium.utils.BrowserUtils;

import java.util.List;

public class CartPage {

    public CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tr//td")
    List<WebElement> productInfo;

    @FindBy(xpath = "//button[.='Place Order']")
    WebElement placeOrder;


    @FindBy(css = "#name")
    WebElement name;

    @FindBy(css = "#country")
    WebElement country;

    @FindBy(css = "#city")
    WebElement city;

    @FindBy(css = "#card")
    WebElement cardNumber;

    @FindBy(css = "#month")
    WebElement month;

    @FindBy(css = "#year")
    WebElement year;

    @FindBy(xpath = "//button[.='Purchase']")
    WebElement purchaseBtn;

    @FindBy(xpath = "//h2[.='Thank you for your purchase!']")
    WebElement thankYouMsg;

    @FindBy(xpath = "//button[.='OK']")
    WebElement okBtn;

    public void validateProductTableClickPlaceOrder(){
        for (int i = 1; i < productInfo.size(); i++) {

            Assert.assertTrue(productInfo.get(i).isDisplayed());

        }

        placeOrder.click();
    }

    public void fillInCustomerInfo(String name, String country, String city,
                                   String cardNumber, String month, String year, String thxMessage) throws InterruptedException {

        this.name.sendKeys(name);
        this.country.sendKeys(country);
        this.city.sendKeys(city);
        this.cardNumber.sendKeys(cardNumber);
        this.month.sendKeys(month);
        this.year.sendKeys(year);
        Thread.sleep(2000);
        purchaseBtn.click();
        Assert.assertEquals(BrowserUtils.getText(thankYouMsg), thxMessage);
        okBtn.click();

    }






}
