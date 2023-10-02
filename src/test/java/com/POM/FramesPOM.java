package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesPOM {

	WebDriver driver;

	public FramesPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * @FindBy(name="SingleFrame") WebElement SingleFrame;
	 */

	@FindBy(xpath = "//input[@type='text']")
	public WebElement SingleFrameTextBox;

	@FindBy(xpath = "//a[contains(text(),'an Iframe')]")
	public WebElement IframeWithInIframeButton;

	@FindBy(xpath = "//iframe[@src='MultipleFrames.html']")
	public WebElement MutipleFrame;

	@FindBy(xpath = "//iframe[@src='SingleFrame.html']")
	public WebElement iframeInsideMultipleFrame;

	@FindBy(xpath = "//div[@class='col-lg-8']/div/iframe[@id='frame1']")
	public WebElement chercheriframe1;

	@FindBy(css = "#frame3")
	public WebElement chercheriframe3;

	@FindBy(xpath = "//iframe[@id='frame2']")
	public WebElement chercheriframe2;

	@FindBy(css = "input#a")
	public WebElement checkboxinframe3;

	@FindBy(xpath = "//iframe[@id='frm1']")
	public WebElement HYRTutorialFrame1;

	@FindBy(xpath = "//select[@id='selectnav1']")
	public WebElement HYRTutorialdropdownframe1;

	@FindBy(css = "iframe#frm2")
	public WebElement HYRTutorialFrame2;

	@FindBy(css = "iframe#frm3")
	public WebElement HYRTutorialFrame3;

	@FindBy(id = "firstName")
	public WebElement textboxFirstName;

	@FindBy(id = "lastName")
	public WebElement textboxLastName;

	@FindBy(id = "malerb")
	public WebElement RadiobtnGenderMale;

	@FindBy(id = "femalerb")
	public WebElement RadiobtnGenderFemale;

	@FindBy(id = "hindichbx")
	public WebElement checkboxhindiframe2;

	@FindBy(id = "email")
	public WebElement EmailIdFrame2;

	@FindBy(id = "password")
	public WebElement EnterPasswordInFrame2;

	@FindBy(id = "registerbtn")
	public WebElement regitrationbtninframe2;
}
