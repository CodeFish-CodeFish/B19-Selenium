package selenium.introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics_2 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("file:///Users/codefish/Desktop/B19%20HTML/B19FirstHTML.html");

        driver.manage().window().maximize();


        String pageSource = driver.getPageSource();
        System.out.println("page sourse " + pageSource);

        driver.navigate().to("https://www.youtube.com/");
        driver.navigate().back();

        Thread.sleep(2000);

        driver.navigate().forward();
        driver.navigate().refresh();

        //driver.close(); // Will close only the one that driver is looking at
        driver.quit(); // will shut down all the browsers that were opened with selenium


    }

}
