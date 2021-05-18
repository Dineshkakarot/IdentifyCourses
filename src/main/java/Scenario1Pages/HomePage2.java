package Scenario1Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.PageBase;

public class HomePage2 extends PageBase{

	
	@FindBy(xpath="//*[@id=\"__next\"]/header/div/div/div/div[1]/div[3]/div/form/div/div/div[1]/button[2]/div")
	static
	WebElement searchlogo;
	@FindBy(xpath="//h2[@class=\"carousel-heading bold body-1-text\"]")
	WebElement text;
	@FindBy(xpath="//*[@id=\"main\"]/div/div/div[1]/div[1]/div/div/div/div/div/div/div[4]/div/div/div/div/div/a/div/div[2]/span[1]/span")
	WebElement course;
	
	
	public HomePage2() {
		PageFactory.initElements(driver, this);
	}
	
	public void click() {
		searchlogo.click();
	}
	
	public boolean operation() {
		return text.isDisplayed();
	}
	
	public void courseDisplay() {
		System.out.println(text.getText()+"\n "+course.getText());
	}
}
