package com.ecom.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ecom.qa.base.BasePage;
import com.ecom.qa.util.TestUtil;

public class PartsAccessoriesPage extends BasePage{


	@CacheLookup @FindBy(xpath = "//div[@class='container']//div[@class='o-category-grid']") public WebElement partstLinks;

	@CacheLookup @FindBy(xpath = "//a[contains(text(),'Parts and Accessories')]") public WebElement partsMenu;
	
	@CacheLookup @FindBy(xpath = "") public WebElement partsImages;

	TestUtil testUtil = new TestUtil();	

	public PartsAccessoriesPage(WebDriver driver) {
		super();
	}

	public void clickProductMenu() {
		//new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(partsMenu)).click();
		testUtil.jsExecutorClick(partsMenu);
	}
	
	public WebElement productLink() {
		return new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(partstLinks));

	}
}
