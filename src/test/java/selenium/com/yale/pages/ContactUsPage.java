package selenium.com.yale.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import selenium.utils.BrowserUtils;

public class ContactUsPage {

    public ContactUsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//p[contains(.,'Yale University')]")
    WebElement address;

    @FindBy(xpath = "//a[.='Contact Web Editor']")
    WebElement webEditorLink;



    public void validateAddress(){
        System.out.println(BrowserUtils.getText(address));
        Assert.assertTrue(address.isDisplayed());
    }

    public void validateTitleAndURL(WebDriver driver){

        //Validating url of contact us page
        String expectedURL = "https://www.yale.edu/contact-us";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);

        //Validating title of contact us page
        String expectedTitle = "Contact Us | Yale University";
        String actualTitle = BrowserUtils.getTitle(driver);
        Assert.assertEquals(expectedTitle, actualTitle);

    }

    public void scrollAndClickWebEditor(WebDriver driver){
        BrowserUtils.scrollIntoViewJS(driver, webEditorLink);
        webEditorLink.click();
    }


}
