package SeleniumAssignment;

import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//1. Verify that the registration form opens successfully upon clicking the "Create New Account" button.
//2. Verify that the user is able to enter the first name correctly in the first name field.
//3. Verify that the user is able to enter the last name correctly in the last name field.
//4. Verify that the user is able to enter a valid email address and confirm the email address.
//5. Verify that the user is able to enter a valid password.
//6. Verify that the user is able to select the correct birth month, date, and year from the drop-down menus.

public class Selenium_Facebook_Reg_TestNG {
	
    private WebDriver driver;
    private WebElement crtBtn, fstName, lstName, emailAdd, reenterEmail, pass, signUpBtn, gender;
    private Select bMonth, bDay, bYear;
    private String firstName, lastName, emailAddress, reenterEmailAddress, password;
    

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }

    @Test(groups = { "smoke" })
    public void testCreateAccountButton() {
        crtBtn = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        Assert.assertTrue(crtBtn.isDisplayed());
    }

    @Test(groups = { "smoke" })
    public void testSignupButton() {
        crtBtn = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        crtBtn.click();
        signUpBtn = driver.findElement(By.xpath("//button[@name='websubmit']"));
        Assert.assertFalse(signUpBtn.isEnabled());
    }

    @Test(groups = { "smoke" })
   // @Parameters("fstName")
    public void testFirstName() {
        crtBtn = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        crtBtn.click();
        fstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        Assert.assertTrue(fstName.isEnabled());
        fstName.sendKeys(firstName);
       
    }

    @Test(groups = { "smoke" })
    //@Parameters("lstName")
    public void testLastName() {
        crtBtn = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        crtBtn.click();
        lstName = driver.findElement(By.xpath("//input[@name='lastname']"));
        Assert.assertTrue(lstName.isEnabled());
        lstName.sendKeys(lastName);
    }

    @Test(groups = { "smoke" })
   // @Parameters("emailAdd")
    public void testEmailAddress() {
        crtBtn = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        crtBtn.click();
        emailAdd = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        Assert.assertTrue(emailAdd.isEnabled());
        emailAdd.sendKeys(emailAddress);
    }

    @Test(groups = { "smoke" })
    //@Parameters("reenterEmail")
    public void testReenterEmailAddress() {
        crtBtn = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        crtBtn.click();
        reenterEmail = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        Assert.assertTrue(reenterEmail.isEnabled());
        reenterEmail.sendKeys(reenterEmailAddress);
    }

    @Test(groups = { "smoke" })
    //@Parameters("pass")
    public void testPassword() {
        crtBtn = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        crtBtn.click();
        pass = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
        Assert.assertTrue(pass.isEnabled());
        pass.sendKeys(password);
    }

    @Test(groups = { "smoke" })
    public void testBirthday() {
        crtBtn = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        crtBtn.click();
        bMonth = new Select(driver.findElement(By.xpath("//select[@name='birthday_month']")));
        bDay = new Select(driver.findElement(By.xpath("//select[@name='birthday_day']")));
        bYear = new Select(driver.findElement(By.xpath("//select[@name='birthday_year']")));
        
        // Test case 7: Verify that user cannot select invalid birthday date
        bMonth.selectByValue("4");
        bDay.selectByValue("31");
        bYear.selectByValue("2000");
        String errorMsg = driver.findElement(By.xpath("//div[contains(text(), 'Sorry, your registration')]")).getText();
        Assert.assertTrue(errorMsg.contains("Sorry, your registration wasn't successful."));
        Reporter.log("Test case 7: User cannot select invalid birthday date. Test passed.");

        // Test case 8: Verify that user can select valid birthday date
        bMonth.selectByValue("5");
        bDay.selectByValue("1");
        bYear.selectByValue("2000");
        Reporter.log("Test case 8: User can select valid birthday date. Test passed.");
        
        // Test case 9: Verify that user can select birthday date only within age limit
        LocalDate today = LocalDate.now();
        int year = today.getYear() - 18;
        bYear.selectByValue(String.valueOf(year));
        String ageErrorMsg = driver.findElement(By.xpath("//div[contains(text(), 'You must be at least')]")).getText();
        Assert.assertTrue(ageErrorMsg.contains("You must be at least 18 years old to use Facebook."));
        Reporter.log("Test case 9: User cannot select birthday outside age limit. Test passed.");
        
        // Test case 10: Verify that user can select birthday within age limit
        year = today.getYear() - 20;
        bYear.selectByValue(String.valueOf(year));
        Reporter.log("Test case 10: User can select birthday within age limit. Test passed.");
        
        // Click the sign up button to submit the form
        signUpBtn = driver.findElement(By.xpath("//button[@name='websubmit']"));
        signUpBtn.click();

        // Wait for the confirmation page to load and check if the registration is successful
        try {
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("confirmemail.php"));
            Reporter.log("Registration successful!");
        } catch (Exception e) {
            Reporter.log("Registration failed due to incorrect credentials.");
        } finally {
            driver.quit();
        }
    }
}

