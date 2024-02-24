package selenium.soft_assert;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertShowCase {

    // example will be used in softAssert
    public int sum(int x, int y){
        return x + y;
    }

    @Test
    public void hardAssertTest(){
        Assert.assertEquals(sum(1,2), 2);// Hard Assert
        System.out.println("Code is working fine");

        Assert.assertEquals(sum(2,2), 4); //Hard Assert
        System.out.println("Code is working fine as expected");
    }

    @Test
    public void softAssertTest(){

        SoftAssert softAssert = new SoftAssert(); // created object

        softAssert.assertEquals(sum(1,2), 3); // Positive scenario
        System.out.println("Code is working fine");


        softAssert.assertEquals(sum(1,2), 6); // negative scenario
        System.out.println("Code is working fine, it supposed to be fail, but it will continue");

        softAssert.assertEquals(sum(5,5), 11);// negative scenario
        System.out.println("Code is working fine, it supposed to be fail, but it will continue");

        softAssert.assertAll("All failures are above"); // must have it so that you know where it failed during the test execution



    }



}
