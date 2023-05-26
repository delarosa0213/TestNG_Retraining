package TestNG_Exercise;

import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class TestNG_Parameters {
	@Test
    @Parameters({"username", "password"})
    public void testLogin(String username, String password) {
        System.out.println("Logged using username: " + username + " and password: " + password);
    }
}
