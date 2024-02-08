package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsBasics_2 {

    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/codefish/Desktop/B19%20HTML/InputForms.html");
        driver.manage().window().maximize();

        WebElement firstName = driver.findElement(By.id("fname"));
        firstName.sendKeys("Bruce");

        WebElement lastName = driver.findElement(By.name("lname"));
        lastName.sendKeys("Lee");

        WebElement bDate = driver.findElement(By.id("bdate"));
        bDate.sendKeys("01/06/2022");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("test@test.com");

        WebElement quantity = driver.findElement(By.name("quantity"));
        quantity.sendKeys("100");

        driver.findElement(By.id("Dr.")).click();

        WebElement paragraph = driver.findElement(By.tagName("p"));
        System.out.println(paragraph.getText());

        WebElement clickHere = driver.findElement(By.partialLinkText("click"));
        clickHere.click();


    }
}
