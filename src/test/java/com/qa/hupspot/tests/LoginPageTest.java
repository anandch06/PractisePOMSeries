
package com.qa.hupspot.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.testlisteners.ExtentReportListener;
import com.qa.hupspot.utils.Constants;


public class LoginPageTest extends BaseTest {
	
	@Test(priority=1)
	public void verifyLoginpPageTitelTest(){
		String title=loginPage.getLoginPgeTitle();
		System.out.println("LoginPage title of the page is :" + title);
		Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyForgetPasswordLink(){
		Assert.assertTrue(loginPage.isForgetPasswordLinkExist());
	}

	@Test(priority=3)
	public void loginTest(){
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
}
