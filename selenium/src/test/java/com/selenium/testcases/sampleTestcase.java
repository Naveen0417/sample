package com.selenium.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sampleTestcase {

	public static WebDriver driver;

	@BeforeClass
	public void launchBrowser() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("At BeforeClass");
	}

	@BeforeMethod
	public void Login() throws InterruptedException {

		driver.get("https://demo.guru99.com/v4");
		driver.findElement(By.name("uid")).sendKeys("mngr389730");
		driver.findElement(By.name("password")).sendKeys("EpUvytY");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("At BeforeMethod");
	}

	@Test
	public void getPageTitle() throws InterruptedException {
		Thread.sleep(3000);
		String PageTitle = driver.getTitle();
		Assert.assertEquals("Guru99 Bank Manager HomePage", PageTitle);
	}

	@AfterMethod
	public void logout() throws InterruptedException {		
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
		driver.switchTo().alert().accept();
		System.out.println("At AfterMethod");

	}

	@AfterClass
	public void closeBrowser() {

	driver.close();
	System.out.println("At AfterClass");

	}
	
}
