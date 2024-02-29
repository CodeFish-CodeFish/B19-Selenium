package selenium.com.blaze.tests;

import org.testng.annotations.DataProvider;

public class BlazeTestData {

    @DataProvider(name = "mockData")
    public Object[][] getDAta() {

        return new Object[][]{

                {"John Wick", "USA", "New York", "123456789", "12", "2027","Thank you for your purchase!"}

        };
    }


}
