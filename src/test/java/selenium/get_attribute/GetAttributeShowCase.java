package selenium.get_attribute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetAttributeShowCase {

    @Test
    public void TC_05() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//button")).click();
        Thread.sleep(2000);

        List<WebElement> allCheckBoxes = driver.findElements(By.xpath("//div[@role='checkbox']"));

        for (WebElement checkbox : allCheckBoxes){

            if (checkbox.getAttribute("aria-checked").equals("false")){
                checkbox.click();
            }

        }



    }

}
