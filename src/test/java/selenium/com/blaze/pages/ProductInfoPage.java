package selenium.com.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import selenium.com.qa_fox.pages.ProductListPage;
import selenium.utils.BrowserUtils;

public class ProductInfoPage {

    public ProductInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h2")
    WebElement header;

    @FindBy(tagName = "h3")
    WebElement price;

    @FindBy(xpath = "//a[.='Add to cart']")
    WebElement addToCartBtn;

    // Will need alert handler

    @FindBy(xpath = "//a[.='Cart']")
    WebElement cart;

    public void validateHeaderPrice() {
        Assert.assertEquals(BrowserUtils.getText(header), "MacBook Pro");
        Assert.assertTrue(price.isDisplayed());
    }

    public void addProductToCart(WebDriver driver) throws InterruptedException {
        addToCartBtn.click();
        Thread.sleep(2000);
        String actualAlertText = BrowserUtils.alertGetText(driver);
        String expectedAlertText = "Product added";
        Assert.assertEquals(actualAlertText, expectedAlertText, "Failed to validate alert text");
        BrowserUtils.acceptAlert(driver);
        cart.click();
    }


}
