package TestNG_Exercise;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Skip {
  
@Test(enabled = false)
  public void Test1() 
  {
	  System.out.println("This is sample text test");
  }
	@Test
	public void Test2() 
	{
		  System.out.println("This is sample text test2");
	}
  @BeforeMethod
  public void printingName()
  {
	  System.out.println("Red");
  }
  public void printingPass() 
  {
	  System.out.println("12345");
  }
}
