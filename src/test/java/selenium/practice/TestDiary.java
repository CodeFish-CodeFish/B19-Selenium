package selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;


import java.time.Duration;
import java.util.List;

public class TestDiary {

    @Test
    public void fillInInputFields() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.testdiary.com/training/selenium/selenium-test-page/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement seleniumCheckBox = BrowserUtils.findElement(driver, By.cssSelector("#seleniumbox"));

        WebElement javaCheckBox = BrowserUtils.findElement(driver, By.cssSelector("#java1"));

        WebElement restAPICheckBox = BrowserUtils.findElement(driver, By.cssSelector("#restapibox"));

        if (!seleniumCheckBox.isSelected() && !javaCheckBox.isSelected() && restAPICheckBox.isSelected()) {
            seleniumCheckBox.click(); // will check
            javaCheckBox.click(); // will check
            restAPICheckBox.click(); // will uncheck
        }

        List<WebElement> hyperLinks = driver.findElements(By.xpath("//div[@id='header']//a[contains(text(),'Test Diary')]"));
        hyperLinks.get(0).click();
        WebElement testDiaryHeader = driver.findElement(By.xpath("//h1"));
        Assert.assertEquals(BrowserUtils.getText(testDiaryHeader), "Test Diary");
        driver.navigate().back();
        // handling StaleElementReferenceException
        hyperLinks = driver.findElements(By.xpath("//div[@id='header']//a[contains(text(),'Test Diary')]"));
        hyperLinks.get(1).click();

        WebElement seleniumHeader = driver.findElement(By.xpath("//h1"));
        Assert.assertEquals(BrowserUtils.getText(seleniumHeader), "Selenium");
        driver.navigate().back();
        Thread.sleep(2000);
        WebElement shirtsDropdown = driver.findElement(By.id("Shirts"));
        BrowserUtils.selectBy(shirtsDropdown, "Yellow Shirt", "visibleText");
        WebElement skirtsDropDown = driver.findElement(By.id("Skirts"));
        BrowserUtils.selectBy(skirtsDropDown, "Red Skirt", "visibleText");

        WebElement inputName = driver.findElement(By.name("your-name"));
        inputName.sendKeys("Kuba");

        WebElement inputEmail = driver.findElement(By.name("your-email"));
        inputEmail.sendKeys("test@test.com");

        WebElement inputSubject = driver.findElement(By.name("your-subject"));
        inputSubject.sendKeys("Subject of my message");

        WebElement inputMessage = driver.findElement(By.name("your-message"));
        inputMessage.sendKeys("My Message goes here please read and reply!");

        WebElement submitBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        submitBtn.click();
        Thread.sleep(7000);
        WebElement successMessage = driver.findElement(By.xpath("//input[@type='submit']//..//following-sibling::div"));
        Assert.assertEquals(BrowserUtils.getText(successMessage), "Your message was sent successfully. Thanks.");


    }
}
