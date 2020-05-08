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
import com.ecom.qa.util.TestUtil;
import com.beust.jcommander.Parameter;
import com.ecom.qa.base.BasePage;

public class RecipesPageTest extends BasePage{

	String sheetName = "products";
	public RecipesPageTest() {
		super();
	}

	RecipesPage reciPage;
	HomePage homePage;
	TestUtil testUtil = new TestUtil();

	@BeforeClass
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		reciPage = PageFactory.initElements(driver, RecipesPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
	}

	@Test(priority=1)
	public void selectRecipesTest() throws InterruptedException{
		//closePopup();
		reciPage.clickRecipesMenu();
		Thread.sleep(4000);
		testUtil.switchToWindow();
		driver.findElement(By.xpath("//span[text()='Recipes']")).isDisplayed();
		driver.switchTo().defaultContent();
	}

	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
