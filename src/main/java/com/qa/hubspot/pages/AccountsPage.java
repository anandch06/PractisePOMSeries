package com.qa.hubspot.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hubspot.base.BasePage;
import com.qa.hupspot.utils.Constants;
import com.qa.hupspot.utils.ElementUtil;

public class AccountsPage extends BasePage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By header = By.cssSelector("div#logo a");
	private By accountSectionHeaders = By.cssSelector("div#content h2");
	private By searchText = By.cssSelector("div#search input[name='search']");
	private By searchButton = By.cssSelector("div#search button[type='button']");
	private By searchItems=By.cssSelector(".product-layout .product-thumb");
	private By resultsItems = By.cssSelector(".product-thumb h4 a");

	public AccountsPage(WebDriver driver){
		this.driver=driver;
		elementUtil = new ElementUtil(driver);
	}


	public String getAccountsHomePageTitle(){
		return elementUtil.waitForTitlePresent(Constants.ACCOUNTS_PAGE_TITLE, 10);
	}

	public String getHeaderValue(){
		if(elementUtil.doIsDisplayed(header)){
			return elementUtil.doGetText(header);
		}
		return null;
	}

	public int getAccountSectionSize(){
		return elementUtil.getElements(accountSectionHeaders).size();
	}
	
	public List<String> getAccountSectionList(){
		List<String> accountsList = new ArrayList<String>();
		List<WebElement> accSectionList=elementUtil.getElements(accountSectionHeaders);;
		for(WebElement e : accSectionList){
			System.out.println(e.getText());
			accountsList.add(e.getText());
		}
		return accountsList;
	}

	public boolean doSearch(String productName){
		elementUtil.doSendkeys(searchText, productName);
		elementUtil.doClick(searchButton);
		if(elementUtil.getElements(searchItems).size()>0){
			return true;	
		}
		return false;
	}
	
	public ProductInfoPage selectProductFromResults(String productName){
		List<WebElement> resultItemsList = elementUtil.getElements(resultsItems);
		System.out.println("Total no of items displayed were : " + resultItemsList.size());
		
		for(WebElement e : resultItemsList){
			if(e.getText().equals(productName)){
				e.click();
				break;
			}
		}
		return new ProductInfoPage(driver);
	}
	
	
}
