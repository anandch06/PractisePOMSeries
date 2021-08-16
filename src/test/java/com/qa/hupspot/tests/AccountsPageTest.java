package com.qa.hupspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hupspot.utils.Constants;

public class AccountsPageTest extends BaseTest{
	
	@BeforeClass
	public void accountsPageSetUp (){
		
		accountsPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		}
	
	@Test(priority=2)
	public void accountPageTitle(){
		String title=accountsPage.getAccountsHomePageTitle();
		System.out.println("accounts page title is : " + title);
	Assert.assertEquals(title, Constants.ACCOUNTS_PAGE_TITLE);
	}

	@Test(priority=1)
	public void verifyAccountPageHeaderTest(){
		String headerValue=accountsPage.getHeaderValue();
		System.out.println("accountpage header is :" + headerValue);
		Assert.assertEquals(headerValue, Constants.ACCOUNTS_PAGE_HEADER);
	}
	
	@Test(priority=3)
	public void verifyMyAccountsSectionCountTest(){
		Assert.assertTrue(accountsPage.getAccountSectionSize()== Constants.ACCOUNTS_SECTIONS);
	}
	
	@Test(priority=4)
	public void verifyMyAccountsSectionList(){
		Assert.assertEquals(accountsPage.getAccountSectionList(),Constants.getAccountSectionsList());
	}
	
	@Test(priority=5)
	public void searchTest(){
		Assert.assertTrue(accountsPage.doSearch("Imac"));
	}
	
	
	
	
}
