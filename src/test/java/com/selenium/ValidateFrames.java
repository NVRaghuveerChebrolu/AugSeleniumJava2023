package com.selenium;

import org.testng.annotations.Test;

import com.POM.FramesPOM;
import com.utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateFrames extends Library {

	@Test(priority = 1)
	public void ValidateFramesURLPage() {
		System.out.println("inside ValidateFramesURLPage");
		driver.get(objProperties.getProperty("FramesURL"));
		Assert.assertEquals(driver.getTitle(), objProperties.getProperty("FramesTitle"));
	}

	@Test(priority = 2)
	public void ValidateSingleFrame() {
		System.out.println("inside ValidateSingleFrame");
		driver.switchTo().frame("SingleFrame");
		FramesPOM objFramesPOM = new FramesPOM(driver);
		objFramesPOM.SingleFrameTextBox.sendKeys(objProperties.getProperty("SingleFrameText"));
		driver.switchTo().defaultContent(); // to come out of the frame
		objFramesPOM.IframeWithInIframeButton.click();
	}

	@Test(priority = 3)
	public void ValidateMutipleFrames() {

		System.out.println("inside ValidateMutipleFrames");
		FramesPOM objFramesPOM = new FramesPOM(driver);
		driver.switchTo().frame(objFramesPOM.MutipleFrame);
		driver.switchTo().frame(objFramesPOM.iframeInsideMultipleFrame);
		objFramesPOM.SingleFrameTextBox.sendKeys("DoubleFrameText");
		driver.switchTo().defaultContent();// to come out of the frame
	}

	@Test(priority = 4)
	public void ValidateMutipleFramesofchecherUrlPage() {

		System.out.println("inside ValidateFramesURLPage");
		driver.get(objProperties.getProperty("chercherURL"));
		String title = driver.getTitle();
		System.out.println("Title f chercher:" + title);
		Assert.assertEquals(driver.getTitle(), objProperties.getProperty("checherTitle"));
	}

	@Test(priority = 5)
	public void ValidateMutipleFramesofChercher() throws InterruptedException {

		System.out.println("inside ValidateMutipleFrames chercher");

		FramesPOM objFramesPOM = new FramesPOM(driver);
		driver.switchTo().frame(objFramesPOM.chercheriframe1);
		objFramesPOM.SingleFrameTextBox.sendKeys(objProperties.getProperty("TopicTextBox"));
		driver.switchTo().frame(objFramesPOM.chercheriframe3);
		objFramesPOM.checkboxinframe3.click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(objFramesPOM.chercheriframe2);

		WebElement Animalsdropdown = driver.findElement(By.xpath("//*[@id='animals']"));
		Select s = new Select(Animalsdropdown);

		s.selectByVisibleText("Baby Cat");

	}

	@Test(priority = 6)
	public void ValidateHYRTutorialsFrame3() throws InterruptedException {

		System.out.println("inside ValidateHYRTutorialsFrames");
		driver.get(objProperties.getProperty("HYRTutorialsUrl"));
		Assert.assertEquals(driver.getTitle(), objProperties.getProperty("HyrtutorialTitle"));

		FramesPOM objFramesPOM = new FramesPOM(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", objFramesPOM.HYRTutorialFrame3);
		driver.switchTo().frame(objFramesPOM.HYRTutorialFrame3);

		driver.switchTo().frame(objFramesPOM.HYRTutorialFrame1);

		js.executeScript("arguments[0].scrollIntoView(true)", objFramesPOM.HYRTutorialdropdownframe1);

		Select s = new Select(objFramesPOM.HYRTutorialdropdownframe1);
		s.selectByValue("https://www.hyrtutorials.com/search/label/Tutorials");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		js.executeScript("arguments[0].scrollIntoView(true)", objFramesPOM.HYRTutorialFrame2);
		driver.switchTo().frame(objFramesPOM.HYRTutorialFrame2);
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true)", objFramesPOM.textboxFirstName);
		objFramesPOM.textboxFirstName.sendKeys(objProperties.getProperty("FirstName"));

		objFramesPOM.textboxFirstName.sendKeys(objProperties.getProperty("LastName"));
		objFramesPOM.RadiobtnGenderMale.click();
		objFramesPOM.checkboxhindiframe2.click();
		objFramesPOM.EmailIdFrame2.sendKeys(objProperties.getProperty("Emailframe2"));
		objFramesPOM.EnterPasswordInFrame2.sendKeys(objProperties.getProperty("passwordframe2"));

		objFramesPOM.regitrationbtninframe2.click();
		driver.switchTo().defaultContent();
		js.executeScript("arguments[0].scrollIntoView(true)", objFramesPOM.HYRTutorialFrame3);
		driver.switchTo().frame(objFramesPOM.HYRTutorialFrame3);
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
