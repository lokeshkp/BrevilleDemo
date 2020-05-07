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
import org.testng.annotations.Test;

import com.ecom.qa.pages.HomePage;
import com.ecom.qa.pages.PartsAccessoriesPage;
import com.ecom.qa.util.TestUtil;
import com.ecom.qa.base.BasePage;

public class PartsPageTest extends BasePage{

	String sheetName = "parts";
	public PartsPageTest() {
		super();
	}

	PartsAccessoriesPage partsPage;
	HomePage homePage;
	TestUtil testUtil = new TestUtil();

	@BeforeClass
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		//closePopup();
	}

	@Test(priority=1,dataProvider = "getEcomTestData")
	public void selectPartsAccessoriesPageTest(String partsName) throws InterruptedException{
		partsPage = PageFactory.initElements(driver, PartsAccessoriesPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		partsPage.clickProductMenu();
		Thread.sleep(4000);
		List<WebElement> parts = partsPage.partstLinks.findElements(By.tagName("a"));
		//new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElements(parts));
		for(WebElement part:parts) {
			if(part.getAttribute("data-item-name").equals(partsName)) {
				String partsNames[] = partsName.split(" ");
				partsName = partsNames[0];
				Thread.sleep(4000);
				part.click();
				WebElement re = driver.findElement(By.xpath("//img[contains(@alt,'"+partsName+"')]"));
				System.out.println(re.getText());
				Assert.assertTrue(driver.findElement(By.xpath("//img[contains(@alt,'"+partsName+"')]")).isDisplayed());
				System.err.println("Done");
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
