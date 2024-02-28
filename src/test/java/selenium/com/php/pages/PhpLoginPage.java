package selenium.com.php.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.BrowserUtils;

public class PhpLoginPage {

    public PhpLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "first_name")
    WebElement firstName;

    @FindBy(name = "last_name")
    WebElement lastName;

    @FindBy(name = "business_name")
    WebElement businessName;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(css = "#demo")
    WebElement submitBtn;

    @FindBy(css = "#numb1")
    WebElement num1;

    @FindBy(css = "#numb2")
    WebElement num2;

    @FindBy(css = "#number")
    WebElement answerInput;

    public void fillInBlanks(String firstName, String lastName,
                             String businessName, String email) {

        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.businessName.sendKeys(businessName);
        this.email.sendKeys(email);

        String n1 = BrowserUtils.getText(num1);
        String n2 = BrowserUtils.getText(num2);

        int answer = Integer.parseInt(n1) + Integer.parseInt(n2);

        this.answerInput.sendKeys(String.valueOf(answer));
        this.submitBtn.click();
    }


}
