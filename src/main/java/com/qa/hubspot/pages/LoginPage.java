package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.base.BasePage;
import com.qa.hupspot.utils.Constants;
import com.qa.hupspot.utils.ElementUtil;

public class LoginPage extends BasePage{
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	@FindBy
	
	//1. By Locators :OR

	
	private By emailId = By.id("input-email");
	private By password  = By.id("input-password");
	private By loginButton = By.xpath("//input[@class='btn btn-primary' and @type='submit']");
	private By forgotPasswordLink = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");
	
	
	//2. Constructor of page class
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		elementUtil = new ElementUtil(driver);
		}
	
	//3.page actions ---features(Behavior) of the page in name of methods
	public String getLoginPgeTitle(){
		return elementUtil.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 10);
		}
	public boolean isForgetPasswordLinkExist(){
		return elementUtil.doIsDisplayed(forgotPasswordLink);
	}
	
	public AccountsPage doLogin(String un, String pwd){
		System.out.println("Login with :" + un +  "and"  + pwd);
		elementUtil.doSendkeys(emailId, un);
		elementUtil.doSendkeys(password, pwd);
		elementUtil.doClick(loginButton);
		
		return new AccountsPage(driver);
	}
	
	public RegisterPage navigateToregisterPage(){
		elementUtil.doClick(registerLink);
		return new RegisterPage(driver);
	}
	

}
