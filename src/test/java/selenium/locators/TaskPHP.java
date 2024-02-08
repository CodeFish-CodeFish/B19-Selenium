package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class TaskPHP {

    @Test
    public void FillInFields(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://phptravels.com/demo");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        /*
        Fill in all the fields
        Do the math
        Provide the answer into the field
        Click Submit afterwards
        quit your browser at the end
         */

        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Kobe");
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Bryant");
        driver.findElement(By.xpath("//input[@name='business_name']")).sendKeys("NBA");
        driver.findElement(By.xpath("//input[@class='email form-control']")).sendKeys("kobe@test.com");

        WebElement number1 = driver.findElement(By.xpath("//span[@id='numb1']"));
        String num1 = number1.getText();

        WebElement number2 = driver.findElement(By.xpath("//span[@id='numb2']"));
        String num2 = number2.getText();

        Integer answer = Integer.parseInt(num1) + Integer.parseInt(num2);

        String realAnswer = String.valueOf(answer);

        WebElement answerInputField = driver.findElement(By.xpath("//input[@id='number']"));
        answerInputField.sendKeys(realAnswer);

        WebElement submitBtn = driver.findElement(By.xpath("//button[contains(.,'Submit')]"));
        submitBtn.click();




    }



}
