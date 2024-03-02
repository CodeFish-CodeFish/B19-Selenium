package selenium.com.luma.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.BrowserUtils;

public class LumaProductList {

    public LumaProductList(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(.,'Driven Backpack')]")
    WebElement drivenBag;

    @FindBy(xpath = "//a[contains(.,'Driven Backpack')]//..//following-sibling::div//form//following-sibling::button")
    WebElement addToCartBtn;

    @FindBy(xpath = "//a[.='shopping cart']")
    WebElement cartLink;

    @FindBy(xpath = "//span[.='Proceed to Checkout']")
    WebElement proceedToCheckOut;

    public void addCartCheckout(WebDriver driver) throws InterruptedException {
        BrowserUtils.moveTo(driver, drivenBag);
        Thread.sleep(1000);
        addToCartBtn.click();
        Thread.sleep(1000);
        cartLink.click();
        proceedToCheckOut.click();
    }




}
