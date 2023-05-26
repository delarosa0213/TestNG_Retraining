package TestNG_Exercise;

import org.testng.annotations.Test;

public class TestNG_Dependency {
	@Test
    public void testOne() 
	{
        System.out.println("This is Test One");
    }
    
    @Test(dependsOnMethods = {"testOne"})
    public void testTwo() 
    {
        System.out.println("This is Test Two");
    }
    
    @Test(dependsOnMethods = {"testTwo"})
    public void testThree() 
    {
        System.out.println("This is Test Three");
    }
}
