package com.selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class TestNgAnnotations {
  @Test(priority=-6)
  public void TestCase1() {
	  System.out.println("inside TestCase1");
  }
  
  
  @Test(priority=0,groups = {"sanity"})
  public void TestCase2() {
	  System.out.println("inside TestCase2");
  }
  
  @Test
  public void testCase3() {
	  System.out.println("inside testCase3");
  }
  
  @Test(priority=-32)
  public void tEstcase4() {
	  System.out.println("inside tEstcase4");
  }
  
  @Test(priority=-4,invocationCount=7)
  public void TestCase5() {
	  System.out.println("inside TestCase5");
  }
  
  @Test
  public void TestCase6() {
	  System.out.println("inside TestCase6");
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
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("inside afterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("inside beforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("inside afterSuite");
  }

}
