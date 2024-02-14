package selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class PianoTest {

    @Test
    public void pianoWebTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.musicca.com/piano");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        List<WebElement> allKeys = driver.findElements(By.xpath("//span[@class='white-key']"));
        List<String> music = Arrays.asList("2g","2g", "3d","3d", "3e","3e","3d","3d","3c","3c","3b","3b","3a", "3a","2g");

        Map<String, WebElement> keyBoard = new HashMap<>();

        for (WebElement key:allKeys){
            keyBoard.put(key.getAttribute("data-note"), key);
        }

        for (String notes:music){
            WebElement element = keyBoard.get(notes);
            Thread.sleep(400);
            element.click();
        }




    }
}
