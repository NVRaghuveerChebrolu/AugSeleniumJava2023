package com.selenium;

import org.testng.annotations.Test;

import com.POM.AlertsPOM;
import com.utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	  Alert objAlert = driver.switchTo().alert();
	  String  title = objAlert.getText();
	  Assert.assertEquals(title, objProperties.getProperty("NormalAlertTitle"));
	  objAlert.accept();
  }
  
  @Test(priority=0)
  public void ValidateTimerAlert() {
	  System.out.println("inside ValidateTimerAlert");
	  AlertsPOM objAlertspom = new AlertsPOM(driver);
	  objAlertspom.TimerAlert.click();
	  
	  //Explicit Wait : Applicable for one webElement for a specified time duration based on the condition
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	  wait.until(ExpectedConditions.alertIsPresent());
	  
	  Alert objAlert = driver.switchTo().alert();
	  String  title = objAlert.getText();
	  Assert.assertEquals(title, objProperties.getProperty("TimerAlertTitle"));
	  objAlert.accept();
	  
  }
  
  @Test(priority=1)
  public void ValidateConfirmBoxAlert() {
	  System.out.println("inside ValidateConfirmBoxAlert");
	  AlertsPOM objAlertsPOM = new AlertsPOM(driver);
	  objAlertsPOM.ConfirmALert.click();
	  Alert objAlert = driver.switchTo().alert();
	  Assert.assertEquals(objAlert.getText(), objProperties.getProperty("ConfirmBoxAlertTitle"));
	  objAlert.dismiss();
	  String ConfirmAlertMessage = objAlertsPOM.ConfirmResult.getText();
	  Assert.assertEquals(ConfirmAlertMessage, objProperties.getProperty("ConfimrBoxAlertMessage"));
  }
  
  @Test(priority=2)
  public void ValidatePromptBoxAlert() {
	  System.out.println("inside ValidatePromptBoxAlert");
	  AlertsPOM objAlertsPOM = new AlertsPOM(driver);
	  objAlertsPOM.PromptAlert.click();
	  Alert objAlert = driver.switchTo().alert();
	  Assert.assertEquals(objAlert.getText(),objProperties.getProperty("PromptAlertMessage"));
	  objAlert.sendKeys(objProperties.getProperty("PromptAlertText"));
	  objAlert.accept();
	  String PromptBoxMessage = objAlertsPOM.promptResult.getText();
	  Assert.assertEquals(PromptBoxMessage, objProperties.getProperty("PromptAlertResult"));

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
