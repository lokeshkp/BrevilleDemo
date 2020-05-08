package com.ecom.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ecom.qa.base.BasePage;
import com.ecom.qa.util.TestUtil;

public class ProductsPage extends BasePage{

	@CacheLookup @FindBy(xpath = "//div[@class='o-category-grid']") public WebElement productLinks;

	@CacheLookup @FindBy(xpath = "//a[contains(text(),'Products')]") public WebElement productsMenu;

	public ProductsPage(WebDriver driver) {
		super();
	}
	
	TestUtil testUtil = new TestUtil();	

	public void clickProductMenu() {
		//new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(productsMenu)).click();
		testUtil.jsExecutorClick(productsMenu);
	}
	
	public WebElement productLink() {
		return new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(productLinks));

	}
	
}

