package com.ecom.qa.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ecom.qa.pages.HomePage;
import com.ecom.qa.util.TestUtil;
import com.ecom.qa.base.BasePage;

public class HomePageTest extends BasePage{

	public HomePageTest() {
		super();
	}

	HomePage homePage;
	TestUtil testUtil = new TestUtil();
	
	@BeforeClass
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage = PageFactory.initElements(driver, HomePage.class);
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		logger.info("Verifying Home Page Title");
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Home");
	}
	
	@Test(priority=2)
	public void verifyCompanyLogoTitleTest(){
		logger.info("Company Logo Title");
		Assert.assertEquals(homePage.verifyCompanyLogoTitle(),"Breville");
	}
	
	@Test(priority=3)
	public void verifyProductsLinkTest(){
		logger.info("Verifying product link");
		Assert.assertTrue(homePage.verifyProductLink());
	}
	
	@Test(priority=4)
	public void verifyPartsAccessoriesLinkTest(){
		Assert.assertTrue(homePage.verifyPartsAccessoriesLink());
	}
	
	@Test(priority=5)
	public void verifyRecipesLinkTest(){
		Assert.assertTrue(homePage.verifyRecipesLink());
	}
	
	@Test(priority=6)
	public void verifySignupforNewsLinkTest(){
		Assert.assertTrue(homePage.verifySignupforNewsLink());
	}
	
	@Test(priority=7)
	public void verifyCallButtonTest(){
		Assert.assertTrue(homePage.verifyCallButton());
	}
	
	@Test(priority=8)
	public void verifySearchButtonTest(){
		Assert.assertTrue(homePage.verifySearchButton());
	}
	
	@Test(priority=9)
	public void verifyCartButtonTest(){
		Assert.assertTrue(homePage.verifyCartButton());
	}
	
	
	
	@Test(priority=10, dependsOnMethods = "verifyProductsLinkTest")
	public void clickOnProductsLinkTest() throws InterruptedException{
		homePage.clickOnProductsLink();
		//Thread.sleep(5000);
	}
	
	@Test(priority=11, dependsOnMethods = "verifyPartsAccessoriesLinkTest")
	public void clickOnPartsAccessoriesLinkTest() throws InterruptedException{
		homePage.clickOnPartsAccessoriesLink();
	}
	
	@Test(priority=12, dependsOnMethods = "verifyRecipesLinkTest")
	public void clickOnRecipessLinkTest() throws InterruptedException{
		homePage.clickOnRecipessLink();
	}
	
	//@Test(priority=13, dependsOnMethods = "verifySignupforNewsLinkTest")
	public void clickOnSignupForNewsLinkTest() throws InterruptedException{
		homePage.clickOnSignupForNewsLink();
	}

	//@Test(priority=14, dependsOnMethods = "verifyCallButtonTest")
	public void clickOnCallButtonTest() throws InterruptedException{
		homePage.clickOnCallButton();
	}

	@Test(priority=15, dependsOnMethods = "verifySearchButtonTest")
	public void clickOnSearchButtonTest() throws InterruptedException{
		Thread.sleep(5000);
		homePage.clickOnSearchButton();
	}

	@Test(priority=16, dependsOnMethods = "verifyCartButtonTest")
	public void clickOnCartButtonTest() throws InterruptedException{
		Thread.sleep(5000);
		homePage.clickOnCartButton();
	}
	
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
}
