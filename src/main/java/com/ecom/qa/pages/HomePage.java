package com.ecom.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ecom.qa.base.BasePage;

public class HomePage extends BasePage{

	WebDriver driver;

	@CacheLookup @FindBy(xpath = "//img[@title='Breville']") public WebElement imageTitle;

	@CacheLookup @FindBy(xpath = "//a[contains(text(),'Products')]") public WebElement productsMenu;

	@CacheLookup @FindBy(xpath = "//a[contains(text(),'Parts and Accessories')]") public WebElement partsAndAccessoriesLink;
	
	@CacheLookup @FindBy(xpath = "//a[contains(text(),'Recipes')]") public WebElement recipesLink;
	
	@CacheLookup @FindBy(xpath = "//a[contains(text(),'Signup for News')]") public WebElement signupforNewsLink;

	@CacheLookup @FindBy(xpath = "//span[text()='Call']") public WebElement callButton;
	
	@CacheLookup @FindBy(xpath = "//span[text()='Search']") public WebElement searchButton;

	@CacheLookup @FindBy(xpath = "//span[text()='Cart']") public WebElement cartButton;
	
	
	// Initializing the Page Objects:
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public String verifyCompanyLogoTitle(){
		return imageTitle.getAttribute("alt");
	}
	
	public boolean verifyProductLink(){
		
		return new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(productsMenu)).isDisplayed();
	}
	
	public boolean verifyPartsAccessoriesLink(){
		return new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(partsAndAccessoriesLink)).isDisplayed();
	}
	
	public boolean verifyRecipesLink(){
		return new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(recipesLink)).isDisplayed();
	}
	
	public boolean verifySignupforNewsLink(){
		return new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(signupforNewsLink)).isDisplayed();
	}
	
	public boolean verifyCallButton(){
		return new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(callButton)).isDisplayed();
	}
	
	public boolean verifySearchButton(){
		return new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(searchButton)).isDisplayed();
	}
	
	public boolean verifyCartButton(){
		return new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(cartButton)).isDisplayed();
	}
	

	// ********************************************************************************************//
	
	
	public ProductsPage clickOnProductsLink(){
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(productsMenu)).click();
		return new ProductsPage(driver);
	}
	
	public PartsAccessoriesPage clickOnPartsAccessoriesLink(){
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(partsAndAccessoriesLink)).click();
		return new PartsAccessoriesPage(driver);
	}
	
	public RecipesPage clickOnRecipessLink(){
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(recipesLink)).click();
		return new RecipesPage(driver);
	}
	
	public SignUpPage clickOnSignupForNewsLink(){
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(signupforNewsLink)).click();
		return new SignUpPage(driver);
	}
	
	public void clickOnCallButton(){
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(callButton)).click();
	}
	
	public SearchPage clickOnSearchButton(){
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(searchButton)).click();
		return new SearchPage(driver);
	}
	
	public CartPage clickOnCartButton(){
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(cartButton)).click();
		return new CartPage();
	}
	
	// ********************************************************************************************//


}
