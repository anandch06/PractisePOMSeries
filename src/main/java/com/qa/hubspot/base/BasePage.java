package com.qa.hubspot.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author akkch
 *
 */

public class BasePage {

	public Properties prop;
	public WebDriver driver;

	/**
	 * 
	 * @param browser--used to initialise the browser
	 * 	 * @return this return webdriver driver
	 */

	public WebDriver init_driver(String browser){
		System.out.println("browser value is : " + browser);

		if(browser.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Please pass the correct browser value : " + browser);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		return driver;

	}

	/**
	 * this method is used to load properties from config.properties file
	 * @return
	 */
	public Properties init_prop(){
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\akkch\\workspace\\PractisePOMSeries\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}
	/********
	 * this method is used to take the screenshot
	 * it will return the path of screenshot
	 * @return 
	 * 
	 */
	public String getScreenshot(){
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);

		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;


	}


}
