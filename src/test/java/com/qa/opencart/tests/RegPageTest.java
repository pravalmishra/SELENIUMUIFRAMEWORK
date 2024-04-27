package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.CSVUtil;
import com.qa.opencart.utils.ExcelUtil;
import com.qa.opencart.utils.StringUtils;

public class RegPageTest extends BaseTest {

	@BeforeClass
	public void regSetup() {
		registerationPage = loginPage.navigateToRegisterPage();
	}
	
	// Return type of DataProvider in TestNg is 2D Array 
	
	//******** Read data through DataProvider using ***********//
	
/*	@DataProvider
	public Object[][] getUserRegTestData() {
		return new Object[][] {
			{"gaurav", "gupta",  "9876543212", "gg@123", "yes"},
			{"shilpa", "mamiidipelli", "9876543662", "shilpa@123", "no"},
			{"om", "gautam", "9876587653", "om@123", "yes"}

		};
	}
	
	

	@Test(dataProvider = "getUserRegTestData")
	public void userRegTest(String firstName, String lastName, String telephone, String password, String subscribe) {
		Assert.assertTrue(
				registerationPage.userRegister(firstName, lastName, 
						StringUtils.getRandomEmailId(), 
						telephone, password, subscribe));

	} */
	
	
	//******** Read data from excel file ***********//
	
	@DataProvider
	public Object[][] getUserRegTestDataFromExcel() {
		return ExcelUtil.getTestData(AppConstants.REGISTER_DATA_SHEET_NAME);
	}
	
	
	@Test(dataProvider = "getUserRegTestDataFromExcel")
	public void userRegTest(String firstName, String lastName, String telephone, String password, String subscribe) {
		Assert.assertTrue(
				registerationPage.userRegister(firstName, lastName, 
						StringUtils.getRandomEmailId(), 
						telephone, password, subscribe));
		
	
		
    //******** Read data from csv file ***********//
		
	
/*	@DataProvider(name="csvregdata")
	public Object[][] getUserRegTestDataFromCSV() {
		return CSVUtil.csvData(AppConstants.REGISTER_DATA_SHEET_NAME);
	} 
	

	@Test(dataProvider = "csvregdata")
	public void userRegTest(String firstName, String lastName, String telephone, String password, String subscribe) {
		
		
		
		Assert.assertTrue(
				registerationPage.userRegister(firstName, lastName, 
						StringUtils.getRandomEmailId(), 
						telephone, password, subscribe));
		
		

	}  */
	
	
	
	}
}
	