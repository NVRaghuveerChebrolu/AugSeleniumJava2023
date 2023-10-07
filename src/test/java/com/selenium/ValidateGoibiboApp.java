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

	
	@Parameters({ "FareType", "TripType" })
	@Test(priority=2,dataProvider= "SourceAndDestination")
	public void ValidateE2EforFlights(String FareType,String TripType,String Source, String Destination) {
		SelectRespectiveTripType(TripType);
		SelectRespectiveFareType(FareType);
		GoibiboPOM objgoibibo_POM = new GoibiboPOM(driver);
		objgoibibo_POM.From_EnterCityOrAirport.sendKeys(Source);
		objgoibibo_POM.To_EnterCityOrAirport.sendKeys(Destination);
	}

	@DataProvider
	public Object[][] SourceAndDestination() {
		return new Object[][] {
				
				new Object[] { "BLR", "DEL",},
				new Object[] { "MAA", "ARN", },
			
			};
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
