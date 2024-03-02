package selenium.com.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LumaMain {

    // Another way of finding and treating webElements
    WebDriver driver;

    public LumaMain(WebDriver driver) {
        this.driver = driver;
    }

    private By gear = By.xpath("//span[.='Gear']");


    private By bags = By.xpath("//a[.='Bags']");

    public WebElement clickOnBags() {
        return driver.findElement(bags);
    }

    public WebElement hoverOverGear() {
        return driver.findElement(gear);
    }


}
