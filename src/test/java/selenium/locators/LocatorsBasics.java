package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
    Locators in Selenium are as follows:

    TagName, ID, Name, ClassName, LinkText, PartialLinkText - basic locators

    The above mentioned locators can be used to locate webElements in the web page

    Important: In order to use locators, they must be present and be unique in the DOM structure

 */
public class LocatorsBasics {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/codefish/Desktop/B19%20HTML/B19FirstHTML.html");
        driver.manage().window().maximize();

        WebElement text = driver.findElement(By.tagName("h1")); // tagName
        String actualText = text.getText();
        String expectedText = "I love coding"; // from PO or BA

        System.out.println(actualText);

        if (actualText.equals(expectedText)){
            System.out.println("Pass");
        }else {
            System.out.println("Failed");
        }


        WebElement clickHereLink = driver.findElement(By.linkText("Click Here for help"));
        clickHereLink.click();




    }
}
