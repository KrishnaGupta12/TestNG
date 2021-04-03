import org.testng.annotations.*;

public class TC2 {

    @BeforeClass
    void beforeClass()
    {
        System.out.println("This Will Execute Before Start Class TC2");
    }

    @AfterClass
    void afterClass()
    {
        System.out.println("This will Execute After Completion  Every Class");
    }

    @BeforeMethod
    void beforeMethod()
    {
        System.out.println("This will Execute Before Every Method ");
    }
    @AfterMethod
    void afterMethod()
    {
        System.out.println("This Method will Execute after completion of every Method");
    }


    @Test
    void test3()
    {
        System.out.println("This is Test 3 : Method ");
    }

    @Test
    void test4()
    {
        System.out.println("This is Test 4 :  Method ");
    }
    @BeforeSuite
    void beforeSuite()
    {
        System.out.println("This will Execute Before Suite");
    }
    @AfterSuite
    void afterSuite()
    {
        System.out.println("This Will ExeCute After Completion of Suite");
    }
}
