package selenium.alert_interface;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;

import java.time.Duration;

public class AlertInterface {

    WebDriver driver;
    @BeforeMethod
    public void initializeDriver() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("driver has been initialized");
    }

    @Test
    public void handleJSAlert() throws InterruptedException {
        WebElement firstAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        firstAlert.click();
        Thread.sleep(3000);

        // handling alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement successMsg = driver.findElement(By.cssSelector("#result"));
        Assert.assertEquals(BrowserUtils.getText(successMsg), "You successfully clicked an alert");

        WebElement secondAlert = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        secondAlert.click();
        Thread.sleep(2000);
        System.out.println("alert.getText() = " + alert.getText());
        alert.dismiss();

        WebElement thirdAlert = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        thirdAlert.click();
        Thread.sleep(3000);
        alert.sendKeys("test data");
        Thread.sleep(3000);
        alert.accept();


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
