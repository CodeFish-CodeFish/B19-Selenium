package selenium.com.luma.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import selenium.utils.DriverHelper;

public class LumaBase {

    WebDriver driver;

    @BeforeMethod
    public void startUp() {
       driver = DriverHelper.getDriver();
       driver.get("https://magento.softwaretestingboard.com/");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
