package com.test.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.base.PageBase;

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
	
	//Error messages that user gets for invlaid details webelement locators
	@FindBy(xpath = "//div[@id='ValidMsgFirstName']")
	WebElement firstnameError;
	
	@FindBy(xpath = "//div[@id='ValidMsgLastName']")
	WebElement lastnameError;

	@FindBy(xpath = "//div[@id='ValidMsgC4C_Job_Title__c']")
	WebElement jobFunctionError;
	
	@FindBy(xpath = "//div[@id='ValidMsgTitle']")
	WebElement jobTitleError;
	
	@FindBy(xpath = "//div[@id='ValidMsgEmail']")
	WebElement emailError;
	
	@FindBy(xpath = "//div[@id='ValidMsgPhone']")
	WebElement phoneError;
	
	@FindBy(xpath = "//div[@id='ValidMsgCompany']")
	WebElement instituteNameError;
	
	@FindBy(xpath = "//div[@id='ValidMsgInstitution_Type__c']")
	WebElement instituteTypeError;
	
	@FindBy(xpath = "//div[@id='ValidMsgPrimary_Discipline__c']")
	WebElement disciplineError;
	
	@FindBy(xpath = "//div[@id='ValidMsgCountry']")
	WebElement countryError;
	
	@FindBy(xpath = "//div[@id='ValidMsgState']")
	WebElement stateError;
	
	
	// Initializing the pageobjects
	public ProductsHome() {

		PageFactory.initElements(driver, this);
	}

	// Return the page title
	public String validatePageTitle() {

		return driver.getTitle();
	}

	// It will select the For Campus option from products
	public void clickonForCampus() {

		Actions action = new Actions(driver);
		action.moveToElement(Products);
		action.build().perform();
		ForCampus.click();

	}
	
	//Checks if the First name error is diplayed or not
	public boolean firstnameErrorDisplayed() {
		
		return firstnameError.isDisplayed();
	}

	//Checks if the second course error is displayed or not
	public boolean lastnameErroDisplayed() {

		return lastnameError.isDisplayed();
	}
	
	//Chceks if the job title course error is displayed or not
	public boolean jobFunctionErrorDisplayed() {

		return jobFunctionError.isDisplayed();
	}
	
	public boolean jobTitleErrorDisplayed() {

		return jobTitleError.isDisplayed();
	}
	
	public boolean emailErrorDisplayed() {

		return emailError.isDisplayed();
	}
	
	public boolean phoneErrorDisplayed() {

		return phoneError.isDisplayed();
	}
	
	public boolean instituteNameErrorDisplayed() {

		return instituteNameError.isDisplayed();
	}
	
	public boolean instituteTypeErrorDisplayed() {

		return instituteTypeError.isDisplayed();
	}
	
	public boolean disciplineErrorDisplayed() {

		return disciplineError.isDisplayed();
	}
	
	public boolean countryErrorDisplayed() {

		return countryError.isDisplayed();
	}
	
	public boolean stateErrorDisplayed() {

		return stateError.isDisplayed();
	}

	public void clickGetStarted() {

		getStarted.click();
	}
	
	//For invlaid FirstName and fill other details
	public void excelInvalidFirstName(String Lname, String JFunc, String JTitle, String Email, String Phone,
			String Instiname, String Institype, String disp, String country, String state) {

		LastName.sendKeys(Lname);
		Select select1 = new Select(selectJobFunction);
		select1.selectByVisibleText(JFunc);
		JobTitle.sendKeys(JTitle);
		EmailId.sendKeys(Email);
		PhoneNumber.sendKeys(Phone);
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
	
	
	//For invalid lastname and fill other details
	public void excelInvalidLastName(String Fname, String JFunc, String JTitle, String Email, String Phone,
			String Instiname, String Institype, String disp, String country, String state) {

		FirstName.sendKeys(Fname);
		Select select1 = new Select(selectJobFunction);
		select1.selectByVisibleText(JFunc);
		JobTitle.sendKeys(JTitle);
		EmailId.sendKeys(Email);
		PhoneNumber.sendKeys(Phone);
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
	
	//For invalid Job Function and fill other details
	public void excelInvalidJobFunction(String Fname, String Lname, String JTitle, String Email, String Phone,
			String Instiname, String Institype, String disp, String country, String state) {

		FirstName.sendKeys(Fname);
		LastName.sendKeys(Lname);
		JobTitle.sendKeys(JTitle);
		EmailId.sendKeys(Email);
		PhoneNumber.sendKeys(Phone);
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
	
	public void execelInvalidJobTitle(String Fname, String Lname, String JFunc, String Email, String Phone,
			String Instiname, String Institype, String disp, String country, String state) {

		FirstName.sendKeys(Fname);
		LastName.sendKeys(Lname);
		Select select1 = new Select(selectJobFunction);
		select1.selectByVisibleText(JFunc);

		EmailId.sendKeys(Email);
		PhoneNumber.sendKeys(Phone);
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
	
	public void execelInvalidEmail(String Fname, String Lname, String JFunc, String JTitle, String Phone,
			String Instiname, String Institype, String disp, String country, String state) {

		FirstName.sendKeys(Fname);
		LastName.sendKeys(Lname);
		Select select1 = new Select(selectJobFunction);
		select1.selectByVisibleText(JFunc);
		JobTitle.sendKeys(JTitle);
		
		PhoneNumber.sendKeys(Phone);
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
	
	public void execelInvalidPhone(String Fname, String Lname, String JFunc, String JTitle, String Email,
			String Instiname, String Institype, String disp, String country, String state) {

		FirstName.sendKeys(Fname);
		LastName.sendKeys(Lname);
		Select select1 = new Select(selectJobFunction);
		select1.selectByVisibleText(JFunc);
		JobTitle.sendKeys(JTitle);
		EmailId.sendKeys(Email);
		
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
	
	public void execelInvalidInstituteName(String Fname, String Lname, String JFunc, String JTitle, String Email, String Phone,
			String Institype, String disp, String country, String state) {

		FirstName.sendKeys(Fname);
		LastName.sendKeys(Lname);
		Select select1 = new Select(selectJobFunction);
		select1.selectByVisibleText(JFunc);
		JobTitle.sendKeys(JTitle);
		EmailId.sendKeys(Email);
		PhoneNumber.sendKeys(Phone);
		
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
	
	public void execelInvalidInstituteType(String Fname, String Lname, String JFunc, String JTitle, String Email, String Phone,
			String Instiname, String disp, String country, String state) {

		FirstName.sendKeys(Fname);
		LastName.sendKeys(Lname);
		Select select1 = new Select(selectJobFunction);
		select1.selectByVisibleText(JFunc);
		JobTitle.sendKeys(JTitle);
		EmailId.sendKeys(Email);
		PhoneNumber.sendKeys(Phone);
		InstitutionName.sendKeys(Instiname);
		
		Select select3 = new Select(selectDiscipline);
		select3.selectByVisibleText(disp);
		Select select4 = new Select(selectCountry);
		select4.selectByVisibleText(country);
		Select select5 = new Select(selectState);
		select5.selectByVisibleText(state);
		submit.click();
	}
	
	public void execelInvalidDiscipline(String Fname, String Lname, String JFunc, String JTitle, String Email, String Phone,
			String Instiname, String Institype, String country, String state) {

		FirstName.sendKeys(Fname);
		LastName.sendKeys(Lname);
		Select select1 = new Select(selectJobFunction);
		select1.selectByVisibleText(JFunc);
		JobTitle.sendKeys(JTitle);
		EmailId.sendKeys(Email);
		PhoneNumber.sendKeys(Phone);
		InstitutionName.sendKeys(Instiname);
		Select select2 = new Select(selectInstitutionType);
		select2.selectByVisibleText(Institype);
		
		Select select4 = new Select(selectCountry);
		select4.selectByVisibleText(country);
		Select select5 = new Select(selectState);
		select5.selectByVisibleText(state);
		submit.click();
	}
	
	public void execelInvalidCountry(String Fname, String Lname, String JFunc, String JTitle, String Email, String Phone,
			String Instiname, String Institype, String disp, String state) {

		FirstName.sendKeys(Fname);
		LastName.sendKeys(Lname);
		Select select1 = new Select(selectJobFunction);
		select1.selectByVisibleText(JFunc);
		JobTitle.sendKeys(JTitle);
		EmailId.sendKeys(Email);
		PhoneNumber.sendKeys(Phone);
		InstitutionName.sendKeys(Instiname);
		Select select2 = new Select(selectInstitutionType);
		select2.selectByVisibleText(Institype);
		Select select3 = new Select(selectDiscipline);
		select3.selectByVisibleText(disp);
		
		Select select5 = new Select(selectState);
		select5.selectByVisibleText(state);
		submit.click();
	}
	
	public void execelInvalidState(String Fname, String Lname, String JFunc, String JTitle, String Email, String Phone,
			String Instiname, String Institype, String disp, String country) {

		FirstName.sendKeys(Fname);
		LastName.sendKeys(Lname);
		Select select1 = new Select(selectJobFunction);
		select1.selectByVisibleText(JFunc);
		JobTitle.sendKeys(JTitle);
		EmailId.sendKeys(Email);
		PhoneNumber.sendKeys(Phone);
		InstitutionName.sendKeys(Instiname);
		Select select2 = new Select(selectInstitutionType);
		select2.selectByVisibleText(Institype);
		Select select3 = new Select(selectDiscipline);
		select3.selectByVisibleText(disp);
		Select select4 = new Select(selectCountry);
		select4.selectByVisibleText(country);
		
		submit.click();
	}

	// For entering all the valid details in the form
	public void execelAllValidDetails(String Fname, String Lname, String JFunc, String JTitle, String Email, String Phone,
			String Instiname, String Institype, String disp, String country, String state) {

		FirstName.sendKeys(Fname);
		LastName.sendKeys(Lname);
		Select select1 = new Select(selectJobFunction);
		select1.selectByVisibleText(JFunc);
		JobTitle.sendKeys(JTitle);
		EmailId.sendKeys(Email);
		PhoneNumber.sendKeys(Phone);
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
