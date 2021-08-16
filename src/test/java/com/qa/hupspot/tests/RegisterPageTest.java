package com.qa.hupspot.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.hubspot.base.BaseTest;
import com.qa.hupspot.utils.Constants;
import com.qa.hupspot.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest {
	
	@BeforeClass
	public void registerPageSetup(){
		registerPage = loginPage.navigateToregisterPage();
	}
	
	@DataProvider
	public Object[][] getRegisterData(){
		Object data[][] = ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return data;
		
	}
	
	@Test(dataProvider = "getRegisterData")
	public void userRegistrationTest(String firstName, String lastName, String email, String telephone,
            String password, String subscribe){
		registerPage.accountRegistration(firstName, lastName, email, telephone, password, subscribe);
	}

}
