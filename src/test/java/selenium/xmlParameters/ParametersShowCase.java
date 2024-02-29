package selenium.xmlParameters;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersShowCase {

    @Parameters({"firstName", "lastName"})

    @Test
    public void testParameters(String firstName, String lastName){
        System.out.println(firstName + " " + lastName);
    }

    @Parameters({"address","city"})
    @Test
    public void test2(String address, String city){
        System.out.println(address + " " + city);
    }

}
