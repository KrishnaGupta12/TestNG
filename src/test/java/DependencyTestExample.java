import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.TestRunner.PriorityWeight.dependsOnMethods;

public class DependencyTestExample {
    @Test
    void startCar()
    {
        System.out.println("Car Started");
        Assert.fail();
    }
    @Test(dependsOnMethods= {"startCar"})
    void driveCar()
    {
        System.out.println("Drive Started");
    }
    @Test(dependsOnMethods = {"driveCar"})
    void stopCar(){
        System.out.println("Car stopped");
    }

    @Test(dependsOnMethods = {"driveCar","stopCar"},alwaysRun = true)
    void carParked()
    {
        System.out.println("Car Parked");
    }

}
