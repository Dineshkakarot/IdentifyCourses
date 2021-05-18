package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import BaseClass.PageBase;

public class ProductsHome extends PageBase {

	// PageObjects
	//WebElement locators
	@FindBy(xpath = "//div[@class = 'menu-menu-1-container']//li[2]")
	WebElement Products;

	@FindBy(xpath = "//a[@target='_blank'][contains(text(),'For Campus')]")
	WebElement ForCampus;

	@FindBy(xpath = "//a[contains(text(),'Get Started')]")
	WebElement getStarted;

	// Filling form text fields webelement locators
	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement FirstName;

	@FindBy(xpath = "//input[@id='LastName']")
	WebElement LastName;

	@FindBy(xpath = "//input[@id='Title']")
	WebElement JobTitle;

	@FindBy(xpath = "//input[@id='Email']")
	WebElement EmailId;

	@FindBy(xpath = "//input[@id='Phone']")
	WebElement PhoneNumber;

	@FindBy(xpath = "//input[@id='Company']")
	WebElement InstitutionName;

	// Select Options from dropdown WebElements locators
	@FindBy(xpath = "//select[@id='C4C_Job_Title__c']")
	WebElement selectJobFunction;

	@FindBy(xpath = "//select[@id='Institution_Type__c']")
	WebElement selectInstitutionType;

	@FindBy(xpath = "//select[@id='Primary_Discipline__c']")
	WebElement selectDiscipline;

	@FindBy(xpath = "//select[@id='Country']")
	WebElement selectCountry;

	@FindBy(xpath = "//select[@id='State']")
	WebElement selectState;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit;
	
	
	
	@FindBy(xpath = "//div[@id='ValidMsgEmail']")
	WebElement emailError;
	
	
	// Initializing the pageobjects
	public ProductsHome() {

		PageFactory.initElements(driver, this);
	}

	// It will select the For Campus option from products
	public void clickonForCampus() {

		Actions action = new Actions(driver);
		action.moveToElement(Products);
		action.build().perform();
		ForCampus.click();

	}
	
	public boolean emailErrorDisplayed() {

		return emailError.isDisplayed();
	}
	
	

	public void clickGetStarted() {

		getStarted.click();
	}
	
	
	public void execelInvalidEmail(String Fname, String Lname, String JFunc, String JTitle,
			String Instiname, String Institype, String disp, String country, String state) {

		FirstName.sendKeys(Fname);
		LastName.sendKeys(Lname);
		Select select1 = new Select(selectJobFunction);
		select1.selectByVisibleText(JFunc);
		JobTitle.sendKeys(JTitle);
		
		PhoneNumber.sendKeys("503-555-1212");
		InstitutionName.sendKeys(Instiname);
		Select select2 = new Select(selectInstitutionType);
		select2.selectByVisibleText(Institype);
		Select select3 = new Select(selectDiscipline);
		select3.selectByVisibleText(disp);
		Select select4 = new Select(selectCountry);
		select4.selectByVisibleText(country);
		Select select5 = new Select(selectState);
		select5.selectByVisibleText(state);
		submit.click();
	}

	// For entering all the valid details in the form
	public void execelAllValidDetails(String Fname, String Lname, String JFunc, String JTitle, String Email, 
			String Instiname, String Institype, String disp, String country, String state) {

		FirstName.sendKeys(Fname);
		LastName.sendKeys(Lname);
		Select select1 = new Select(selectJobFunction);
		select1.selectByVisibleText(JFunc);
		JobTitle.sendKeys(JTitle);
		EmailId.sendKeys(Email);
		PhoneNumber.sendKeys("503-555-1212");
		InstitutionName.sendKeys(Instiname);
		Select select2 = new Select(selectInstitutionType);
		select2.selectByVisibleText(Institype);
		Select select3 = new Select(selectDiscipline);
		select3.selectByVisibleText(disp);
		Select select4 = new Select(selectCountry);
		select4.selectByVisibleText(country);
		Select select5 = new Select(selectState);
		select5.selectByVisibleText(state);
		submit.click();
	}
}
