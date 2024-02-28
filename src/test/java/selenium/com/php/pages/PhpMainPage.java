package selenium.com.php.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhpMainPage {

    public PhpMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li//a[@href='https://phptravels.com/demo']")
    WebElement demoLink;

    public void clickOnDemo() throws InterruptedException {

        demoLink.click();
        Thread.sleep(1000);
    }
}
