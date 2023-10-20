package com.selenium;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNgParallelClass3 {
  @Test
  public void test() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Class3 : inside test case. Thread id is: " + id);
	  System.out.println("inside test");
  }
  @BeforeClass
  public void beforeClass() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Class3 : inside Before class. Thread id is: " + id);
	  System.out.println("inside before class");
  }

  @AfterClass
  public void afterClass() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Class3 : inside after class. Thread id is: " + id);
	  System.out.println("inside after class");
  }

}
