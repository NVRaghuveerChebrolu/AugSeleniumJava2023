package com.selenium;

import org.testng.annotations.Test;

import com.POM.FramesPOM;
import com.POM.MouseOperationsPagePOM;
import com.POM.WindowsPOM;
import com.utility.Library;

import dev.failsafe.internal.util.Durations;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateMultipleWindows extends Library{
  
	@Test (priority=1)
	public void ValidateNxtGenAIacademyTitle() throws IOException {
		System.out.println("inside ValidateRightClickOperations");
		driver.get(objProperties.getProperty("nxtgenaiacademyURL"));
		PageLoadTimeOut(60);
		String title = driver.getTitle();
		System.out.println("title:"+title);
		Assert.assertEquals(title, objProperties.getProperty("nxtgenaiacademyTitle"));
		
	}
	
	@Test(priority=2)
	public void ValidateNewBrowserWindow() {
		System.out.println("inside ValidateNewBrowserWindow");
		WindowsPOM objWinPOM = new WindowsPOM(driver);
		String MainWindow = driver.getWindowHandle();
		objWinPOM.NewBrowserWindowButton.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> AllWindows = driver.getWindowHandles();
		for(String IndividualWindow:AllWindows) {
			driver.switchTo().window(IndividualWindow);
			String title = driver.getTitle();
			System.out.println("title:"+title);
			if(title.equalsIgnoreCase(objProperties.getProperty("newBrowserWindowTitle"))) {
				objWinPOM.MenuOfNewBrowserWindow.click();
				ScrollDownByPixles(100);
				objWinPOM.AboutMeOfNewBrowserWindow.click();
				String TextUnderAboutMe = objWinPOM.TechTalkUnderAboutMe.getText();
				System.out.println("TextUnderAboutMe:"+TextUnderAboutMe);
				Assert.assertEquals(TextUnderAboutMe,objProperties.getProperty("TechTalkInNewBrowserWindow"));
				driver.close();//close the browser window where driver is currently active
				//break;
			}
		}
		driver.switchTo().window(MainWindow);
		
		
	}
	
	
	
	
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("inside beforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("inside afterMethod");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("inside beforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("inside afterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("inside beforeTest");
	  LaunchBroswer();
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("inside afterTest");
  }

  @BeforeSuite
  public void beforeSuite() throws IOException {
	  System.out.println("inside beforeSuite");
	  ReadPropetiesFile();
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("inside afterSuite");
  }
  
  

}
