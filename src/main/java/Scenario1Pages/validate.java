package Scenario1Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.PageBase;

public class validate extends PageBase{

	@FindBy(className = "react-autosuggest__input")
	WebElement searchTextBox;
	@FindBy(xpath="//*[@id=\"main\"]/div/div/div[1]/div[2]/div/div/div/div/div/ul/li[1]/div/div/div/div/div/div[2]/div[1]/h2")
	WebElement course;
	public validate() {
		PageFactory.initElements(driver, this);
	}
	
	public void Click() {
		searchTextBox.click();
	}
	
	public HomePage text() {
		
		searchTextBox.sendKeys("web delevopment courses"+Keys.ENTER);
		return new HomePage();
		}
	
	public void Display() {
		System.out.println("Web Delevopment courses are:"+course.getText());
	}
}
