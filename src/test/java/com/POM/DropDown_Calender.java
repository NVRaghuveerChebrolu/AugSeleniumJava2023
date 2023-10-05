package com.POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropDown_Calender {
	public WebDriver driver;
	
	public DropDown_Calender(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="dateOfBirthInput")
	public WebElement DOB;
	
	@FindBy(xpath="//select[@class='react-datepicker__month-select']")
	public WebElement Month;
	
	@FindBy(xpath="//select[@class='react-datepicker__year-select']")
	public WebElement Year;
	
	
	@FindBy(xpath="//div[@class='react-datepicker__month']/div/div")
	public List<WebElement> AllDays;
	

}
