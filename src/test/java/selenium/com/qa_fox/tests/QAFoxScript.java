package selenium.com.qa_fox.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import selenium.com.qa_fox.pages.ClientRegisterPage;
import selenium.com.qa_fox.pages.ProductListPage;
import selenium.com.qa_fox.pages.QAFoxMainPage;

public class QAFoxScript extends QABase {


    @Test
    public void TC_01_PositiveScenario() throws InterruptedException {
        QAFoxMainPage mainPage = new QAFoxMainPage(driver);
        ProductListPage listPage = new ProductListPage(driver);

        mainPage.clickOnShowAllDesktops(driver);
        listPage.validateSorting();
    }

    @Test
    public void validateCustomerCreateProfile() throws InterruptedException {

        QAFoxMainPage mainPage = new QAFoxMainPage(driver);
        mainPage.clickOnRegister(driver);

        String firstName = "Loki";

        ClientRegisterPage registerPage = new ClientRegisterPage(driver);
        registerPage.createCustomerProfile(firstName, "Test", "loki@test.com",
                "31232323", "qwert");



    }

    /*
    Navigate to main page of QA Fox
    1. Click on my account from mainPage
    2. Click on register link from mainPage
    3. On register age, fill in all required input fields (parametrize your data, no need to use
        dataProvider)
    4. Click 'yes' radio button
    5. Check checkBox for privacy
    6. Click Continue button

     */


}
