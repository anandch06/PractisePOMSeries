package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hupspot.utils.Constants;
import com.qa.hupspot.utils.ElementUtil;

public class RegisterPage extends BasePage{
	ElementUtil elementUtil;
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By eMail = By.id("input-email");
	private By telePhone = By.id("input-telephone");
	private By passWord = By.id("input-password");
	private By confirmPassword = By.id("input-confirm");
	private By subscribeYes = By.xpath("//input[@name='newsletter' and @value='1']");
	private By subscribeNo = By.xpath("//input[@name='newsletter' and @value='0']");
	private By agreeCheckBox = By.xpath("//input[@name='agree' and @value='1']");
	private By continueButton = By.xpath("//input[@type='submit']");
	private By accountSuccessMessage = By.cssSelector("#content h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	
	public RegisterPage(WebDriver driver){
		this.driver=driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	public boolean accountRegistration(String firstName, String lastName, String email, String telephone,
			                   String password, String subscribe){
		elementUtil.doSendkeys(this.firstName, firstName);
		elementUtil.doSendkeys(this.lastName, lastName);
		elementUtil.doSendkeys(this.eMail, email);
		elementUtil.doSendkeys(this.telePhone, telephone);
		elementUtil.doSendkeys(this.passWord, password);
		elementUtil.doSendkeys(this.confirmPassword, password);
		
		if(subscribe.equals("yes")){
			elementUtil.doClick(subscribeYes);
		}
		else{
			elementUtil.doClick(subscribeNo);
		}
		elementUtil.doClick(agreeCheckBox);
		elementUtil.doClick(continueButton);
		
		String text = elementUtil.doGetText(accountSuccessMessage);
		if(text.contains(Constants.ACCOUNTS_SUCCESS_MESSAGE)){
			elementUtil.doClick(logoutLink);
			elementUtil.doClick(registerLink);
			return true;
		}
		else{
			return false;
		}
	}
	
}
