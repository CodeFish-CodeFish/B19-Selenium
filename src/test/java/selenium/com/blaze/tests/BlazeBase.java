package selenium.com.blaze.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import selenium.utils.DriverHelper;

public class BlazeBase {

    WebDriver driver;

    @BeforeMethod
    public void initializeDriver(){
        driver = DriverHelper.getDriver();
        driver.get("https://www.demoblaze.com/");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
