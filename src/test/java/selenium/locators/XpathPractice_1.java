package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.utils.BrowserUtils;

import java.text.BreakIterator;

public class XpathPractice_1 {


    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.lambdatest.com/selenium-playground/ajax-form-submit-demo");
        driver.manage().window().maximize();

        WebElement inputName = driver.findElement(By.xpath("//input[@id='title']"));
        inputName.sendKeys("Kuba ksjdfhadsjfs skdjghkadn gmfand gkjf kagjhkfdjhgkjad");

//        WebElement inputMessage = driver.findElement(By.xpath("//textarea[@name='description']"));
//        inputMessage.sendKeys("Wassap");

        WebElement inputMessage = BrowserUtils.findElement(driver, By.xpath("//textarea[@name='description']"));
        inputMessage.sendKeys("Wassap");

        WebElement submitBtn = driver.findElement(By.xpath("//input[@id='btn-submit']"));
        submitBtn.click();

        WebElement submissionMessage = driver.findElement(By.id("submit-control"));
        System.out.println(submissionMessage.getText());




    }

}
