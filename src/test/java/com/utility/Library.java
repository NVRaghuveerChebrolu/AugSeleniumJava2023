package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Library {
	public Properties objProperties;
	public WebDriver driver;
	public void ReadPropetiesFile() throws IOException {

		File objFile = new File(System.getProperty("user.dir") + "//src//test//resources//Configuration.properties");
		try {
			FileInputStream ObjFileInput = new FileInputStream(objFile);
			objProperties = new Properties();
			objProperties.load(ObjFileInput);
			System.out.println("browser:" + objProperties.getProperty("browser"));
			//System.out.println("GmoOnlineURL" + objProperties.getProperty("GmoOnlineURL"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void LaunchBroswer() {
		String browser = objProperties.getProperty("browser");
		switch(browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "ie":
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("please provide browser name as chrome or firefox or edge or ie");
		}
		driver.manage().window().maximize();
		//implicit wait : Global waiting mechanism which is applicable for all WebElements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	
	public void PageLoadTimeOut(long seconds) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
	}
	
	public void TakeScreenShot() throws IOException {
		File Source= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dateName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		File Destination = new File(System.getProperty("user.dir")+"//Screenshots//"+dateName+".PNG");
		FileUtils.copyFile(Source, Destination);
	}
	
	public void ScrollDownByPixles(int PixelValue) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+PixelValue+")");
	}

}
