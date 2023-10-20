package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class testNGParallelTestSuite {
	String testName = "";
	String browser = "";

	@Parameters({ "test-name","browser" })
	@BeforeTest
	public void beforeTest(String testName,String browserName) {
		this.testName = testName;
		browser=browserName;
		WebDriver driver;
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https:/google.co.in");
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get("https:/google.co.in");
		}
		
		long id = Thread.currentThread().getId();
		System.out.println("Before test " + testName + ". Thread id is: " + id);
	}

	@BeforeClass
	public void beforeClass() {
		long id = Thread.currentThread().getId();
		System.out.println("Before test-class " + testName + ". Thread id is: " + id);
	}

	@Test
	public void testMethodOne() {
		long id = Thread.currentThread().getId();
		System.out.println("Sample test-method " + testName + ". Thread id is: " + id);
	}

	@AfterClass
	public void afterClass() {
		long id = Thread.currentThread().getId();
		System.out.println("After test-class  " + testName + ". Thread id is: " + id);
	}

	@AfterTest
	public void afterTest() {
		long id = Thread.currentThread().getId();
		System.out.println("After test  " + testName + ". Thread id is: " + id);
	}

}
