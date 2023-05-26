package TestNG_Exercise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_Assert {
  @Test
  public void add() 
  {
	  int result = 4 + 4;
      Assert.assertEquals(result, 12, "The addition result is incorrect");
  }
  @Test
  public void subtract() {
      int result = 5 - 3;
      Assert.assertTrue(result > 0, "The subtraction result is negative or zero");
  }
  
  @Test
  public void multiplication() {
      int result = 2 * 3;
      Assert.assertNotEquals(result, 5, "The multiplication result is equal to 5");
  }
  
  @Test(expectedExceptions = ArithmeticException.class)
  public void testDivision() {
      int dividend = 10;
      int divisor = 0;
      try {
          int result = dividend / divisor;
      } catch (ArithmeticException e) {
          System.out.println("Caught exception: " + e.getMessage());
          throw e;
      }
  }
}
