package com.selenium;

import org.testng.annotations.Test;

import com.POM.FramesPOM;
import com.utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateFrames extends Library{
  
	
	@Test(priority=1)
  public void ValidateFramesURLPage() {
		System.out.println("inside ValidateFramesURLPage");
		driver.get(objProperties.getProperty("FramesURL"));
		Assert.assertEquals(driver.getTitle(), objProperties.getProperty("FramesTitle"));
  }
	
	@Test(priority=2)
	public void ValidateSingleFrame() {
		System.out.println("inside ValidateSingleFrame");
		driver.switchTo().frame("SingleFrame");
		FramesPOM objFramesPOM = new FramesPOM(driver);
		objFramesPOM.SingleFrameTextBox.sendKeys(objProperties.getProperty("SingleFrameText"));
		driver.switchTo().defaultContent(); //to come out of the frame
		objFramesPOM.IframeWithInIframeButton.click();
	}
	
	@Test(priority=3)
	public void ValidateMutipleFrames() {
		
		System.out.println("inside ValidateMutipleFrames");
		FramesPOM objFramesPOM = new FramesPOM(driver);
		driver.switchTo().frame(objFramesPOM.MutipleFrame);
		driver.switchTo().frame(objFramesPOM.iframeInsideMultipleFrame);
		objFramesPOM.SingleFrameTextBox.sendKeys("DoubleFrameText");
		driver.switchTo().defaultContent();//to come out of the frame
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
