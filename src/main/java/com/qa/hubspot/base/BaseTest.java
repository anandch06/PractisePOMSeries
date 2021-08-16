package com.qa.hubspot.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.qa.hubspot.pages.AccountsPage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.pages.ProductInfoPage;
import com.qa.hubspot.pages.RegisterPage;

public class BaseTest {

	public BasePage bp;
	public LoginPage loginPage;
	public AccountsPage accountsPage;
	public ProductInfoPage productInfoPage;
	public RegisterPage registerPage;
	public Properties prop;
	public WebDriver driver;

	@BeforeTest
	public void setUp(){
		bp = new BasePage();
		prop=bp.init_prop();
		String browser1=prop.getProperty("browser");
		System.out.println("Browser is : " + browser1);
		driver=bp.init_driver(browser1);
		loginPage = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
	}

	@AfterTest
	public void tearDown(){
		driver.quit();
	}

}
