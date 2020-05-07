package com.ecom.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ecom.qa.base.BasePage;

public class RecipesPage extends BasePage {

	@CacheLookup @FindBy(xpath = "//div[@class='container']//div[@class='o-category-grid']") public WebElement partstLinks;

	@CacheLookup @FindBy(xpath = "//a[contains(text(),'Recipes')]") public WebElement recipesMenu;
	
	@CacheLookup @FindBy(xpath = "") public WebElement partsImages;

	public RecipesPage(WebDriver driver) {
		super();
	}

	public void clickRecipesMenu() {
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(recipesMenu)).click();
	}
	
}
