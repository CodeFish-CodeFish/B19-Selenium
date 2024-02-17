package selenium.actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.utils.DriverHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HoverOver {
    WebDriver driver;
    @BeforeMethod
    public void startUp(){
        driver = DriverHelper.getDriver();
    }

    @Test
    public void hoverOverPractice() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/hovers");
        List<WebElement> allUsers = driver.findElements(By.xpath("//div[@class='figure']"));
        List<WebElement> allUserNames = driver.findElements(By.xpath("//h5"));
        List<String> allTestNames = new ArrayList<>();
        //name: user1=1, name: user2=1, name: user3=1

        Map<String, Integer> map = new HashMap<>();
        Actions actions = new Actions(driver);
        for (int i = 0; i < allUsers.size(); i++) {
            Thread.sleep(300);
            actions.moveToElement(allUsers.get(i)).perform();
            allTestNames.add(allUserNames.get(i).getText());
            if (!map.containsKey(allUserNames.get(i).getText())){
                map.put(allUserNames.get(i).getText(),1);
            }else {
                int value = map.get(allUserNames.get(i).getText());
                map.put(allUserNames.get(i).getText(), value+1);
            }
        }
        System.out.println(allTestNames);
        System.out.println(map);
    }



    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


}
