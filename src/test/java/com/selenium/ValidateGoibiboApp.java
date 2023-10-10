package com.selenium;

import org.testng.annotations.Test;

import com.POM.DropDown_Calender;
import com.POM.FramesPOM;
import com.POM.GoibiboPOM;
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
import org.openqa.selenium.devtools.v113.input.Input.DispatchKeyEventType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class ValidateGoibiboApp extends Library {

	@Test(priority = 1)
	public void ValidateGoibiboLoadedSuccessfully() throws IOException {
		System.out.println("inside ValidateGoibiboLoadedSuccessfully");
		driver.get(objProperties.getProperty("goibiboURL"));
		PageLoadTimeOut(20);
		String title = driver.getTitle();
		System.out.println("title:" + title);
		Assert.assertEquals(title, objProperties.getProperty("goibiboTitle"));
	}

	
	@Parameters({ "FareType", "TripType" , "Source" , "Destination"})
	@Test(priority=2)
	public void ValidateE2EforFlights(String FareType,String TripType,String Source, String Destination) throws AWTException, InterruptedException {
		GoibiboPOM objgoibibo_POM = new GoibiboPOM(driver);
		objgoibibo_POM.LoginPopUpClose.click();
		SelectRespectiveTripType(TripType);
		SelectRespectiveFareType(FareType);
		objgoibibo_POM.DoneButton.click();
		boolean AddIcon = objgoibibo_POM.closeIconGoibiboAdd.isDisplayed();
		if(AddIcon=true) {
		objgoibibo_POM.closeIconGoibiboAdd.click();
		}
		objgoibibo_POM.From_EnterCityOrAirport.click();
		objgoibibo_POM.TextBox.sendKeys(Source);
		Robot obRobot = new Robot();
		Thread.sleep(2000);
		obRobot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		obRobot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(4000);
		objgoibibo_POM.TextBox.sendKeys(Destination);
		Thread.sleep(2000);
		obRobot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		obRobot.keyRelease(KeyEvent.VK_ENTER);
		
	}

//	@DataProvider
//	public Object[][] SourceAndDestination() {
//		return new Object[][] {
//				new Object[] { "BLR", "DEL",},
//				new Object[] { "MAA", "ARN", },
//			};
//	}

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
		StartExtentReport();
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
