package Scenario1Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.PageBase;

public class HomePage extends PageBase{
	
    public static long PAGE_LOAD_TIMEOUT = 40;
	
	public static long IMPLICIT_WAIT = 5;
	
	
	@FindBy(className = "react-autosuggest__input")
	WebElement searchTextBox;
	
	@FindBy(xpath="//div[@class=\"react-autosuggest__suggestions-container react-autosuggest__suggestions-container--open\"]")
	WebElement box;
	
	@FindBy(xpath="//span[@class=\"item-name body-1-text\"]")
	WebElement text;
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}

	public void clickBtn() {
		
		searchTextBox.click();
	}
	
	public boolean performOpertaion() {
		
		
		return box.isDisplayed();
	}
	public void Display() {
		System.out.println("Most Poplular courses are shown :"+text.getText());
	}
}
