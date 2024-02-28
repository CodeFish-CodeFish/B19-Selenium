package selenium.data_provider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderShowCase {


    // This dataProvider can be also located in different class
//    @DataProvider(name = "myData")
//    public Object[][]getData(){
//
//        return new Object[][]{
//
//                {"Ibragim", "Aidar"},
//                {"John", "Ganbaa"},
//                {"Thomas","Shelby"}
//                //Apache POI --> you will be able to implement this method
//                // to read data from excell/json sheet
//        };
//    }


    /*
    Frameworks - TDD - basically testNG framework
                 DDD - Data Driven Development
     */

    @Test(dataProvider = "myData", dataProviderClass = DataProviderSeparated.class)
    public void testDataProvider(String name1, String name2){

        System.out.println(name1 +" "+ name2);

    }

}
