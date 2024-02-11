package selenium.select_class;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class SelectPractice2 {

    @Test
    public void bookAFlight() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.cssSelector("input[value='oneway']")).click();

        WebElement passCount = driver.findElement(By.cssSelector("select[name='passCount']"));
//        Select passengerSelect = new Select(passCount);
//        passengerSelect.selectByValue("4");
        BrowserUtils.selectBy(passCount, "4", "value");

//        Select departCityDropdown = new Select(driver.findElement(By.cssSelector("select[name='fromPort']")));
//        departCityDropdown.selectByVisibleText("Seattle");
        BrowserUtils.selectBy(driver.findElement(By.cssSelector("select[name='fromPort']")), "Seattle", "visibleText");

//        Select monthSelect = new Select(driver.findElement(By.cssSelector("select[name='fromMonth']")));
//        monthSelect.selectByIndex(11);
        BrowserUtils.selectBy(driver.findElement(By.cssSelector("select[name='fromMonth']")), "11", "index");

//        Select daySelect = new Select(driver.findElement(By.cssSelector("select[name='fromDay']")));
//        daySelect.selectByIndex(20);
        BrowserUtils.selectBy(driver.findElement(By.cssSelector("select[name='fromDay']")), "20", "index");


//        Select destinationSelect = new Select(driver.findElement(By.cssSelector("select[name='toPort']")));
//        destinationSelect.selectByVisibleText("New York");

        BrowserUtils.selectBy(driver.findElement(By.cssSelector("select[name='toPort']")), "New York", "visibleText");

//        Select toMonthSelect = new Select(driver.findElement(By.cssSelector("select[name='toMonth']")));
//        toMonthSelect.selectByIndex(11);
        BrowserUtils.selectBy(driver.findElement(By.cssSelector("select[name='toMonth']")), "11", "index");


        BrowserUtils.selectBy(driver.findElement(By.cssSelector("select[name='toDay']")), "25", "index");

        driver.findElement(By.cssSelector("input[value='First']")).click();


        WebElement airLines = driver.findElement(By.cssSelector("select[name='airline']"));
        List<WebElement> allAirLines = BrowserUtils.getOptionsSelect(airLines);
        for (WebElement eachAirline : allAirLines) {
            System.out.println(BrowserUtils.getText(eachAirline));
        }
        BrowserUtils.selectBy(airLines, "Unified Airlines", "visibleText");

        driver.findElement(By.cssSelector("input[name='findFlights']")).click();

        WebElement message = driver.findElement(By.xpath("//b[contains(.,'After flight finder - No Seats Avaialble')]"));
        String actualText = BrowserUtils.getText(message);
        System.out.println(actualText);

    }


    @Test
    public void taskSelect() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/jquery-dropdown-search-demo");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement selectCountrySearchBar = driver.findElement(By.xpath("//span[@id='select2-country-container']//following-sibling::span[@class='select2-selection__arrow']"));
        selectCountrySearchBar.click();

        WebElement searchBar = driver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']"));
        searchBar.sendKeys("United States of America", Keys.ENTER);

        WebElement multiSelectState = driver.findElement(By.cssSelector("span[class='select2-selection select2-selection--multiple']"));
        multiSelectState.sendKeys("Illinois", Keys.ENTER);

        WebElement puertoRicoSelect = driver.findElement(By.xpath("//span[contains(text(),'Puerto Rico')]"));
        puertoRicoSelect.click();

        // This is reinitialized because of StaleElementReferenceException
        searchBar = driver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']"));

        searchBar.sendKeys("Virgin Islands", Keys.ENTER);

        Thread.sleep(3000);

        WebElement languages = driver.findElement(By.cssSelector("#files"));
        BrowserUtils.selectBy(languages, "Java","visibleText");






    }


}
