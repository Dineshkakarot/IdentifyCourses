package com.test.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.base.PageBase;

public class PageCourses extends PageBase{

	//Page Objects
	
	@FindBy(xpath = "//div[contains(text(),'Language')]")
	WebElement selectlang;
	
	@FindBy(xpath = "//div[@id='react-select-2--option-0']//div//button")
	WebElement selectEnglish;
	
	@FindBy(xpath = "//div[contains(text(),'Level')]")
	WebElement selectLevel;
	
	@FindBy(xpath = "//div[@id='react-select-3--option-0']//div//button")
	WebElement selectBeginner;
			
	@FindBy(xpath = "//h6[contains(text(),'English')]")
	WebElement checkLanguageFilter;
	
	@FindBy(xpath = "//h6[contains(text(),'Beginner')]")
	WebElement checkLevelFilter;
		
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/h2[1]")
	public WebElement firstCourseName;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/span[1]")
	WebElement firstCourseRating;
	
	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[5]/div[2]/div[1]/span[1]")
	public WebElement firstCourseHours;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/h2[1]")
	public WebElement secondCourseName;
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/span[1]")
	WebElement secondCourseRating;
	
	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[5]/div[2]/div[1]/span[1]")
	public WebElement secondCourseHours;
	//Initializing the Page Object
	public PageCourses() {
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions of the Page
	//Returns the Title of the page
	public String validatePageTitle() {
		
		return driver.getTitle();
	}
	
	//Selects the language filter option
	public void selectLanguage() {
		
		selectlang.click();
		selectEnglish.click();
	}
	
	//Selects the level filter option
	public void selectLevel() {
		
		selectLevel.click();
		selectBeginner.click();
	}
	
	//Returns if language is selected
	public boolean languangeDisplayed() {
		
		return checkLanguageFilter.isDisplayed();
	}
	
	//Returns if langage is selected
	public boolean levelDisplayed() {

		return checkLevelFilter.isDisplayed();
	}
	
	//Returns the name of the first course
	public String CourseName1() {
		
		String name1 = firstCourseName.getText();
		return name1;
	}
	
	//Returns the ratings of the first course
	public String CourseRating1() {
		
		String rating1 = firstCourseRating.getText();
		return rating1;
	}
	
	//Returns the name of the second course
	public String CourseName2() {

		String name2 = secondCourseName.getText();
		return name2;
	}
	
	//Returns the ratings of the second course
	public String CourseRating2() {

		String rating2 = secondCourseRating.getText();
		return rating2;
	}
	
	
}