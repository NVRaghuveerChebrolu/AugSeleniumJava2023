package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGParameters {

	@Parameters({ "Browser_Name" })
	@Test
	public void OpenBrowser(String BrowserName) {
		System.out.println("inside test method");
		System.out.println("browser passed as :- " + BrowserName);
		WebDriver driver= null;
	
		if(BrowserName.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(BrowserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("inside firefox");
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Parameters({ "UserName", "Passcode" })
	@Test
	public void FillLoginForm(String User, String Password) {
		System.out.println("Parameter for User Name passed as :- " + User);
		System.out.println("Parameter for Passcode passed as :- " + Password);
	}
	
	@Parameters({"email"})
	@Test(priority=1)
	public void testCaseforEmail(String mail) {
		System.out.println(mail);
	}
	
	@Test
	public void tesCaseWithOutParamter() {
		System.out.println("inside tesCaseWithOutParamter");
	}
	
	@Parameters({ "Browser_Name" })
	@BeforeSuite
	public void beforeSuite(String browser) {
		System.out.println("inside beforeSuite");
		System.out.println("browser passed as :- "+browser);
	}
}
