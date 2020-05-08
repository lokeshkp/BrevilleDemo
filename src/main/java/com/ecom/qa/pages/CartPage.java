package com.ecom.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.ecom.qa.base.BasePage;
import com.ecom.qa.util.TestUtil;

public class CartPage extends BasePage {

	@CacheLookup @FindBy(xpath = "//a[contains(text(),'Checkout as Guest')]") public WebElement checkOutButton;

	TestUtil testUtil = new TestUtil();

	public CartPage(WebDriver driver) {
		super();
	}
	
	
	public boolean verifyCheckOutButton() {
		return checkOutButton.isDisplayed();
	}

}
