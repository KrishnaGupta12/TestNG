import org.testng.annotations.Test;

public class GroupExample {

    @Test(groups = { "sanity"})
    void test1()
    {
        System.out.println("This is Test 1 Method");
    }
    @Test(groups = {"sanity"})
    void test2()
    {
        System.out.println("This is Test 2 Method");
    }
    @Test(groups = { "regression"})
    void test3()
    {
        System.out.println("This is Test 3 Method");
    }
    @Test(groups = { "regression"})
    void test4()
    {
        System.out.println("This is Test 4 Method");
    }
    @Test(groups = { "sanity","regression"})
    void test5()
    {
        System.out.println("This is Test 5 Method");
    }

}
