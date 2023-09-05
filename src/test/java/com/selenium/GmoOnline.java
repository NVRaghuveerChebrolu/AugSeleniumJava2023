package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmoOnline {
	public static WebDriver driver;
	public static void main(String[] args) {
//		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.borland.com/gmopost/");
		String title = driver.getTitle();
		System.out.println("title:"+title);
		driver.findElement(By.name("bSubmit")).click();
		driver.findElement(By.name("QTY_GLASSES")).sendKeys("4");
		driver.findElement(By.name("bSubmit")).click();
		String UnitPriceOfSunGlasses = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/div/center/table/tbody/tr[2]/td[4]")).getText();
		System.out.println("UnitPriceOfSunGlasses using Absolute Xpath:"+UnitPriceOfSunGlasses);
		
		String UnitPriceOfSunGlasses1 = driver.findElement(By.xpath("//table[@cellpadding='4' and @border='1']/tbody/tr[2]/td[4]")).getText();
		System.out.println("UnitPriceOfSunGlasses using Relative Xpath:"+UnitPriceOfSunGlasses1);
		
		//table[@cellpadding='4' and @border='1']/tbody/tr[2]/td[4]
	}

}
