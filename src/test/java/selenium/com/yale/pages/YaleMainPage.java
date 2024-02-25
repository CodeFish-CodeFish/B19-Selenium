package selenium.com.yale.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import selenium.utils.BrowserUtils;

import java.util.List;

public class YaleMainPage {

    public YaleMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='main_nav_link']")
    List<WebElement> allHeaders;

    @FindBy(xpath = "//a[.='Contact Us']")
    WebElement contactUsLink;

    public void validateHeaders(){

        for (int i = 0; i < 6; i++) {
            Assert.assertTrue(allHeaders.get(i).isDisplayed());
            System.out.println(BrowserUtils.getText(allHeaders.get(i)));
        }

    }

    public void validateScrollAndClick(WebDriver driver){

        BrowserUtils.scrollToElement(driver, contactUsLink);
        contactUsLink.click();

    }



















    ////a[@class='main_nav_link']
}
