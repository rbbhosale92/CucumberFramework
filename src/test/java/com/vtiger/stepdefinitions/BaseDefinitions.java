package com.vtiger.stepdefinitions;



import org.openqa.selenium.By;

import com.vtiger.pages.headerPage;
import com.vtiger.pages.homePage;
import com.vtiger.pages.leadPage;
import com.vtiger.pages.loginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class BaseDefinitions extends BaseTest {
	
	public leadPage ldp;
	
	@Given("^user should be on login page$")
	public void user_should_be_on_login_page() throws Throwable {
		launchApp();
		System.out.println("Application launched");
	}

	@When("^user enters userid and password and click on login button$")
	public void user_enters_userid_and_password_and_click_on_login_button() throws Throwable {
		
		loginPage lp =new loginPage(driver);
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("Entered userid and password");
	}

	@Then("^user should be landed on home page$")
	public void user_should_be_landed_on_home_page() throws Throwable {
		homePage hp = new homePage(driver);
		hp.verifylbl_NyTopOpenPotentials();
	}

	@Then("^close browser$")
	public void close_browser() throws Throwable {
	    driver.quit();
	}
	
	@When("^user click on create lead link$")
	public void user_click_on_create_lead_link() throws Throwable {
		headerPage hdp = new headerPage(driver);
		hdp.ClickNewLeads();		
	}

	@Then("^user navigates on create lead page$")
	public void user_navigates_on_create_lead_page() throws Throwable {
		ldp = new leadPage(driver);
	}

	@When("^user enter last name and company$")
	public void user_enter_last_name_and_company() throws Throwable {
		ldp.enterLastname("Modi");
		ldp.enterCompany("BJP");
		
	}

	@When("^click on save button$")
	public void click_on_save_button() throws Throwable {
	   ldp.ClickSaveButton();
	}

	@Then("^lead should be saved successfully$")
	public void lead_should_be_saved_successfully() throws Throwable {
		ldp.verifyLeadCreation("Modi", "BJP");
	}

	@Then("^click on logout link$")
	public void click_on_logout_link() throws Throwable {
	    ldp.ClickLogout();
	}

	@When("^user enters invalid \"([^\"]*)\" and \"([^\"]*)\" click on login button$")
	public void user_enters_invalid_and_click_on_login_button(String arg1, String arg2) throws Throwable {
		//loginPage lp1 =new loginPage(driver);
		//lp1.login(arg1, arg2);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.name("Login1")).click();
	}

}
