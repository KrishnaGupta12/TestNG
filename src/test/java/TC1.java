import org.testng.annotations.*;

public class TC1 {

    @BeforeClass
    void beforeClass()
    {
        System.out.println("This Will Execute Before Start Class TC1");
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
    void test1()
    {
        System.out.println("This is Test 1 : Method ");
    }

    @Test
    void test2()
    {
        System.out.println("This is Test 2 :  Method ");
    }

    @BeforeTest
    void beforeTest()
    {
        System.out.println("This Will Execute Before Test");
    }

    @AfterTest
    void afterTest()
    {
        System.out.println("This Will Execute After Test :");
    }
}
