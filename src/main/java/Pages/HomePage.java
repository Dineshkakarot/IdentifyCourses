package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.PageBase;

public class HomePage extends PageBase{

	@FindBy(className = "react-autosuggest__input")
	WebElement searchBox;
	

	//Intializing the Page Objects
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public PageCourses clickSearchbox() {
		
		searchBox.click();
		searchBox.sendKeys("web development courses" +Keys.ENTER);
		return new PageCourses();
	}
}
