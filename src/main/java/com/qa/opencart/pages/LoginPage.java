package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.logger.Log;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.TimeUtil;

import io.qameta.allure.Step;

public class LoginPage {
	
	//Page class/Page Library/Page Object
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	// 1. Private By Locators
	
	private By emailId        =    By.id("input-email");
	private By password       =    By.id("input-password");
	private By loginButton    =    By.xpath("//input[@value='Login']");
	private By forgotPWdLink  =    By.linkText("Forgotten Password");
	private By registerLink   =    By.linkText("Register");
	private By praval   =    By.linkText("Praval");
	
	
	// 2. Public Page class Constructor
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	// 3. Public Page Action/Methods
	
	
	@Step("Getting Login Page Title...")
	public String getLoginPageTitle() {
		String title = eleUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, TimeUtil.DEFAULT_MEDIUM_TIME);
	//	String title = driver.getTitle();
	//	System.out.println("Login Page title :" +title);
		Log.info("Login Page title :" +title);
		return title;
	}
	
	@Step("Getting Login Page Url...")
	public String getLoginPageURL() {
		
	//	String url = eleUtil.waitForURLContains("route=account/login", 5);
		String url = eleUtil.waitForURLContains(AppConstants.LOGIN_PAGE_URL_FRACTION, TimeUtil.DEFAULT_MEDIUM_TIME);
	//	String url = driver.getCurrentUrl();
		System.out.println("Login Page url :" +url);
		return url;
	}
	
	@Step("Getting the state of forgot pwd link...")
	public boolean isForgotPwdLinkExist() {
		return eleUtil.isElementDisplayed(forgotPWdLink);
	//	return driver.findElement(forgotPWdLink).isDisplayed();
	}
	
	@Step("Login with username: {0} and Password: {1}")
	public AccountsPage doLogin(String username, String pwd) {
		System.out.println("User creds are: " + username + " : " + pwd);
	//	driver.findElement(emailId).sendKeys(username);
	//	driver.findElement(password).sendKeys(pwd);
	//	driver.findElement(loginButton).click();
		eleUtil.waitForElementVisible(emailId, TimeUtil.DEFAULT_LONG_TIME).sendKeys(username);
		eleUtil.doSendKeys(password,pwd);
		eleUtil.doClick(loginButton );
	//	return driver.getTitle();
	//	return eleUtil.waitForTitleIs("My Account", 5);
		return new AccountsPage(driver);
	}
	
	@Step("Navigating to registration page...")
	public RegisterationPage navigateToRegisterPage() {
		eleUtil.waitForElementVisible(registerLink, TimeUtil.DEFAULT_LONG_TIME).click();
		return new RegisterationPage(driver);
	}
	
	

}
