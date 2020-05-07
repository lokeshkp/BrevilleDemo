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
import com.ecom.qa.util.TestUtil;
import com.beust.jcommander.Parameter;
import com.ecom.qa.base.BasePage;

public class ProductsPageTest extends BasePage{

	String sheetName = "products";
	public ProductsPageTest() {
		super();
	}

	ProductsPage prodPage;
	HomePage homePage;
	TestUtil testUtil = new TestUtil();

	@BeforeClass
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		//closePopup();
	}

	@Test(priority=1,dataProvider = "getEcomTestData")
	public void selectProductTest(String productName) throws InterruptedException{
		prodPage = PageFactory.initElements(driver, ProductsPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		prodPage.clickProductMenu();
		Thread.sleep(4000);
		List<WebElement> products = prodPage.productLinks.findElements(By.tagName("a"));
		for(WebElement prod:products) {
			if(prod.getAttribute("data-item-name").equals(productName)) {
				prod.click();
				String expRes =  productName+" • Home "+productName+" | Breville";
				if(driver.getTitle().contains(expRes)) {
					logger.info(ProductsPageTest.class+" Passed");
				}else {
					logger.error(ProductsPageTest.class+" Failed");
				}
				break;
			}
		}
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
