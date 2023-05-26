package com;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class TestNumber2 
{
	WebElement crtBtn, fstName, lstName, emailAdd, reenterEmail, pass, signUpBtn, gender ;
	Select  bMonth, bDay, bYear;
	WebDriverWait wait;
	WebDriver driver;
  @Test
  public void createAccount() 
  {

     
      
	  try {
          // Check if the sign-up was successful
          wait.until(ExpectedConditions.urlContains("confirmemail.php"));
          System.out.println("Registration successful!");
      } catch (Exception e) {
          // Print an error message if the sign-up failed
          System.out.println("Registration failed due to incorrect credentials.");
      } finally {
    	  
      }

  }
  @BeforeMethod
  public void launchBrowser() 
  {
	  WebDriver driver = new ChromeDriver();
      driver.get("https://www.facebook.com/");
      driver.manage().window().maximize();
      
      crtBtn = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
      crtBtn.click();
      
      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='firstname']")));

      fstName = driver.findElement(By.xpath("//input[@name='firstname']"));
      fstName.sendKeys("Red");
      lstName = driver.findElement(By.xpath("//input[@name='lastname']"));
      lstName.sendKeys("Blue");

      emailAdd = driver.findElement(By.xpath("//input[@name='reg_email__']"));
      emailAdd.sendKeys("sample@example.com");
      
      reenterEmail = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
      reenterEmail.sendKeys(emailAdd.getAttribute("value"));

      pass = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
      pass.sendKeys("password123");

      bMonth = new Select(driver.findElement(By.xpath("//select[@name='birthday_month']")));
      bMonth.selectByValue("3");

      bDay = new Select(driver.findElement(By.xpath("//select[@name='birthday_day']")));
      bDay.selectByValue("31");

      bYear = new Select(driver.findElement(By.xpath("//select[@name='birthday_year']")));
      bYear.selectByValue("2012");

      gender = driver.findElement(By.xpath("//input[@value='2']"));
      gender.click();
      
      signUpBtn = driver.findElement(By.xpath("//button[@name='websubmit']"));
      signUpBtn.click();

  }

  @AfterMethod
  public void afterMethod() 
  {
	  driver.close();
	  driver.quit();
  }

}
