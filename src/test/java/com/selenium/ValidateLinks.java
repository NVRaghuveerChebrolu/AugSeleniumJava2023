package com.selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.POM.FlipKartPOM;
import com.POM.LinksPOM;
import com.utility.Library;



//using single inheritance 
public class ValidateLinks extends Library {
	
	@Test(priority=1)
	public void ValidateWLinksinToolsQA() throws IOException {
		System.out.println("inside ValidateWLinksinToolsQA");
		driver.get(objProperties.getProperty("BrokenlinksImages"));
		//using over riding which is also called as Run Time Polymorphism
		PageLoadTimeOut();
		LinksPOM obj = new LinksPOM(driver);
		for (int i=0 ; i<obj.AllLinks.size();i++) {
			String URL = obj.AllLinks.get(i).getAttribute("href");
			//String FullURL  = "https://flipkart.com"+URL;
			System.out.println("URL:"+URL);
			try {
				URL objUrl = new URL(URL);
				HttpURLConnection objHUC = (HttpURLConnection) objUrl.openConnection();
				objHUC.connect();
				int statusCode = objHUC.getResponseCode();
				if(statusCode>=200&&statusCode<=226) {
					System.out.println(statusCode+":"+URL+" is a valid Link");
				}else if(statusCode>=300&&statusCode<=308) {
					System.out.println(statusCode+":"+URL+" is a Redirection Link");
				}else if(statusCode>=400&&statusCode<=499) {
					System.out.println(statusCode+":"+URL+" is a Client Error Link");
				}else if(statusCode>=500&&statusCode<=599) {
					System.out.println(statusCode+":"+URL+" is a Server Error Link");
				}
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		}
		
	@Test(priority=2)
	public void ValidateLinksInElectronicsModuleOfFlipKart() throws IOException, InterruptedException {
		System.out.println("inside ValidateLinksInElectronicsModuleOfFlipKart");
		driver.get(objProperties.getProperty("FlipkartUrl"));
		//using over riding which is also called as Run Time Polymorphism
		//PageLoadTimeOut();
		
		String pageInfo = driver.getPageSource();
		Boolean closeIcon =false;
		FlipKartPOM objFlipkartPOM = new FlipKartPOM(driver);
		if(pageInfo.contains("✕")) {
			closeIcon=true;
		}
		if(closeIcon) {
			objFlipkartPOM.closeIcon.click();
		}
		driver.navigate().refresh();
		Thread.sleep(3000);
		PageLoadTimeOut();
		Actions objAction = new Actions(driver);
		// below is the explicit wait for selenium 3
		// WebDriverWait wait = new WebDriverWait(driver, 60);
		// below is the explicit wait for selenium 4
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(60));
		wt.until(ExpectedConditions.elementToBeClickable(objFlipkartPOM.Electronics));
		objAction.moveToElement(objFlipkartPOM.Electronics).build().perform();

		Actions objAction1 = new Actions(driver);
		WebDriverWait wt1 = new WebDriverWait(driver, Duration.ofSeconds(60));
		wt1.until(ExpectedConditions.elementToBeClickable(objFlipkartPOM.electronicsGSTStore));
		objAction1.moveToElement(objFlipkartPOM.electronicsGSTStore).build().perform();
		objAction1.click(objFlipkartPOM.electronicsGSTStore).build().perform();
		//PageLoadTimeOut();
		
		Actions objAction2 = new Actions(driver);
		WebDriverWait wt2 = new WebDriverWait(driver, Duration.ofSeconds(60));
		wt2.until(ExpectedConditions.elementToBeClickable(objFlipkartPOM.Electronics));
		objAction2.moveToElement(objFlipkartPOM.Electronics).build().perform();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
				wait.until(ExpectedConditions.visibilityOfAllElements(objFlipkartPOM.AllElectronics));
		System.out.println("number of links under Electronis:"+objFlipkartPOM.AllElectronics.size());
		
		HashMap<String,String> hmap = new HashMap<String,String>();
		hmap.put("Mobiles", "MobilesPhones");
		hmap.put("Mi", "Mi Mobiles");
		hmap.put("Realme", "realme");
		hmap.put("Samsung", "Samsung Mobile Phones");
		hmap.put("Infinix", "Infinix");
		hmap.put("OPPO", "OPPO Mobile phones");
		hmap.put("Apple", "Apple Mobile phones");
		
		Boolean LinkWorking=false;
		
		for (int i=5 ; i<objFlipkartPOM.AllElectronics.size();i++) {
			try {
				String InidvidualTextOfLink = objFlipkartPOM.AllElectronics.get(i).getText();
				objFlipkartPOM.AllElectronics.get(i).click();
				Thread.sleep(4000);
				String text = driver.getPageSource();
				//System.out.println("text:"+text);
				System.out.println("InidvidualTextOfLink of"+i+"is:"+InidvidualTextOfLink);
				if(InidvidualTextOfLink.equalsIgnoreCase("Mobiles")){
					if(text.contains(hmap.get("Mobiles"))) {
						LinkWorking=true;	
					}
					Assert.assertTrue(LinkWorking,hmap.get("Mobiles") +" is not identified for :"+InidvidualTextOfLink);
				}else if(InidvidualTextOfLink.equalsIgnoreCase("Apple")){
					if(text.contains(hmap.get("Apple"))) {
						LinkWorking=true;
					}
					Assert.assertTrue(LinkWorking,hmap.get("Apple") +" is not identified for :"+InidvidualTextOfLink);
					
					
				}
				
				//System.out.println("text:"+text);
				//Assert.assertEquals(text,"Mobile Phones");
				//driver.navigate().back();
				objAction.moveToElement(objFlipkartPOM.Electronics).build().perform();
				WebDriverWait wt4 = new WebDriverWait(driver, Duration.ofSeconds(60));
				//WebDriverWait wait1 = new WebDriverWait(driver,30);
						wt4.until(ExpectedConditions.visibilityOfAllElements(objFlipkartPOM.AllElectronics));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		}
	
	

	@Override
	public void PageLoadTimeOut() {
		//selenium 4:
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
		//selenium 3:
		//driver.manage().timeouts().pageLoadTimeout(90,TimeUnit.SECONDS);
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
	public void beforeSuite() {
		System.out.println("inside beforeSuite");
		try {
			ReadPropetiesFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("inside afterSuite");
	}

}
