package com.selenium;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testNgDataProvider {

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class executed");
	}


	
	@Test(priority = 3)
	public void testCase3() {
		System.out.println("inside testcase 3");
	}
	
	@Test(dataProvider = "dp2")
	public void mul(int a, int b) {
		System.out.println(a*b);
		
	}

	@Test(priority=0,dataProvider = "DP")
	public void display(String user,String pwd,String name,String email,String hobby) {

		System.out.println("user: " + user);
		System.out.println("pwd: " + pwd);
		System.out.println("name: " + name);
		System.out.println("email: " + email);
		System.out.println("hobby: " + hobby);

	}
	
	@DataProvider
	public Object[][] DP() {
		return new Object[][] {
				/*
				 * new Object[] { "user1"}, new Object[] { "user2"}, new Object[] { "user3" },
				 * new Object[] { "user4" }
				 */
				new Object[] { "user1", "pwd1", "gopal", "abc1@gmail.com", "cricket" },
				new Object[] { "user2", "pwd2", "krishna", "abc2@gmail.com", "movies" },
				new Object[] { "user3", "pwd3", "raghu", "abc3@gmail.com", "songs" },
				new Object[] { "user4", "pwd4", "naveen", "abc4@gmail.com", "chess" },
				new Object[] { "user5", "pwd4", "rahul", "abc5@gmail.com", "tennis" }
			};
	}
	
	@DataProvider
	public Object[][] dp2() {
		return new Object[][] {
				
				  new Object[] {4,5},
				  new Object[] {6,7}, 
				  new Object[] {9,19},
				  new Object[] {3,2}
				 
				
			};
	}
}
