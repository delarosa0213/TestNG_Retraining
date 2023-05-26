package TestNG_Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(customListener.class)
public class Listener_Test {
    private WebDriver driver;

    @Test
    public void testTitle() {
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        Reporter.log(expectedTitle);
        Reporter.log("Actual Title: " + actualTitle);

        
       
    }
    @Test
    public void testSearch() {
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("TestNG");
        driver.findElement(By.name("btnK")).click();
        String expectedTitle = "TestNG - Google Search";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        Reporter.log(expectedTitle);
        Reporter.log("Actual Title after search: " + actualTitle);
        driver.quit();
    }
}

