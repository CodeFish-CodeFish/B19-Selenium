package selenium.com.sause_labs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.BrowserUtils;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "#user-name")
    WebElement username;

    @FindBy(css = "#password")
    WebElement password;

    @FindBy(css = "#login-button")
    WebElement loginBtn;

    @FindBy(tagName = "h3")
    WebElement errorMessage;

    public void loginFunctionality(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginBtn.click();
    }

    public String errorMsg() {
        return BrowserUtils.getText(errorMessage);
    }


}
