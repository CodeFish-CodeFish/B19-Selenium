package selenium.select_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SelectShowCase {

    @Test
    public void practiceSelect() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//a[contains(text(),'Select Dropdown List')]")).click();
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='select-demo']"));

        Select select = new Select(dropdownElement); // Select class is used only for dropdowns

//        select.selectByVisibleText("Saturday");
//        select.selectByIndex(7);
//        select.selectByValue("Saturday");

        List<WebElement> options = select.getOptions();

        for (int i = 0; i < options.size(); i++) {

            System.out.println(options.get(i).getText());

        }


    }
}
