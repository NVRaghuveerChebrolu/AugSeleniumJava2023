package com.selenium;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class TestNgFactory {
	private String user = "";
	private String pwd = "";
	
	public TestNgFactory(String user,String pwd) {
		this.user = user;
		this.pwd = pwd;
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println(java.time.LocalDateTime.now());
		long id = Thread.currentThread().getId();
		System.out.println("Before beforeClass executed. "+id);
	}

	@Test
	public void testMethod1() {
		System.out.println(java.time.LocalDateTime.now());
		long id = Thread.currentThread().getId();
		System.out.println("testMethod1 parameter value is: " + user+" "+id);
		System.out.println("testMethod1 parameter value is: " + pwd+" "+id);
	}
	
	@Test
	public void testMethod2() {
		System.out.println(java.time.LocalDateTime.now());
		long id = Thread.currentThread().getId();
		System.out.println("testMethod2 is not accepting parameters "+id);
	}
	
	@Test
	public void testMethod3() {
		System.out.println(java.time.LocalDateTime.now());
		long id = Thread.currentThread().getId();
		System.out.println("testMethod3 parameter value is: " + user+" "+id);
		System.out.println("testMethod3 parameter value is: " + pwd+" "+id);
	}

	@Factory
	public static Object[] Raghu() {
		return new Object[] {  
				new TestNgFactory("user1","pwd1"),
				new TestNgFactory("user2","pwd2")
			//	new TestNgFactory("user3","pwd3")
//				new TestNgFactory("raghuveer"),
//				new TestNgFactory("selenium") 
				};
	}
}
