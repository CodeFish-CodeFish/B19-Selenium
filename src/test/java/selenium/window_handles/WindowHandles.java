package selenium.window_handles;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;
import selenium.utils.DriverHelper;

import java.util.Set;

public class WindowHandles {

    WebDriver driver;

    @BeforeMethod
    public void initialize() {
        driver = DriverHelper.getDriver();
    }

    @Test
    public void testWindowSwitch() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement element = driver.findElement(By.linkText("Click Here"));
        BrowserUtils.clickWithJS(driver, element);

        String mainPageId = driver.getWindowHandle();
        Set<String> allWindowIds = driver.getWindowHandles();

        for (String id : allWindowIds) {

            if (!id.equals(mainPageId)) {
                driver.switchTo().window(id);
                break;
            }

        }
        Thread.sleep(1000);
        WebElement newWindowText = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(newWindowText));


    }

    @Test
    public void windowSwitchPractice() throws InterruptedException {

        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement newTab = driver.findElement(By.id("newTabBtn"));
        BrowserUtils.scrollWithPointJS(driver, newTab);
        BrowserUtils.clickWithJS(driver, newTab);

//        String mainPageId = driver.getWindowHandle();
//        Set<String> allIds = driver.getWindowHandles();
//        for (String id : allIds) {
//
//            if (!id.equals(mainPageId)) {
//                driver.switchTo().window(id);
//                break;
//            }
//
//        }
        BrowserUtils.switchWindows(driver);
        Thread.sleep(2000);
        WebElement nextPageClickMe = driver.findElement(By.cssSelector("#alertBox"));
        BrowserUtils.scrollIntoViewJS(driver, nextPageClickMe);
        BrowserUtils.clickWithJS(driver, nextPageClickMe);
        Thread.sleep(3000);
        BrowserUtils.acceptAlert(driver);


    }

    @Test
    public void validateMultipleWindows() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");
        // LambdaTest | San Francisco CA | Facebook
        WebElement twitter = driver.findElement(By.xpath("//a[contains(.,'Follow On Twitter')]"));
        twitter.click();
        Thread.sleep(200);

        WebElement faceBook = driver.findElement(By.xpath("//a[contains(.,'Like us On Facebook')]"));
        faceBook.click();
        Thread.sleep(200);

        WebElement linkedIn = driver.findElement(By.xpath("//a[contains(.,'Follow us On Linkedin')]"));
        linkedIn.click();
        Thread.sleep(200);

        //String mainPageId = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        //String title = driver.getTitle();
        String expectedTitle = "LambdaTest | San Francisco CA | Facebook";

//        for (String id : windowHandles) {
//            Thread.sleep(300);
//            driver.switchTo().window(id);
//            if (driver.getTitle().contains(expectedTitle)) {
//                break;
//            }
//        }
        BrowserUtils.switchWindowsWithTitle(driver, expectedTitle);
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
    }

    @Test
    public void taskWindows() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.ebay.com/')");
        js.executeScript("window.open('https://www.bestbuy.com/')");
        js.executeScript("window.open('https://www.abt.com/')");

        /*
        Task is switch your driver to bestbuy and get its title

        NOTE: if we have more than 2 windows, you will have to switch your driver based on title
         */

        String bestBuyTitle = "Best Buy | Official Online Store | Shop Now & Save";
//        Set<String> windowHandles = driver.getWindowHandles();
//        for (String title : windowHandles){
//            Thread.sleep(200);
//            driver.switchTo().window(title);
//            if (driver.getTitle().contains(bestBuyTitle)){
//                System.out.println(driver.getTitle().trim());
//                break;
//            }
//        }
        BrowserUtils.switchWindowsWithTitle(driver, bestBuyTitle);


    }

    @Test
    public void taskWindows2() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.uchicago.edu/en')");
        js.executeScript("window.open('https://www.uic.edu/')");
        js.executeScript("window.open('https://www.iit.edu/')");
        /*
        navigate to these webpages, switch your driver to UIC, scroll down the page, and get UIC address (print out in the console)
         */

        String uicTitle = "University of Illinois Chicago";
        Set<String> windowHandles = driver.getWindowHandles();
        for(String id : windowHandles){
            driver.switchTo().window(id);

            if (driver.getTitle().contains(uicTitle)){
                break;
            }
        }

        WebElement addressOfUIC = driver.findElement(By.xpath("//div[@class='footer-address']"));
        BrowserUtils.scrollToElement(driver, addressOfUIC);
        Thread.sleep(200);
        System.out.println(BrowserUtils.getText(addressOfUIC));
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        //driver.close();
    }
}
