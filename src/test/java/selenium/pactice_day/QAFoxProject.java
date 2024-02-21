package selenium.pactice_day;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;
import selenium.utils.DriverHelper;

public class QAFoxProject {

    /*
    1. Navigate to webpage
    2. Click on Show All Desktop (Hover over)
    3. Scroll down to Sony Vaio and click Add to cart
    4. Click shopping Cart
    5. Click Checkout button
    6. Check radio button with if condition for guest checkout and click continue
    7. Fill in test personal information
    8. Select US and US state from the dropdown and click continue button


     */

    WebDriver driver;
    @BeforeMethod
    public void initializeDriver(){
        driver = DriverHelper.getDriver();
        driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
    }

    @Test
    public void validatePurchase() throws InterruptedException {

        WebElement desktop = driver.findElement(By.xpath("//a[.='Desktops']"));
        BrowserUtils.moveTo(driver, desktop);
        Thread.sleep(2000);
        WebElement showAllDesktop = driver.findElement(By.xpath("//a[.='Show AllDesktops']"));
        showAllDesktop.click();

        WebElement addToCart = driver.findElement(By.xpath("//h4//a[.='Sony VAIO']//..//..//following-sibling::div//span[.='Add to Cart']"));
        BrowserUtils.scrollToElement(driver, addToCart);
        addToCart.click();
        Thread.sleep(3000);
        WebElement shoppingCartLink = driver.findElement(By.xpath("//a[.='shopping cart']"));
        shoppingCartLink.click();



    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
