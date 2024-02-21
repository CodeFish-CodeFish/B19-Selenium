package selenium.pactice_day;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;
import selenium.utils.DriverHelper;

import java.util.List;

public class EnabledDisabledField {

    /*
    Task 1.
    Send keys to disabled input field

    Task 2.
    Find a common xpath for both locators and with if condition(isEnabled) send keys to the enabled input field
     */
    WebDriver driver;
    @BeforeMethod
    public void startUp(){
        driver = DriverHelper.getDriver();
        driver.get("https://formy-project.herokuapp.com/enabled");
    }

    @Test
    public void sendKeysTo(){

        WebElement disabledInput = driver.findElement(By.cssSelector("#disabledInput"));
        disabledInput.sendKeys("test");



    }

    @Test
    public void validateSendKeys(){
        List<WebElement> bothInputFields = driver.findElements(By.xpath("//input[@]"));

//        for (WebElement element : bothInputFields){
//
//            if (element.isEnabled()){
//                element.sendKeys("test");
//            }
//
//        }

        for (int i = 0; i < bothInputFields.size(); i++) {

            WebElement element = bothInputFields.get(i);
            if (element.isEnabled()){
                element.sendKeys("test");
            }

        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException {

        if (!result.isSuccess()){
            BrowserUtils.takeScreenshot(driver);
            Thread.sleep(2000);
            driver.quit();
        }
    }



}
