package selenium.com.yale.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WebEditorsPage {

    public WebEditorsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#edit-submitted-name")
    WebElement name;

    @FindBy(css = "#edit-submitted-email")
    WebElement email;

    @FindBy(css = "#edit-submitted-website-url")
    WebElement websiteURL;

    @FindBy(css = "#edit-submitted-comments")
    WebElement textArea;

    public void validateTitleAndURL(WebDriver driver){
        // Validating title
        String expectedTitle = "Contact Web Editor | Yale University";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //Validating URL of WebEditors page
        String expectedURL = "https://www.yale.edu/contact-us/contact-web-editor";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);

    }

    public void fillInputFields(String name, String email, String websiteURL, String textArea){
//        name.sendKeys("Kobe");
//        email.sendKeys("test@test.com");
//        websiteURL.sendKeys("www.google.com");
//        textArea.sendKeys("test test test");
        this.name.sendKeys(name);
        this.email.sendKeys(email);
        this.websiteURL.sendKeys(websiteURL);
        this.textArea.sendKeys(textArea);


    }


}
