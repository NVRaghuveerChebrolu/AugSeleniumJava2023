package com.POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinksPOM {
	public WebDriver driver;
	
	public LinksPOM(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//@FindBy(xpath="//a")
	@FindBy(tagName="a")
	public List<WebElement> AllLinks;
}
