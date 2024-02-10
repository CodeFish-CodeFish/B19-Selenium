package selenium.select_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SelectPractice {

    @Test
    public void selectTask() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        List<WebElement> allElements = driver.findElements(By.xpath("//a"));

        for (int i = 1; i < allElements.size(); i++) {

            if (allElements.get(i).getText().equals("Dropdown")){
                allElements.get(i).click();
                break;
            }

        }

        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";

        Assert.assertEquals(actualTitle, expectedTitle, "Failed to validate titles");

        WebElement header = driver.findElement(By.tagName("h3"));

        String actualHeader = header.getText();
        String expectedHeader = "Dropdown List";

        Assert.assertEquals(actualHeader, expectedHeader, "Failed to validate header text");

        WebElement dropdown = driver.findElement(By.id("dropdown"));

        Select select = new Select(dropdown);
        System.out.println(select.getFirstSelectedOption().getText());
        List<WebElement> selectOptions = select.getOptions();

        for (WebElement eachElementFromListOfWebElement :selectOptions ){

            System.out.println(eachElementFromListOfWebElement.getText());
            if (eachElementFromListOfWebElement.getText().equals("Option 2")){
                eachElementFromListOfWebElement.click();
                break;
            }

        }

        Thread.sleep(3000);
        select.selectByVisibleText("Option 1");




    }
}
