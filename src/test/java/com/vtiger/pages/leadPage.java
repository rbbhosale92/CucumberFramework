package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class leadPage extends headerPage {
	
private WebDriver driver;
	
	public leadPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="lastname")
	WebElement tb_lastname;
	
	@FindBy(name="company")
	WebElement tb_company;
	
	@FindBy(name="button")
	WebElement btn_save;
	
	@FindBy(xpath="//td[text()='Last Name:']/following::td[1]")
	WebElement lbl_lastname;
	
	@FindBy(xpath="//td[text()='Company:']/following::td[1]")
	WebElement lbl_company;
	
	
	public void enterLastname(String lname)
	{
		tb_lastname.sendKeys(lname);		
	}
	public void enterCompany(String comp)
	{
		tb_company.sendKeys(comp);		
	}
	public void ClickSaveButton()
	{
		btn_save.click();
	}
	
	public void Savelead(String lname,String comp)
	{
		enterLastname(lname);
		enterCompany(comp);
		ClickSaveButton();
	}
	
	public boolean verifyLeadCreation(String lname, String comp)
	{
		String lnametxt = lbl_lastname.getText().trim();
		String comptxt = lbl_company.getText().trim();
		if(lnametxt.equals(lname) && comptxt.equals(comp))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	

}
