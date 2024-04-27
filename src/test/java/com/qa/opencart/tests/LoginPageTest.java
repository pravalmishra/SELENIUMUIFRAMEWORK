package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.errors.AppError;
import com.qa.opencart.listeners.ExtentReportListener;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

//@Listeners(ExtentReportListener.class)
@Epic("Epic 100: Design open cart login page")
@Story("User Story 101: Design login Page Feature for open cart application")
@Feature("Feature 201: Adding Login Feature")
public class LoginPageTest extends BaseTest{
	
	@Description("Checking Login Page Title...")
	@Severity(SeverityLevel.MINOR)
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		
		String actTitle = loginPage.getLoginPageTitle();
		// Assert.assertEquals(actTitle, "Account Login");
		Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE, AppError.TITLE_NOT_FOUND);
	}
	
	@Description("Checking Login Page URL...")
	@Severity(SeverityLevel.MINOR)
	@Test(priority=2)
	public void loginPageURLTest() {
		
		String actURL = loginPage.getLoginPageURL();
	//	Assert.assertTrue(actURL.contains("route=account/login"));
		Assert.assertTrue(actURL.contains(AppConstants.LOGIN_PAGE_URL_FRACTION), AppError.URL_NOT_FOUND);
	}
	
	@Description("Checking Forgot Pwd Link on login page...")
	@Severity(SeverityLevel.CRITICAL)

	@Test(priority=3)
	public void forgotPwdLinkExistTest() {
		
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Description("Checking User is able to Login...")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority=4)
	public void loginTest() {
		
		accPage =   loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	   // Assert.assertEquals(accPageTitle, "My Account");
	   // Assert.assertEquals(accPage.getAccPageTitle(), "My Account");
		Assert.assertEquals(accPage.getAccPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE);
	}
	
	

}
