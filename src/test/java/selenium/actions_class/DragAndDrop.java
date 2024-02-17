package selenium.actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;
import selenium.utils.DriverHelper;

public class DragAndDrop {

    WebDriver driver;
    @BeforeMethod
    public void startUp(){
        driver = DriverHelper.getDriver();
    }

    @Test
    public void dragAndDropPractice() throws InterruptedException {

        driver.get("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");
        WebElement draggable1 = driver.findElement(By.xpath("//span[.='Draggable 1']"));
        WebElement draggable2 = driver.findElement(By.xpath("//span[.='Draggable 2']"));
        WebElement dropzone = driver.findElement(By.cssSelector("#mydropzone"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable1, dropzone).perform();
        actions.dragAndDrop(draggable2, dropzone).perform();

        WebElement droppedList = driver.findElement(By.cssSelector("#droppedlist"));
        System.out.println(BrowserUtils.getText(droppedList));
        System.out.println(droppedList.getCssValue("visibility"));

        Thread.sleep(2000);
        WebElement draggable = driver.findElement(By.cssSelector("#draggable"));
        WebElement dropArea = driver.findElement(By.cssSelector("#droppable"));

        actions.dragAndDrop(draggable, dropArea).build().perform();


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000); // during interview, do not mention that you use Thread.sleep unless you're sure about it
        driver.quit();
    }
}
