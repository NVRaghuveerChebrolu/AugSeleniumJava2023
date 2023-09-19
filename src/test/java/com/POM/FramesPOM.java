package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesPOM {
	
	WebDriver driver ;
	
	public FramesPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * @FindBy(name="SingleFrame") WebElement SingleFrame;
	 */
	
	@FindBy(xpath="//input[@type='text']")
	public WebElement SingleFrameTextBox;
	
	@FindBy(xpath="//a[contains(text(),'an Iframe')]")
	public WebElement IframeWithInIframeButton;
	
	@FindBy(xpath="//iframe[@src='MultipleFrames.html']")
	public WebElement MutipleFrame;
	
	@FindBy(xpath="//iframe[@src='SingleFrame.html']")
	public WebElement iframeInsideMultipleFrame;
}
