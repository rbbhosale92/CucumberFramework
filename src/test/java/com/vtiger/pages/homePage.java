package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage extends headerPage {
	
private WebDriver driver;
	
	public homePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//td[contains(text(),'My Top Open Potentials')]")
	WebElement lbl_NyTopOpenPotentials;
	
	
	
	
	public boolean verifylbl_NyTopOpenPotentials()
	{
		return lbl_NyTopOpenPotentials.isDisplayed();
	}

}
