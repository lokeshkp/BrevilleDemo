package com.ecom.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecom.qa.base.BasePage;
import com.ecom.qa.util.TestUtil;

public class SearchPage extends BasePage {

	@CacheLookup @FindBy(xpath = "//span[text()='Search']") public WebElement searchButton;
	@CacheLookup @FindBy(xpath = "//input[@id='c-searchbar__search-box']") public WebElement txtSearchBox;
	@CacheLookup @FindBy(xpath = "//span[@class='js-result-count']") public WebElement labelSearchResult;
	@CacheLookup @FindBy(xpath = "//span[@class='js-search-term font-archer-book") public WebElement searchKey;
	@CacheLookup @FindBy(xpath = "//div[@class='o-product-grid js-product-grid']/div[1]") public WebElement searchResult;
	@CacheLookup @FindBy(xpath = "//button[contains(text(),'Add to Cart')]") public WebElement btnAddCart;
	@CacheLookup @FindBy(xpath = "//a[@class='btn btn--primary']") public WebElement lnkAddCart;
	@CacheLookup @FindBy(xpath = "//h2[@id='productAddedMsgBox__title']") public WebElement acknowledgement;


	
	TestUtil testUtil = new TestUtil();

	public SearchPage(WebDriver driver) {
		super();
	}

	public void searchAndSelectProduct(String prodName) throws InterruptedException {
		String srchResult = "";
		int resCount =0;
		Thread.sleep(3000);
		testUtil.jsExecutorClick(searchButton);
		txtSearchBox.sendKeys(prodName);
		txtSearchBox.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		srchResult = labelSearchResult.getText();
		//if(searchKey.getText().contains(prodName) && srchResult.contains("search results for")) 
		resCount =Integer.parseInt(srchResult);  
		if(resCount>=1){
			logger.info(resCount + "search results for" + prodName);
			searchResult.click();
			Thread.sleep(3000);
			testUtil.jsExecutorClick(btnAddCart);
			Thread.sleep(3000);
			testUtil.jsExecutorClick(lnkAddCart);
			//System.err.println(acknowledgement.getText());
			//Assert.assertEquals(acknowledgement.getText(), "Item added to cart"); 
		}else {
			logger.info("No results found for" + srchResult);	
		}
	}
}
