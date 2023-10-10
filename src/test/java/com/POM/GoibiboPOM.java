package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoibiboPOM {
	public WebDriver driver;
	
	public GoibiboPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[@role='presentation']")
	public WebElement LoginPopUpClose;
	
	@FindBy(xpath="//span[contains(text(),'Select A Fare')]/following-sibling::ul/li[position()=1]/span[1]")
	public WebElement FareType_Regular;
	
	@FindBy(xpath="//span[contains(text(),'Select A Fare')]/following-sibling::ul/li[position()=2]/span[1]")
	public WebElement FareType_ArmedForces;
	
	@FindBy(xpath="//span[contains(text(),'Select A Fare')]/following-sibling::ul/li[position()=3]/span[1]")
	public WebElement FareType_SenorCitizen;
	
	@FindBy(xpath="//span[contains(text(),'Select A Fare')]/following-sibling::ul/li[position()=4]/span[1]")
	public WebElement FareType_Student;
	
	@FindBy(xpath="//span[contains(text(),'Select A Fare')]/following-sibling::ul/li[position()=5]/span[1]")
	public WebElement Fare_DoctorsAndNurses;
	
	@FindBy(xpath="//p[text()='One-way']/preceding-sibling::span")
	public WebElement TravelType_OneWay;
	
	@FindBy(xpath="//p[text()='Round-trip']/preceding-sibling::span")
	public WebElement TravelType_RoundTrip;
	
	@FindBy(xpath="//p[text()='Multi-city']/preceding-sibling::span")
	public WebElement TravelType_MultiCity;
	
	@FindBy(xpath="//span[text()='From']/following-sibling::p")
	public WebElement From_EnterCityOrAirport;
	
	@FindBy(xpath="//input[@type='text']")
	public WebElement TextBox;
	
	@FindBy(xpath="//span[text()='To']/following-sibling::p")
	public WebElement To_EnterCityOrAirport;
	
	@FindBy(xpath="//p[@class='sc-jlwm9r-1 ewETUe']")
	public WebElement closeIconGoibiboAdd;
	
	@FindBy(xpath="//a[text()='Done']")
	public WebElement DoneButton;

}
