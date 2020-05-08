package com.ecom.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import com.ecom.qa.base.BasePage;
import com.ecom.qa.util.TestUtil;

public class SignUpPage extends BasePage{

	@CacheLookup @FindBy(xpath = "//a[contains(text(),'Signup for Newsletter')]") public WebElement signupforNewsletterMenu;
	@CacheLookup @FindBy(xpath = "//input[@id='newsLetter-firstname']") public WebElement inputFName;
	@CacheLookup @FindBy(xpath = "//input[@id='newsLetter-lastname']") public WebElement inputLName;
	@CacheLookup @FindBy(xpath = "//input[@id='newsLetter-email-id']") public WebElement inputEmail;
	@CacheLookup @FindBy(xpath ="//input[@id='newsLetter-promotional-offer']") public WebElement chxPromotion;
	@CacheLookup @FindBy(xpath ="//button[text()='Submit']") public WebElement btnSubmit;

	TestUtil testUtil = new TestUtil();

	public SignUpPage(WebDriver driver) {
		super();
	}

	public void clickSignupNewsLetterTest() throws InterruptedException {
		Thread.sleep(3000);
		testUtil.jsExecutorClick(signupforNewsletterMenu);
	}
	
	public void enterSignUpInformation(String fName, String lName, String email) {		
		inputFName.sendKeys(fName);	
		inputLName.sendKeys(lName);
		inputEmail.sendKeys(email);
		testUtil.jsExecutorClick(chxPromotion);
		btnSubmit.submit();
	}
	
}
