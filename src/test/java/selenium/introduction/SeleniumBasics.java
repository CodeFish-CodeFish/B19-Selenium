package selenium.introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SeleniumBasics {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();//
        driver.get("https://www.google.com/");// will wait for elements to be loaded

        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        // Validation
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Pass");
        }else {
            System.out.println("Failed");
        }

        driver.navigate().to("https://www.ebay.com/");// will do the same as get method except, navigate to
        // does not wait for elements on the web page to be loaded

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());


    }


}
