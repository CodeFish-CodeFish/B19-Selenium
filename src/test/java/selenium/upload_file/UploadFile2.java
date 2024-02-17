package selenium.upload_file;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;
import selenium.utils.ConfigReader;
import selenium.utils.DriverHelper;

import java.time.Duration;

public class UploadFile2 {

    WebDriver driver = DriverHelper.getDriver();

    @BeforeMethod
    public void initializeDriver() {
        driver.get(ConfigReader.readProperty("techURL"));
    }

    @Test
    public void uploadFile2() throws InterruptedException {

        WebElement firstName = driver.findElement(By.cssSelector("input[name='firstname']"));
        firstName.sendKeys("Kuba");

        WebElement lastName = driver.findElement(By.cssSelector("input[name='lastname']"));
        lastName.sendKeys("John");
        Thread.sleep(3000);
        WebElement gender = driver.findElement(By.cssSelector("input[value='Male']"));
        gender.click();

        WebElement yearsOfExperience = driver.findElement(By.cssSelector("input[value='7']"));
        yearsOfExperience.click();

        Thread.sleep(3000);
        WebElement datePicker = driver.findElement(By.xpath(" //input[@id='datepicker']"));
        datePicker.sendKeys("12/12/2023");

        WebElement automation = driver.findElement(By.cssSelector("#profession-1"));
        automation.click();

        WebElement continents = driver.findElement(By.cssSelector("#continents"));
        BrowserUtils.selectBy(continents, "North America", "visibleText");
        Thread.sleep(3000);
        WebElement seleniumCommands = driver.findElement(By.cssSelector("#selenium_commands"));
        BrowserUtils.selectBy(seleniumCommands, "WebElement Commands", "visibleText");

        WebElement uploadBtn = driver.findElement(By.cssSelector("#photo"));
        uploadBtn.sendKeys("/Users/codefish/Desktop/B19 HTML/TomAndJerry.jpeg");

        //input[id='datepicker']


    }

    @Test
    public void validateTitleHeaders() {
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.techlistic.com/p/selenium-practice-form.html";
        Assert.assertEquals(actualURL, expectedURL);

        WebElement header1 = driver.findElement(By.xpath("//h3[.='Demo Automation Practice Form']"));
        WebElement header2 = driver.findElement(By.xpath("//h2[.='AUTOMATION PRACTICE FORM']"));

        Assert.assertEquals(BrowserUtils.getText(header1), "Demo Automation Practice Form");
        Assert.assertEquals(BrowserUtils.getText(header2), "AUTOMATION PRACTICE FORM");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
        System.out.println("driver closed, windows quit");
    }


}
