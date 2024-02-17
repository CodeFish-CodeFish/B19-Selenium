package selenium.upload_file;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;
import selenium.utils.DriverHelper;

import java.time.Duration;

public class UploadFile {

    @Test
    public void TC_6() throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement fileUpload = driver.findElement(By.cssSelector("input[id='file-upload']"));
        fileUpload.sendKeys("/Users/codefish/Downloads/Project/Project/B19-Selenium/src/test/resources/testData/TomAndJerry.jpeg");
        Thread.sleep(3000);
        WebElement fileSubmitBtn = driver.findElement(By.cssSelector("input[id='file-submit']"));
        fileSubmitBtn.click();

        WebElement successMessage = driver.findElement(By.tagName("h3"));
        String actualSuccessMessage = BrowserUtils.getText(successMessage);
        String expectedSuccessMessage = "File Uploaded!";

        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage, "Failed to validate success message for file upload");

        WebElement fileNameText = driver.findElement(By.cssSelector("div[id='uploaded-files']"));

        String actualFileName = BrowserUtils.getText(fileNameText);
        String expectedFileName = "TomAndJerry.jpeg";

        Assert.assertEquals(actualFileName, expectedFileName, "Failed to validate file name text after upload");

    }

}
