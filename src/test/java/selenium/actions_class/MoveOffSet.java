package selenium.actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;
import selenium.utils.DriverHelper;

import java.util.List;

public class MoveOffSet {

    WebDriver driver;

    @BeforeMethod
    public void initializeDriver() {
        driver = DriverHelper.getDriver();
    }

    @Test
    public void moveByOffSet() {

        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider = driver.findElement(By.cssSelector("input[type='range']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(30, 15).perform();

    }

    @Test
    public void moveSliderWithActionsTask() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/drag-drop-range-sliders-demo");
        List<WebElement> allSliders = driver.findElements(By.cssSelector("input[class='sp__range']"));
        List<WebElement> allText = driver.findElements(By.xpath("//output"));
        Actions actions = new Actions(driver);

        for (int i = 0; i < allSliders.size(); i++) {

            Thread.sleep(400);
            if (allText.get(i).getText().equalsIgnoreCase("80")){
                actions.clickAndHold(allSliders.get(i)).moveByOffset(-99, 0).perform();
            }else {
                actions.clickAndHold(allSliders.get(i)).moveByOffset(99, 0).perform();
            }

        }


    }

    @Test
    public void moveByOffSetPractice() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");
        WebElement draggable = driver.findElement(By.cssSelector("#dr"));
        WebElement dropArea = driver.findElement(By.cssSelector("#droppable"));
        Actions actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            Thread.sleep(300);
            actions.clickAndHold(draggable).moveByOffset(1000,-200).release().perform(); // based on the numbers x and y, we are dropping our element
            actions.clickAndHold(draggable).moveToElement(dropArea).release().perform(); // we're explicitly specifying where to drop off based on webElement location
        }


    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException {

        if (!result.isSuccess()){
            BrowserUtils.takeScreenshot(driver);
        }
//        Thread.sleep(3000);
//        driver.quit();
    }

}
