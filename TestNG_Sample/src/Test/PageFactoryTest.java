package Test;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import common.ConfigFileReader;

public class PageFactoryTest {
    private WebDriver driver;
    private ConfigFileReader config;

    @BeforeTest
    public void setUp() {
        // Initialize the configuration reader
        config = new ConfigFileReader();

        // Create a new ChromeDriver instance
        driver = new ChromeDriver();

        // Navigate to Google.com
        String url = config.getValue("url");
        driver.get(url);
    }

    @Test
    public void testPageFactory() {
        // Create an instance of GooglePage using PageFactory
        GooglePage googlePage = PageFactory.initElements(driver, GooglePage.class);

        // Get the new search term from the configuration file
        String searchTerm = config.getValue("search");

        // Perform a search for the new search term
        googlePage.performSearch(searchTerm);

        // Get the page title and print it to the console
        String pageTitle = driver.getTitle();
        System.out.println("Page title: " + pageTitle);
    }

    @AfterTest
    public void tearDown() {
        // Quit the browser
        driver.quit();
    }

    public static class GooglePage {
        private WebDriver driver;

        public GooglePage(WebDriver driver) {
            this.driver = driver;
        }

        public void performSearch(String searchTerm) {
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys(searchTerm);
            searchBox.submit();
        }
    }
}
