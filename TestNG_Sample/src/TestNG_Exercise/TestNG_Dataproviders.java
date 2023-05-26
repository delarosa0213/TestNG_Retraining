package TestNG_Exercise;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TestNG_Dataproviders {
	@DataProvider(name = "numbers")
    public Object[][] createNumbers() {
        return new Object[][] {
            {2, 2, 4},
            {5, 3, 8},
            {4, -2, 2},
            {10, 10, 10}
        };
    }
    
    @Test(dataProvider = "numbers")
    public void testAddition(int a, int b, int expected) {
        int result = a + b;
        Assert.assertEquals(result, expected, "The addition result is incorrect");
    }
}
