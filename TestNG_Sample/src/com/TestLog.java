package com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLog {
	
	public static void launchChrome() {
	
	WebDriver driver;
	
    driver = new ChromeDriver();
    driver.manage().window().maximize();

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
    driver.get("https://www.edureka.co/login");

    WebElement btnLogIn = driver.findElement(By.xpath("//header/nav[1]/ul[1]/li[4]/span[1]"));
    btnLogIn.click();

}
	public static void maib (String [] args) {
		launchChrome();
	}

}