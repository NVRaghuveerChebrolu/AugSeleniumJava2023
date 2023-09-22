package com.selenium;

import org.testng.annotations.Test;

import com.POM.FramesPOM;
import com.POM.MouseOperationsPagePOM;
import com.utility.Library;

import dev.failsafe.internal.util.Durations;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateMouseOperations extends Library{
  
	@Test (priority=1)
	public void ValidateRightClickOperations() {
		System.out.println("inside ValidateRightClickOperations");
		driver.get(objProperties.getProperty("mouseOpeartionRightClick"));
		PageLoadTimeOut(60);
		String title = driver.getTitle();
		Assert.assertEquals(title, objProperties.getProperty("JQeryTitle"));
		MouseOperationsPagePOM objMOPOM= new MouseOperationsPagePOM(driver);
		objMOPOM.RightClickOnRightClickMeButton();
		objMOPOM.ClickOnEdit();
		Alert objAlert =driver.switchTo().alert();
		Assert.assertEquals(objAlert.getText(), objProperties.getProperty("mouseOpeartionRightclick_Edit"));
		objAlert.accept();
		
	}
	
	@Test(priority=2)
	public void ValidateDoubleClickOperations() {
		System.out.println("inside ValidateDoubleClickOperations");
		driver.navigate().to(objProperties.getProperty("mouseOpeartionDoubleClick"));
		PageLoadTimeOut(60);
		MouseOperationsPagePOM objMOPOM= new MouseOperationsPagePOM(driver);
		WebElement element = objMOPOM.iframe;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,540)", "");//to perform Scroll Down
		//js.executeScript("window.scrollBy(0,-250)", "");//to perform Scroll Up
		//js.executeScript("window.scrollBy(540,0)", "");//to perform Scroll Right
		//js.executeScript("window.scrollBy(-430,0)", "");//to perform Scroll Left
		js.executeScript("arguments[0].scrollIntoView();",element);
		driver.switchTo().frame(element);
		Actions obj = new Actions(driver);
		obj.doubleClick(objMOPOM.DoubleClickBox).build().perform();
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
