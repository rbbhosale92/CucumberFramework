package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class headerPage {
	private WebDriver driver;
	public headerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText="Logout")
	WebElement lnk_Logout;
	
	@FindBy(linkText="My Account")
	WebElement lnk_MyAccount;
	
	@FindBy(linkText="Leads")
	WebElement lnk_Leads;
	
	@FindBy(linkText="New Lead")
	WebElement lnk_NewLeads;
	
	public void ClickNewLeads()
	{
		lnk_NewLeads.click();
	}
	
	public void ClickLeads()
	{
		lnk_Leads.click();
	}
	
	public void ClickMyAccount()
	{
		lnk_MyAccount.click();
	}
	
	public void ClickLogout()
	{
		lnk_Logout.click();
	}


}
