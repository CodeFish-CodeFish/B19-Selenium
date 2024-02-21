package selenium.pactice_day;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;
import selenium.utils.ConfigReader;
import selenium.utils.DriverHelper;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class SauceDemoPractice {

    /*
    xpath       -> //tagName[@attribute='value']
                    contains text, sibling relationship //
                    parent/child relationship //

    cssLocators -> tagName[attribute='value']
                   id= #id
                   sibling relationship '~', '+'
                   parent/child relationship '>'

     */

    WebDriver driver;

    @BeforeMethod
    public void statUp() {
        driver = DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("sauceURL"));
        WebElement username = driver.findElement(By.cssSelector("#user-name"));
        username.sendKeys(ConfigReader.readProperty("lockedOutUser"));
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys(ConfigReader.readProperty("password"));
        WebElement loginBtn = driver.findElement(By.cssSelector("#login-button"));
        loginBtn.click();
    }


    @Test
    public void validateSortFunctionality() {

        WebElement sortDropdown = driver.findElement(By.cssSelector(".product_sort_container")); // cssLocator for class attribute's value
        BrowserUtils.selectBy(sortDropdown, "Price (low to high)", "visibleText");

        List<WebElement> allPrices = driver.findElements(By.cssSelector(".inventory_item_price"));
        double []actualPrices = new double[allPrices.size()]; // coming from web
        double[] sortedPrice = new double[allPrices.size()]; // this will be sorted here

        for (int i = 0; i < allPrices.size(); i++) {
            actualPrices[i] = Double.parseDouble(allPrices.get(i).getText().replace("$", ""));
            sortedPrice[i] = Double.parseDouble(allPrices.get(i).getText().replace("$", ""));
        }

        for (int i = 0; i < sortedPrice.length; i++) {

            double temp=0;

            for (int j = i+1; j < sortedPrice.length; j++) {

                if (sortedPrice[i] > sortedPrice[j]){
                    temp = sortedPrice[i];
                    sortedPrice[i] = sortedPrice[j];
                    sortedPrice[j]=temp;
                }
            }

        }
        Assert.assertEquals(actualPrices, sortedPrice, "Failed to validate");
    }

    /*
    Login with locked out user and validate the error message
    You already have locators for username, password and login button
    1. Create separate test annotation
    2. need to get locator for error message
    3. validate the error message with assertion
     */

    @Test
    public void validateErrorMsg(){
        WebElement errorMessage = driver.findElement(By.xpath("//h3")); //following-sibling
        String actualText = BrowserUtils.getText(errorMessage);
        String expectedText = "Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals(actualText, expectedText, "Failed to validate error message");
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
