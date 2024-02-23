package selenium.utils;

import com.beust.ah.A;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BrowserUtils {

    public static String getText(WebElement element) {
        return element.getText().trim();
    }

    public static String getTitle(WebDriver driver) {

        return driver.getTitle().trim();

    }

    public static void acceptAlert(WebDriver driver) {
        // recursion
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    public static void dismissAlert(WebDriver driver) {

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

    }

    public static void sendKeysToAlert(WebDriver driver, String keysToSend) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(keysToSend);
    }

    public static String alertGetText(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        return alert.getText().trim();

    }


    public static void selectBy(WebElement element, String value, String methodName) {
        Select select = new Select(element);
        switch (methodName) {
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

    public static List<WebElement> getOptionsSelect(WebElement element) {
        Select select = new Select(element);
        return select.getOptions();
    }


    public static WebElement findElement(WebDriver driver, By by) {
        return driver.findElement(by);
    }


    public static void clickHoldAndDrop(WebDriver driver, WebElement location, WebElement dropZone){

        Actions actions = new Actions(driver);
        actions.clickAndHold(location).moveToElement(dropZone).release().build().perform();

    }

    public static void dragAndDrop(WebDriver driver, WebElement draggable, WebElement dropZone){

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, dropZone).perform();

    }

    public static void scrollByAmount(WebDriver driver, int x, int y){
        Actions actions = new Actions(driver);
        actions.scrollByAmount(x,y).build().perform();
    }

    public static void scrollToElement(WebDriver driver, WebElement toElement){

        Actions actions = new Actions(driver);
        actions.scrollToElement(toElement).build().perform();

    }

    public static void moveByOffSetWithClick(WebDriver driver, WebElement element, int x, int y){
        Actions actions = new Actions(driver);
        actions.clickAndHold(element).moveByOffset(x, y).build().perform();
    }

    public static void moveTo(WebDriver driver, WebElement target){
        Actions actions = new Actions(driver);
        actions.moveToElement(target).build().perform();
    }

    public static void takeScreenshot(WebDriver driver){

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String location = System.getProperty("user.dir") + "/src/main/screenshots/";

        File directory = new File(location); // directory == folder
        if (!directory.exists()){
            directory.mkdir();
        }

        try {
            FileUtils.copyFile(file, new File(location + System.currentTimeMillis() + ".png"));
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    // javascript re-usable methods below
    public static String getTitleWithJS(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.title").toString();

    }

    public static void clickWithJS(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }

    public static void scrollIntoViewJS(WebDriver driver, WebElement element){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);

    }

    public static void scrollWithPointJS(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Point point = element.getLocation();
        int x = point.getX();
        int y = point.getY();
        js.executeScript("window.scrollTo(" + x + "," + y + ")");
    }

}
