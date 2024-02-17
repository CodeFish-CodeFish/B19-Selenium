package selenium.actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;
import selenium.utils.DriverHelper;

public class ClickAndHold {

    WebDriver driver;
    @BeforeMethod
    public void initializeDriver(){
        driver = DriverHelper.getDriver();
    }

    @Test
    public void clickAndHoldPractice(){

        driver.navigate().to("https://demoqa.com/droppable");
        WebElement draggable = driver.findElement(By.cssSelector("#draggable"));
        WebElement dropPlace = driver.findElement(By.cssSelector("div[id='draggable']~div[id='droppable']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(dropPlace).release().perform();

        WebElement droppedMessage = driver.findElement(By.xpath("//p[.='Dropped!']"));
        Assert.assertEquals(BrowserUtils.getText(droppedMessage), "Dropped!");
    }

    @Test
    public void dragAndDropPractice() throws InterruptedException {
        driver.get("https://demoqa.com/droppable");
        WebElement acceptLink = driver.findElement(By.cssSelector("#droppableExample-tab-accept"));
        acceptLink.click();

        WebElement acceptable = driver.findElement(By.cssSelector("#acceptable"));
        WebElement notAcceptable = driver.findElement(By.cssSelector("#notAcceptable"));
        WebElement dropArea = driver.findElement(By.xpath("//div[@id='acceptable']//..//following-sibling::div[@id='droppable']"));

        Thread.sleep(2000);
        Actions actions = new Actions(driver);

        actions.clickAndHold(acceptable).moveToElement(dropArea).release().perform();
        actions.clickAndHold(notAcceptable).moveToElement(dropArea).release().perform();

        WebElement droppedMessage = driver.findElement(By.xpath("//p[.='Dropped!']"));
        System.out.println("BrowserUtils.getText(droppedMessage) = " + BrowserUtils.getText(droppedMessage));
        System.out.println(droppedMessage.getCssValue("font-family"));


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
