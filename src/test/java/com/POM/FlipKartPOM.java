package com.POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipKartPOM {
	public WebDriver driver;
	
	public FlipKartPOM(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[text()='Electronics']")
	public WebElement Electronics;
	
	@FindBy(xpath="//*[text()='Electronics GST Store']")
	public WebElement electronicsGSTStore;
	
	@FindBy(xpath="//div[@class='_1fwVde']/a")
	public List<WebElement> AllElectronics;
	
	@FindBy(xpath="//label[text()='Enter Email/Mobile number']/../../../../../../ancestor::div[1]/span")
	public WebElement closeIcon;
}
