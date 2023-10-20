package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgParallelClass2 {
	WebDriver driver;
	@BeforeClass
	public void beforeClass() {
		long id = Thread.currentThread().getId();
		System.out.println("Class2 : inside Before class. Thread id is: " + id);
		WebDriverManager.chromedriver().setup();
		
		driver= new ChromeDriver();
		driver.get("https://www.google.co.in/");
	}

	@Test
	public void testMethodOne() {
		long id = Thread.currentThread().getId();
		System.out.println("Class2 : inside testMethodOne. Thread id is: " + id);
	}

	@Test
	public void testMethodTwo() {
		long id = Thread.currentThread().getId();
		System.out.println("Class2 : inside testMethodTwo. Thread id is: " + id);
	}

	@AfterClass
    public void afterClass() {
        long id = Thread.currentThread().getId();
        System.out.println("Class2 : inside After class. Thread id is: " + id);
      //  driver.close();
	}
}
