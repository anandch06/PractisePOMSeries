package com.qa.hubspot.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hubspot.base.BasePage;
import com.qa.hupspot.utils.ElementUtil;

public class ProductInfoPage extends BasePage {
	private WebDriver driver;
	private ElementUtil elementUtil;

	private By productNameHeader = By.cssSelector("#content h1");
	private By productMetadata = By.cssSelector("#content .list-unstyled:nth-of-type(1) li");
	private By productPrice = By.cssSelector("#content .list-unstyled:nth-of-type(2) li");
	private By productQuantity = By.id("input-quantity");
	private By addToCart = By.cssSelector(".btn.btn-primary.btn-lg.btn-block");
	private By productImages = By.cssSelector(".thumbnails li img");

	public ProductInfoPage(WebDriver driver){
		this.driver=driver;
		elementUtil = new ElementUtil(driver);
	}

	public Map<String, String> getProductInformation(){

		Map<String, String> productInfoMap = new HashMap<>();
		productInfoMap.put("name", elementUtil.doGetText(productNameHeader).trim());

		List<WebElement> productMetaDataList = elementUtil.getElements(productMetadata);		
		for(WebElement e : productMetaDataList){
			productInfoMap.put(e.getText().split(":")[0].trim(), e.getText().split(":")[1].trim());
		}
		List<WebElement> productPriceList = elementUtil.getElements(productPrice);
		productInfoMap.put("Price",productPriceList.get(0).getText().trim());
		productInfoMap.put("exTaxPrice",productPriceList.get(1).getText().split(":")[1].trim());
		return productInfoMap;
	}

	public void selectQuantity(String quantity){
		elementUtil.doSendkeys(productQuantity, quantity);
	}

	public void addToCart(){
		elementUtil.doClick(addToCart);
	}

	public int getProductImages(){
		int imagesCount = elementUtil.getElements(productImages).size();
		System.out.println("Total images count :" + imagesCount);
		return imagesCount;
	}

	public String getProductInfoPageTitle(String productname){
		return elementUtil.waitForTitlePresent(productname, 5);
	}
}
