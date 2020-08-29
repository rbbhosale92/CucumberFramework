package com.vtiger.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.Markup;
import com.vtiger.utilities.BaseMethods;

public class loginPage {
	
	private WebDriver driver;
	
	public loginPage(WebDriver driver)
	{
		this.driver=driver;		
		PageFactory.initElements(driver, this);
	}
	
	//By tb_username = By.name("user_name1");
	//By tb_password = By.name("user_password");
	//By btn_login = By.name("Login");
	
	@FindBy(name="user_name")
	WebElement tb_username;
	
	@FindBy(name="user_password")
	WebElement tb_password;
	
	@FindBy(name="Login")
	WebElement btn_login;
	
	@FindBy(xpath="//img[@src='include/images/vtiger-crm.gif']")
	List<WebElement> img_logo;
	
	
	public void login(String userid, String pwd)
	{	
		tb_username.clear();		
		tb_username.sendKeys(userid);
		tb_password.clear();
		tb_password.sendKeys(pwd);		
		btn_login.click();   
	}
	
	public void getApptitle(String expstr)
	{
		 
	}
	
	public void VerifyLogo()
	{
		
		
	}
	
	
	

}
