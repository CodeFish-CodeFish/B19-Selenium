package selenium.com.sause_labs.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.com.sause_labs.pages.LoginPage;

public class SauceLabScripts extends SauceBase {


    @DataProvider(name = "dataForSauceLab")
    public Object[][] getData() {
        return new Object[][]{
                //username| password| error message
                {"test", "12345", "Epic sadface: Username and password do not match any user in this service"},  //each of these is treated as a separate test case
                {"!@##$", "!@#@#$@#", "Epic sadface: Username and password do not match any user in this service"}, //
                {"123234", "!@#@#", "Epic sadface: Username and password do not match any user in this service"}, //
                {"legitLogin", "   ", "Epic sadface: Username and password do not match any user in this service"} //
        };
    }


    @Test(dataProvider = "dataForSauceLab")
    public void testLoginFunctionality(String username, String password, String errorMessage) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFunctionality(username, password);
        String actualErrorMsg = loginPage.errorMsg();
        //String expectedErrorMsg = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMsg, errorMessage);

        /*
        DataProvider - provided by TestNG
         */
    }

}
