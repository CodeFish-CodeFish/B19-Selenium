package selenium.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BrowserUtils {

    public static String getText(WebElement element){
        return element.getText().trim();
    }

    public static String getTitle(WebDriver driver){

        return driver.getTitle().trim();

    }

    public static void acceptAlert(WebDriver driver){
       // recursion
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }


    public static void selectBy(WebElement element, String value, String methodName){
        Select select = new Select(element);
        switch (methodName){
            case "visibleText":
                select.selectByVisibleText(value);
                break;

            case "value":
                select.selectByValue(value);
                break;

            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;

            default:
                System.out.println("Please choose correct select method");
        }

    }

    public static List<WebElement> getOptionsSelect(WebElement element){
        Select select = new Select(element);
       return select.getOptions();
    }


    public static WebElement findElement(WebDriver driver, By by)  {
        return driver.findElement(by);
    }
}
