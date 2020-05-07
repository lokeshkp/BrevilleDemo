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
import com.ecom.qa.pages.SignUpPage;
import com.ecom.qa.util.TestUtil;
import com.beust.jcommander.Parameter;
import com.ecom.qa.base.BasePage;

public class SignUpPageTest extends BasePage{

	SignUpPage signPage;
	HomePage homePage;
	TestUtil testUtil = new TestUtil();
	String sheetName = "singUp";
	
	public SignUpPageTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		signPage = PageFactory.initElements(driver, SignUpPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		//closePopup();
	}

	@Test(priority=1,dataProvider = "getEcomTestData")
	public void signUpLetterTest(String fName, String lName, String email) throws InterruptedException {
		signPage.clickSignupNewsLetterTest();
		Thread.sleep(4000);
		signPage.enterSignUpInformation(fName, lName, email);;
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
