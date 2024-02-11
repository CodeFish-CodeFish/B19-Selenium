package selenium.xpath_relationships;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XpathRelationTask {

    /*
    Declare your test annotation,
    Create your driver instance
    Navigate to codeFish web app
    Validate texts with assertion, consider using
    isDisplayed method inside the assertion
    quit driver.
     */

    @Test
    public void TC_01(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://codefish.io/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        List<WebElement> allTexts = driver.findElements(By.xpath("//div[@class='gradient-block']//p"));
        for (int i = 0; i < allTexts.size(); i++) {

            Assert.assertTrue(allTexts.get(i).isDisplayed(), "Text is not displayed");
            System.out.println(allTexts.get(i).getText());

        }


    }

    @Test
    public void TC_02() throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//a[contains(.,'Table Pagination')]")).click();
        Thread.sleep(2000);

        WebElement dropdown = driver.findElement(By.id("maxRows"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Show ALL Rows");

        List<WebElement> firstNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> emails = driver.findElements(By.xpath("//tr//td[4]"));

        Map<String, String> data = new HashMap<>();

        for (int i = 0; i < firstNames.size(); i++) {

            String name = firstNames.get(i).getText();
            String email = emails.get(i).getText();
           // data.put(firstNames.get(i).getText(), emails.get(i).getText());
            data.put(name, email);

        }
        System.out.println(data);

    }


    @Test
    public void TC_03() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//a[contains(.,'Table Pagination')]")).click();
        Thread.sleep(2000);

        WebElement dropdown = driver.findElement(By.id("maxRows"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Show ALL Rows");

        List<WebElement> lastNames = driver.findElements(By.xpath("//tr//td[3]"));
        List<WebElement> phonesNumbers = driver.findElements(By.xpath("//tr//td[5]"));

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < lastNames.size(); i++) {


            map.put(lastNames.get(i).getText(), phonesNumbers.get(i).getText().replace("-", ""));

        }
        System.out.println(map);

    }


    @Test
    public void homeworkTablePagination() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//a[contains(.,'Table Pagination')]")).click();
        Thread.sleep(2000);

        WebElement dropdown = driver.findElement(By.id("maxRows"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Show ALL Rows");

        List<WebElement> firstNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> lastNames = driver.findElements(By.xpath("//tr//td[3]"));
        List<WebElement> emails = driver.findElements(By.xpath("//tr//td[4]"));

        Map<String, String> clientInfo = new HashMap<>();

        for (int i = 0; i < firstNames.size(); i++) {

            clientInfo.put(firstNames.get(i).getText() + "."+lastNames.get(i).getText(), emails.get(i).getText());

        }

        System.out.println(clientInfo);
    }





}
