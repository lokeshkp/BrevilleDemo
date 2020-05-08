package com.ecom.qa.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ecom.qa.base.BasePage;
import com.ecom.qa.pages.CartPage;
import com.ecom.qa.pages.SearchPage;
import com.ecom.qa.util.TestUtil;

public class CartsPageTest extends BasePage {

	CartPage cartPage;
	SearchPage searchPage;
	TestUtil testUtil = new TestUtil();
	String sheetName = "search";

	public CartsPageTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
	}

	@Test(dataProvider = "getEcomTestData")
	public void verifyCartPage(String prodName) throws InterruptedException {
		searchPage = PageFactory.initElements(driver, SearchPage.class);
		cartPage = PageFactory.initElements(driver, CartPage.class);
		searchPage.searchAndSelectProduct(prodName);
		Thread.sleep(6000);
		Assert.assertTrue(cartPage.verifyCheckOutButton());
	}
	
	@DataProvider
	public Object[][] getEcomTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
}
