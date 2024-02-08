package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathShowCase {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        WebElement abTest = driver.findElement(By.xpath("//a[@href='/abtest']")); // relative xpath
        abTest.click();

        Thread.sleep(2000);

        WebElement text = driver.findElement(By.xpath("/html/body/div[2]/div/div/p")); // absolute xpath
        System.out.println(text.getText());

        WebElement footerLink = driver.findElement(By.xpath("/html/body/div[3]/div/div/a")); // absolute xpath
        footerLink.click();



    }
}
