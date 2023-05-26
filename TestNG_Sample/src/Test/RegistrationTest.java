package Test;

import org.testng.annotations.Test;

import pages.RegistrationPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationTest {
    
    private WebDriver driver;
    private pages.RegistrationPage registrationPage;
    
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/index.php");
        registrationPage = new RegistrationPage(driver);
    }
    
    @Test
    public void testRegistration() {
        registrationPage.fillRegistrationForm("John", "Doe", "1234567890", "johndoe@email.com",
                "123 Main St", "New York", "NY", "12345", "UNITED STATES", 
                "johndoe123", "password", "password");
    }
    
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    
}
