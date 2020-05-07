package com.ecom.qa.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecom.qa.pages.HomePage;
import com.ecom.qa.pages.ProductsPage;
import com.ecom.qa.pages.RecipesPage;
import com.ecom.qa.pages.SearchPage;
import com.ecom.qa.pages.SignUpPage;
import com.ecom.qa.util.TestUtil;
import com.beust.jcommander.Parameter;
import com.ecom.qa.base.BasePage;

public class SearchPageTest extends BasePage{

	SearchPage searchPage;
	HomePage homePage;
	TestUtil testUtil = new TestUtil();
	String sheetName = "search";
	
	public SearchPageTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		//closePopup();
	}

	@Test(priority=1,dataProvider = "getEcomTestData")
	public void signUpLetterTest(String prodName) throws InterruptedException {
		searchPage = PageFactory.initElements(driver, SearchPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		searchPage.searchAndSelectProduct(prodName);
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
