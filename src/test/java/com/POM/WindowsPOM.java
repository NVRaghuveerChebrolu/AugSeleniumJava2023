package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowsPOM {
	WebDriver driver;
	
	public WindowsPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="newbrowserwindow123")
	public WebElement NewBrowserWindowButton;
	
	@FindBy(xpath="//button[@type='button']")
	public WebElement MenuOfNewBrowserWindow;
	
	@FindBy(xpath="//li[@id='menu-item-6374']/span/i")
	public WebElement AboutMeOfNewBrowserWindow;
	
	@FindBy(xpath="//li[@id='menu-item-5294']/a")
	public WebElement TechTalkUnderAboutMe;
	
}
