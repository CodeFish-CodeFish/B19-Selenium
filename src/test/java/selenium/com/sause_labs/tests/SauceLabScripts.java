package selenium.com.sause_labs.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.com.sause_labs.pages.LoginPage;

public class SauceLabScripts extends SauceBase{





    @Test
    public void testLoginFunctionality(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFunctionality("test", "qwerty");
        String actualErrorMsg = loginPage.errorMsg();
        String expectedErrorMsg = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }

}
