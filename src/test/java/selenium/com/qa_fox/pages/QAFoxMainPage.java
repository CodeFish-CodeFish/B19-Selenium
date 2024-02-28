package selenium.com.qa_fox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.BrowserUtils;

public class QAFoxMainPage {

    public QAFoxMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[.='Desktops']")
    WebElement desktopTab;

    @FindBy(xpath = "//a[.='Show AllDesktops']")
    WebElement showAllDesktops;

    @FindBy(xpath = "//a[.='Register']")
    WebElement registerLink;

    @FindBy(xpath = "//span[.='My Account']")
    WebElement myAccount;


    public void clickOnShowAllDesktops(WebDriver driver) throws InterruptedException {
        BrowserUtils.moveTo(driver, desktopTab);
        Thread.sleep(2000);
        BrowserUtils.clickWithJS(driver, showAllDesktops);
    }

    public void clickOnRegister(WebDriver driver){
        BrowserUtils.clickWithJS(driver, myAccount);
        BrowserUtils.clickWithJS(driver, registerLink);
    }
}
