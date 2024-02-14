package selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class NinjaTest {

    @Test
    public void createUser() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement firstName = driver.findElement(By.cssSelector("input[id='input-firstname']"));//input[@id='input-first']
        firstName.sendKeys("Kuan");
        WebElement lastName = driver.findElement(By.cssSelector("#input-lastname"));
        lastName.sendKeys("Abdy");
        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("tb@mb.com");
        WebElement telephone = driver.findElement(By.name("telephone"));
        telephone.sendKeys("3123332211");
        Thread.sleep(2000);
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("ewiryefgdahjsfgj");
        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        confirmPassword.sendKeys("ewiryefgdahjsfgj");
        List<WebElement> radioButton = driver.findElements(By.xpath("//label[@class='radio-inline']"));

        for (int i = 0; i < radioButton.size(); i++) {
//            System.out.println(radioButton.get(i).getText());
            if (BrowserUtils.getText(radioButton.get(i)).equalsIgnoreCase("yes")){
                radioButton.get(i).click();
                break;
            }

        }


        WebElement checkBox = driver.findElement(By.cssSelector("input[name='agree']"));

        if (!checkBox.isSelected()){
            checkBox.click();
        }

        WebElement continueBtn = driver.findElement(By.cssSelector("input[type='submit']"));
        continueBtn.click();




    }
}
