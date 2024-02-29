package selenium.com.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.BrowserUtils;

public class LaptopPage {

    public LaptopPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[.='MacBook Pro']")
    WebElement macBookPro;

    public void clickOnMacBookPro(WebDriver driver){
        BrowserUtils.scrollIntoViewJS(driver, macBookPro);
        macBookPro.click();
    }
}
