package selenium.com.qa_fox.tests;

import org.testng.annotations.Test;
import selenium.com.qa_fox.pages.ProductListPage;
import selenium.com.qa_fox.pages.QAFoxMainPage;

public class QAFoxScript extends QABase{


    @Test
    public void TC_01_PositiveScenario() throws InterruptedException {
        QAFoxMainPage mainPage = new QAFoxMainPage(driver);
        ProductListPage listPage = new ProductListPage(driver);

        mainPage.clickOnShowAllDesktops(driver);
        listPage.validateSorting();
    }
}
