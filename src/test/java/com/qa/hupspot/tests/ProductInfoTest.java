package com.qa.hupspot.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;

public class ProductInfoTest extends BaseTest {
	
	@BeforeClass
	public void productInfoSetUp(){
		accountsPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 2)
	public void productInfopageTitleTest_iMac(){
       accountsPage.doSearch("iMac");
		productInfoPage = accountsPage.selectProductFromResults("iMac");
		Assert.assertEquals(productInfoPage.getProductInfoPageTitle("iMac"),"iMac");
	}
	
	
	@Test(enabled = false)
	public void verifyProductInfoTest_MacBook(){
		String productName = "MacBook";
		Assert.assertTrue(accountsPage.doSearch(productName));
		
		productInfoPage = accountsPage.selectProductFromResults("MacBook Pro");
		Assert.assertTrue(productInfoPage.getProductImages() == 4);
		Map<String, String> productInfoMap = productInfoPage.getProductInformation();
		System.out.println(productInfoMap);
		//{Brand=Apple, Availability=In Stock, Price=$2,000.00, 
		//name=MacBook Pro, Product Code=Product 18, Reward Points=800,
		//exTaxPrice=$2,000.00}
		Assert.assertEquals(productInfoMap.get("name"), "MacBook Pro");
		Assert.assertEquals(productInfoMap.get("Brand"), "Apple");
		Assert.assertEquals(productInfoMap.get("Product Code"), "Product 18");
		Assert.assertEquals(productInfoMap.get("Reward Points"), "800");
		Assert.assertEquals(productInfoMap.get("Price"), "$2,000.00");
	}

	@Test(priority=1)
	public void verifyProductInfoTest_iMac(){
		String productName = "iMac";
		Assert.assertTrue(accountsPage.doSearch(productName));
		
		productInfoPage = accountsPage.selectProductFromResults("iMac");
		Assert.assertTrue(productInfoPage.getProductImages() == 3);
		Map<String, String> productInfoMap = productInfoPage.getProductInformation();
		System.out.println(productInfoMap);
		Assert.assertEquals(productInfoMap.get("name"), "iMac");
		Assert.assertEquals(productInfoMap.get("Brand"), "Apple");
		Assert.assertEquals(productInfoMap.get("Product Code"), "Product 14");
		Assert.assertEquals(productInfoMap.get("Price"), "$100.00");
	}
}
