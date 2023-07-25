package com.automation.GmailLogin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GmailLogin {
	
	WebDriver driver;
	
	@BeforeSuite
	public void Setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		}
	@Test
	public void Login() {
		driver.get("http://gmail.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//div[@id='identifierNext']")).click();
		
	//	driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("abc");
		driver.findElement(By.xpath("//div[@id='passwordNext']")).click();	
	
	}
	
	@AfterSuite
	public void quit() {
		driver.quit();
	}
}
