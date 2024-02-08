package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathTask {

    public static void main(String[] args) {

        /*
        Manually click on Input Form Submit link
        Fill out all the input fields
        Skip Country dropdown
        Click on submit button
         */

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");
        driver.manage().window().maximize();

        WebElement nameField = driver.findElement(By.xpath("//input[@id='name']"));
        nameField.sendKeys("Michael Jordan");

        WebElement emailField = driver.findElement(By.xpath("//input[@id='inputEmail4']"));
        emailField.sendKeys("test@test.com");

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='inputPassword4']"));
        passwordField.sendKeys("secretPassword");

        WebElement companyField = driver.findElement(By.xpath("//input[@name='company']"));
        companyField.sendKeys("IBM");

        WebElement websiteField = driver.findElement(By.xpath("//input[@name='website']"));
        websiteField.sendKeys("www.ibm.com");

        WebElement cityField = driver.findElement(By.xpath("//input[@name='city']"));
        cityField.sendKeys("Chitown");

        WebElement address1Field = driver.findElement(By.xpath("//input[@name='address_line1']"));
        address1Field.sendKeys("1 N Dearborn st");

        WebElement address2Field = driver.findElement(By.xpath("//input[@name='address_line2']"));
        address2Field.sendKeys("2 N Dearborn st");

        WebElement stateField = driver.findElement(By.xpath("//input[@id='inputState']"));
        stateField.sendKeys("Oshington");

        WebElement zipCodeField = driver.findElement(By.xpath("//input[@id='inputZip']"));
        zipCodeField.sendKeys("60625");

        WebElement submitBtn = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        submitBtn.click();



    }
}
