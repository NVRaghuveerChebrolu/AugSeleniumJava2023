package com.selenium;

import org.testng.annotations.Test;

import com.POM.DropDown_Calender;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateDropDownsAndCalender extends Library {

	@Test(priority = 1)
	public void ValidateToolsQAPractiseFormPaeLoaded() throws IOException {
		System.out.println("inside ValidateToolsQAPractiseFormPaeLoaded");
		driver.get(objProperties.getProperty("DropDownUrl"));
		PageLoadTimeOut(20);
		String title = driver.getTitle();
		System.out.println("title:" + title);
		Assert.assertEquals(title, objProperties.getProperty("TitleOfToolsQA"));

	}

	@Test(priority = 2)
	public void ValidateCalender() {
		System.out.println("inside ValidateCalender");
		DropDown_Calender objDropDown_Cal = new DropDown_Calender(driver);
		ScrollDownByPixles(300);
		objDropDown_Cal.DOB.click();
		Select objSelect = new Select(objDropDown_Cal.Month);
		objSelect.selectByVisibleText(objProperties.getProperty("DropDownMonth"));
		
		Select objSelect1 = new Select(objDropDown_Cal.Year);
		objSelect1.selectByValue(objProperties.getProperty("DropDownYear"));
		
		int NumberOfDays = objDropDown_Cal.AllDays.size();
		for(int Day=1;Day<=NumberOfDays;Day++) {
			String InvidualDay =  objDropDown_Cal.AllDays.get(Day).getText();
			if(InvidualDay.equals(objProperties.getProperty("DropDownDay"))) {
				Actions objActions = new Actions(driver);
				objActions.click(objDropDown_Cal.AllDays.get(Day)).click().build().perform();
						//objDropDown_Cal.AllDays.get(Day).click();
				break;
			}	
		}
		System.out.println("came out of for loop");
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
