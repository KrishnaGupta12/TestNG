import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class SecondTestCase {
    @Test(priority = 1)
    void setUp()
    {
        System.out.println("Opening Browsers ");
    }
    @Test(priority = 3)
    void searchCustomer()
    {
        System.out.println("This is Search Customer Test");
    }
    @Test(priority =2)
    void addCustomer()
    {
        System.out.println("This is Add a New Customer Test");
        Assert.assertEquals(1,1);
    }
    @Test(priority =4)
    void tearDown()
    {
        System.out.println("Close all Opened Browser ");
    }
}
