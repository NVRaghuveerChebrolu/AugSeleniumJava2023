package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MouseOperationsPagePOM {
	WebDriver driver;
	Actions objActions ;
	
	
	public MouseOperationsPagePOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//h2[@id='example-code-simple-context-menu']/preceding-sibling::p/span")
	WebElement RightClickMeButton;
	
	@FindBy(xpath="//span[text()='Quit']")
	WebElement Quit;
	
	@FindBy(xpath="//span[text()='Edit']")
	WebElement Edit;
	
	@FindBy(xpath="//iframe")
	public WebElement iframe;
	
	@FindBy(xpath="//span[contains(text(),'the block')]/preceding-sibling::div")
	public WebElement DoubleClickBox;
	
	public void RightClickOnRightClickMeButton() {
		objActions = new Actions(driver);
		objActions.contextClick(RightClickMeButton).build().perform();
	}

	public void ClickOnQuitOption() {
		Quit.click();
	}
	
	public void ClickOnQuit() {
		objActions = new Actions(driver);
		objActions.click(Quit).build().perform();
	}
	
	public void ClickOnEdit() {
		objActions = new Actions(driver);
		objActions.click(Edit).build().perform();
	}
}
