package selenium.data_provider;

import org.testng.annotations.DataProvider;

public class DataProviderSeparated {


    @DataProvider(name = "myData")
    public Object[][]getData(){

        return new Object[][]{

                {"Ibragim", "Aidar"},
                {"John", "Ganbaa"},
                {"Thomas","Shelby"}
                //Apache POI --> you will be able to implement this method
                // to read data from excell/json sheet
        };
    }
}
