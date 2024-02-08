package selenium.select_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class SelectKatalonTask {
    @Test
    public void validateAppointmentFunctionality() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Clicking on Make Appointment button on main page
        driver.findElement(By.id("btn-make-appointment")).click();

        //Entering userName, password and clicking on login button on login page
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();

        // Choosing desired option from Facility dropdown
        WebElement facilityDropDown = driver.findElement(By.id("combo_facility"));
        Select select = new Select(facilityDropDown);
        select.selectByVisibleText("Seoul CURA Healthcare Center");

        //click on checkBox for hospital readmission
        driver.findElement(By.id("chk_hospotal_readmission")).click();

        Thread.sleep(3000);
        //check radio box for 'None'
        driver.findElement(By.id("radio_program_none")).click();

        // sending keys into the calendar input field
        driver.findElement(By.id("txt_visit_date")).sendKeys("12/31/2024");

        //sending keys into the textarea
        WebElement textArea = driver.findElement(By.id("txt_comment"));
        textArea.sendKeys("Please also book me a nice hotel in Seoul, it must be 5 star hotel please " +
                "thank you!");

        // clicking on 'Book Appointment' button at the end of this page
        driver.findElement(By.id("btn-book-appointment")).click();

        //on Summary page, verifying that Appointment Confirmation text is displayed
        WebElement confirmedText = driver.findElement(By.tagName("h2"));
        String actualText = confirmedText.getText();
        String expectedText = "Appointment Confirmation"; // Provided by PO or BA

        // Assertion Validation
        assertEquals(actualText, expectedText, "Failed to validate actual Texts from final page");

        //retrieving client comment
        WebElement clientComment = driver.findElement(By.id("comment"));
        String actualComment = clientComment.getText();
        String expectedComment = "Please also book me a nice hotel in Seoul, it must be 5 star hotel please " +
                "thank you!";

        // Assertion for validation
        assertEquals(actualComment, expectedComment);


        //clicking 'Go to Homepage' button
        driver.findElement(By.xpath("//a[contains(.,'Go to Homepage')]")).click();





    }

}
