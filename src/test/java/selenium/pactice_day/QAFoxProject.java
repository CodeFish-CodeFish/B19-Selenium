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

        WebElement checkoutBtn = driver.findElement(By.xpath("//a[contains(text(),'Checkout')]"));
        checkoutBtn.click();

        WebElement radioBtnGuest = driver.findElement(By.cssSelector("input[value='guest']"));

        if (!radioBtnGuest.isSelected()){
            radioBtnGuest.click();
        }

        WebElement continueBtn = driver.findElement(By.cssSelector("input[id='button-account']"));
        continueBtn.click();

        WebElement firstName = driver.findElement(By.cssSelector("#input-payment-firstname"));
        firstName.sendKeys("Kuba");

        WebElement lastName = driver.findElement(By.cssSelector("#input-payment-lastname"));
        lastName.sendKeys("Abdy");
        WebElement email = driver.findElement(By.cssSelector("#input-payment-email"));
        email.sendKeys("test@test.com");
        WebElement telephone = driver.findElement(By.cssSelector("#input-payment-telephone")); // css
        telephone.sendKeys("42343214324");
        WebElement address1 = driver.findElement(By.id("input-payment-address-1")); // this is not css
        address1.sendKeys("test st");
        WebElement city = driver.findElement(By.id("input-payment-city"));
        city.sendKeys("Chitown");
        WebElement zipCode = driver.findElement(By.id("input-payment-postcode"));
        zipCode.sendKeys("60656");
        WebElement countryDropDown = driver.findElement(By.id("input-payment-country"));
        BrowserUtils.selectBy(countryDropDown, "223","value");

        WebElement state = driver.findElement(By.cssSelector("#input-payment-zone"));
        BrowserUtils.selectBy(state, "3635", "value");
        WebElement continueBtn2 = driver.findElement(By.cssSelector("#button-guest"));
        continueBtn2.click();





    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
