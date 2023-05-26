package com;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestNumer1 
{
	WebDriver driver;
  @Test
  public void validateHomepageTitle() 
  {
	  System.out.println(driver.getTitle());
	  String actualTitle = driver.getTitle();
	  String expectedTitle;
	  
  }
  @BeforeMethod
  public void launchBrowser() 
  {
	  WebDriver driver = new ChromeDriver();
      driver.get("https://www.amazon.com/");
      driver.manage().window().maximize();
      driver.getTitle();
      System.out.println(driver.getTitle());
  }

  @AfterMethod
  public void afterMethod() {
  }

  public void method1() {
	  
  }
}
