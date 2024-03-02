package selenium.com.yale.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import selenium.com.yale.pages.ContactUsPage;
import selenium.com.yale.pages.WebEditorsPage;
import selenium.com.yale.pages.YaleMainPage;
import selenium.utils.DriverHelper;

public class YaleScript extends YaleBase{

    @Parameters({"name", "email", "website","text"})
    @Test
    public void TC_01(String name, String email, String website, String text){
        YaleMainPage mainPage = new YaleMainPage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        WebEditorsPage editorsPage = new WebEditorsPage(driver);

        mainPage.validateHeaders();
        mainPage.validateScrollAndClick(driver);

        contactUsPage.validateAddress();
        contactUsPage.validateTitleAndURL(driver);
        contactUsPage.scrollAndClickWebEditor(driver);

        editorsPage.validateTitleAndURL(driver);
        editorsPage.fillInputFields(name, email, website, text);

        /*
        Task: continue this project on WebEditors page, validate title and url
              fill the input fields but do not submit
         */
    }
}
