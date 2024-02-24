package selenium.iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenium.utils.BrowserUtils;
import selenium.utils.DriverHelper;

public class NestedIframes {

    WebDriver driver;
    @BeforeMethod
    public void initialize(){
        driver = DriverHelper.getDriver();
    }

    @Test
    public void testNestedIframes(){
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.findElement(By.linkText("Nested Frames")).click();

        BrowserUtils.switchDriverToIframe(driver,"frame-top");
        BrowserUtils.switchDriverToIframe(driver,"frame-left");
//        driver.switchTo().frame("frame-top");
//        driver.switchTo().frame("frame-left");

        WebElement textFromLeft = driver.findElement(By.xpath("//body[contains(.,'LEFT')]"));
        System.out.println(BrowserUtils.getText(textFromLeft));
        softAssert.assertEquals(BrowserUtils.getText(textFromLeft), "LEFT");

//        driver.switchTo().parentFrame();
//        driver.switchTo().parentFrame();
//        driver.switchTo().defaultContent();
        BrowserUtils.switchDriverToDefaultContent(driver);
        BrowserUtils.switchDriverToIframe(driver, "frame-bottom");
//        driver.switchTo().frame("frame-bottom");
        WebElement textFromBottom = driver.findElement(By.xpath("//body[contains(.,'BOTTOM')]"));
        System.out.println(BrowserUtils.getText(textFromBottom));
        softAssert.assertEquals(BrowserUtils.getText(textFromBottom), "BOTTOM");

        /*
        Task -> within the same test, can you get the text on the right and middle
         */

       // driver.switchTo().defaultContent();
        BrowserUtils.switchDriverToDefaultContent(driver);
        BrowserUtils.switchDriverToIframe(driver,"frame-top");
        BrowserUtils.switchDriverToIframe(driver,"frame-right");
//        driver.switchTo().frame("frame-top");
//        driver.switchTo().frame("frame-right");

        WebElement textFromRight = driver.findElement(By.xpath("//body[contains(.,'RIGHT')]"));
        System.out.println(BrowserUtils.getText(textFromRight));
        softAssert.assertEquals(BrowserUtils.getText(textFromRight), "RIGHT");

//        driver.switchTo().parentFrame();
        BrowserUtils.switchDriverToParentFrame(driver);
        BrowserUtils.switchDriverToIframe(driver,"frame-middle");
        //driver.switchTo().frame("frame-middle");

        WebElement textFromMiddle = driver.findElement(By.xpath("//body[contains(.,'MIDDLE')]"));
        System.out.println(BrowserUtils.getText(textFromMiddle));
        softAssert.assertAll("Finished executing tests: find failures below");

    }

    @Test
    public void practiceNestedFrames(){

        driver.get("https://www.lambdatest.com/selenium-playground/iframe-demo/");
        /*
        1. navigate to webpage
        2. clear the text box before sending keys, and send keys
        3. on the webpage within the same page, scroll down until automation button
        4. Click on that automation button, and get text on the next page which is 'Automation in LambdaTest'
        5. Validate that text
         */

        driver.switchTo().frame("iFrame1");
        WebElement textArea = driver.findElement(By.cssSelector("div[class='rsw-ce']"));
        textArea.clear();
        textArea.sendKeys("Hello World");

        driver.switchTo().defaultContent();
        driver.switchTo().frame("iFrame2");
        WebElement automationButton = driver.findElement(By.cssSelector(".pagination-nav__label"));
        BrowserUtils.scrollToElement(driver, automationButton);
        BrowserUtils.clickWithJS(driver, automationButton);
        WebElement textOnNextPage = driver.findElement(By.xpath("//h1[.='Automation in LambdaTest']"));
        System.out.println(BrowserUtils.getText(textOnNextPage));



    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
