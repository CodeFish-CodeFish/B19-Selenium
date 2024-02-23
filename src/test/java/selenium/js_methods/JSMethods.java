package selenium.js_methods;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;
import selenium.utils.DriverHelper;

import java.util.Set;

public class JSMethods {

    WebDriver driver;

    @BeforeMethod
    public void initialize() {
        driver = DriverHelper.getDriver();
    }

    @Test
    public void getTitleWithJS() {

        driver.get("https://www.amazon.com/"); // vs navigate().to("website url");
        // Casting our driver into JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String title = js.executeScript("return document.title").toString();
        System.out.println(title + " <-- title from amazon using JS Method");

    }

    @Test
    public void clickWithJS() {
        //click with javascript method
        driver.get("https://codefish.io/");
        WebElement aboutUs = driver.findElement(By.xpath("//button[.='About us']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", aboutUs);
    }

    @Test
    public void scrollIntoView(){

        // scrolling with js method
        driver.get("https://codefish.io/");
        WebElement facebookLink = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/codefish.camp']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", facebookLink);
    }

    @Test
    public void scrollWithPointJS(){

        // scrolling with js and Point class from selenium
        driver.get("https://the-internet.herokuapp.com/");
        WebElement footerLink = driver.findElement(By.linkText("Elemental Selenium"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Point point = footerLink.getLocation(); // gets location and stores in point
        int x = point.getX();  // gets horizontal distance from the edge of the screen to webElement
        int y = point.getY();  // gets vertical distance from the edge of the screen to webElement
        js.executeScript("window.scrollTo(" + x + "," + y + ")");

    }


    @Test
    public void testJSMethods() throws InterruptedException {
        driver.get("https://www.yale.edu/");
        WebElement contactUs = driver.findElement(By.partialLinkText("Contact"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", contactUs);
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()", contactUs);
        Thread.sleep(1000);
        String actualTitleContactUs = js.executeScript("return document.title").toString();
        System.out.println(actualTitleContactUs);
        String expectedTitleContactUS = "Contact Us | Yale University";
        Assert.assertEquals(actualTitleContactUs, expectedTitleContactUS, "Failed to validate title");

        WebElement webEditorLink = driver.findElement(By.xpath("//a[.='Contact Web Editor']"));
        Point point = webEditorLink.getLocation();
        int xCoordinate = point.getX();
        int yCoordinate = point.getY();

        js.executeScript("window.scrollTo(" + xCoordinate + "," + yCoordinate + ")");
        js.executeScript("arguments[0].click()", webEditorLink);
        Thread.sleep(2000);
        String titleWebEditor = js.executeScript("return document.title").toString();
        System.out.println(titleWebEditor);


    }

    @Test
    public void jsReusableMethods() throws InterruptedException {

        // below code is using re-usable methods from BrowserUtils
        driver.get("https://www.yale.edu/");
        WebElement contactUs = driver.findElement(By.partialLinkText("Contact"));
        BrowserUtils.scrollIntoViewJS(driver, contactUs);
        Thread.sleep(2000);
        BrowserUtils.clickWithJS(driver, contactUs);
        Thread.sleep(1000);
        String actualTitleContactUs = BrowserUtils.getTitleWithJS(driver);
        System.out.println(actualTitleContactUs);
        String expectedTitleContactUS = "Contact Us | Yale University";
        Assert.assertEquals(actualTitleContactUs, expectedTitleContactUS, "Failed to validate title");
        WebElement webEditorLink = driver.findElement(By.xpath("//a[.='Contact Web Editor']"));
        BrowserUtils.scrollWithPointJS(driver, webEditorLink);
        BrowserUtils.clickWithJS(driver, webEditorLink);
        Thread.sleep(2000);
        String titleWebEditor = BrowserUtils.getTitleWithJS(driver);
        System.out.println(titleWebEditor);


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit(); // vs driver.close();
    }

}
