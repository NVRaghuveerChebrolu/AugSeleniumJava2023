package com.selenium;

import org.testng.annotations.Test;

import com.POM.AlertsPOM;
import com.utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateAlerts extends Library{
	
  @Test(priority=-3)
  public void LaunchToolsQAApplicationAlertsPage() {
	  System.out.println("inside LaunchToolsQAApplicationAlertsPage");
	  driver.get(objProperties.getProperty("AlertsUrl"));
	  String title = driver.getTitle();
	  Assert.assertEquals(title, objProperties.getProperty("AlertPageTitle"));
  }
  
  @Test(priority=-1)
  public void ValidateNormalAlert() {
	  System.out.println("inside ValidateNormalAlert");
	  //driver.findElement(By.id("alertButton")).click();
	  AlertsPOM objAlertspom = new AlertsPOM(driver);
	  objAlertspom.NormalAlert.click();
	  
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
