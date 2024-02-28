package selenium.com.php.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.com.php.pages.PhpLoginPage;
import selenium.com.php.pages.PhpMainPage;

public class PhpTest extends PhpBase{

    @DataProvider(name = "TestDataPhp")
    public Object[][]getData(){
        return new Object[][]{
                {"Kobe", "Abdy", "BusinessName", "test@test.com"},
                {"Tony","Stark","Marvel","marvel@test.com"},
                {"Mobius","Test","The TVA","mobius@test.com"}
        };
    }

    @Test(dataProvider = "TestDataPhp")
    public void validateInputFields(String firstName, String lastName,
                                    String businessName, String email) throws InterruptedException {

        PhpMainPage mainPage = new PhpMainPage(driver);


        mainPage.clickOnDemo();
        PhpLoginPage loginPage = new PhpLoginPage(driver);
        loginPage.fillInBlanks(firstName, lastName, businessName, email);

    }


}
