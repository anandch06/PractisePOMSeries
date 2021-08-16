package com.qa.hupspot.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	 private WebDriver driver;

	public ElementUtil(WebDriver driver){
		this.driver=driver;
	}

	/*
	 * this is used to create the webelement on the basis of given By locator
	 * @param locator
	 * return WebElement
	 */
	public List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}
	public WebElement getElement(By locator){
		WebElement element =driver.findElement(locator);
		return element;
	}

	public void doSendkeys(By locator, String value){
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator){
		getElement(locator).click();

	}

	public String doGetText(By locator){
		return getElement(locator).getText();
	}

	public boolean doIsDisplayed(By locator){
		return getElement(locator).isDisplayed();
	}

	public void doLinkClick(List<WebElement> linkList,String value){
		System.out.println(linkList.size());
		for (WebElement lang : linkList) {
			String text = lang.getText();
			System.out.println(text);

			if(text.equals(value)){
				lang.click();
				break;
			}
		}
	}

	//******************DropDown Utils*****************

	public void selectDropDownValueByVisisbleText(By locator, String value){
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}

	public void selectDropDownValueByValue(By locator, String value){
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	public void selectDropDownValueByIndex(By locator, int value){
		Select select = new Select(getElement(locator));
		select.selectByIndex(value);
	}

	public int getDropDownOptionsCount(By locator){
		Select select = new Select(getElement(locator));
		List<WebElement> options = select.getOptions();
		return options.size();
	}

	public List<String> getDropDownOptionsValues(By locator){
		List<String> textList = new ArrayList<String>();
		Select select = new Select(getElement(locator));
		List<WebElement> options = select.getOptions();
		for (WebElement ele : options) {
			String text = ele.getText();
			textList.add(text);
		}
		return textList;
	}

	//******Dropdown without select class*****
	public void selectValueFromDropDown(By locator,String value){
		List<WebElement> countryList = driver.findElements(locator);
		for (WebElement ele : countryList) {
			String text = ele.getText();
			System.out.println(text);
			if(text.equals(value)){
				ele.click();
				break;
			}
		}
	}

	//************SendKeys with Action class************
	public void doActionSendKeys(By locator, String value){
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator),value).perform();
	}

	public void doActionClick(By locator){
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}

	//****************waits**************
	public WebElement waitForElementPresent(By locator, int timeOut){
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public String waitForTitlePresent(String titleValue, int timeOut){
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.titleIs(titleValue));
		return driver.getTitle();
	}

	public WebElement waitForElementToBeVisible(By locator, int timeOut){
		WebElement element = getElement(locator);
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public Boolean waitForUrl(String url, int timeOut){
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		return wait.until(ExpectedConditions.urlContains(url));
	}

	public Alert waitForAlertToBePresent(int timeout){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public WebElement waitForElementToBeClickable(By locator,int timeout){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void clickWhenReady(By locator,int timeout){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}

	public List<WebElement> visibilityOfAllElements(By locator, int timeout){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public void getPageLinksText(By locator,int timeout){
		List<WebElement> footerLink = visibilityOfAllElements(locator,timeout);
		for (WebElement ele : footerLink) {
			System.out.println(ele.getText());
		}
	}
	//*********Fluent Wait*****
	public WebElement waitForElementWithFluetWait(By locator, int timeout, int interval){
		Wait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(interval))
				.ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

}
