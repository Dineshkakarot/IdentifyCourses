package com.test.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

import com.test.base.PageBase;

public class LanguageAndLevel extends PageBase {
	@FindBy(xpath = "//*[@id=\"__next\"]/header/div/div/div/div[1]/div[3]/div/form/div/div/div[1]/button[2]/div")
	WebElement search;
	
	@FindBy(xpath = "//div[contains(text(),'Language')]")
	WebElement languageFilter;
	
	@FindBy(xpath = "//*[@id='react-select-2--option-0']/div/button")
	WebElement english;
	
	@FindBy(xpath = "//h6[contains(text(),'English')]")
	WebElement English;
	
	@FindBy(xpath = "//h6[contains(text(),'×')]")
	WebElement x;
	
	@FindBy(xpath = "//button[@data-track-component='language_filter_clear_button']")
	WebElement languageClear;
	
	@FindBy(xpath = "//button[contains(text(),'Show All')]")
	WebElement showAll;
	
	@FindBy(xpath = "//div[@class='c-modal-content']")
	WebElement showAllLanguage;
	
	@FindBy(xpath = "//a[contains(text(),'✕')]")
	WebElement languageShowAllX;
	
	@FindBy(xpath = "//div[contains(text(),'Level')]")
	WebElement levelFilter;
	
	@FindBy(xpath = "//*[@id=\"react-select-3--option-0\"]/div/button/label/input")
	WebElement beginner;
	
	@FindBy(xpath = "//h6[contains(text(),'Beginner')]")
	WebElement Beginner;
	
	@FindBy(xpath = "//button[@data-track-component='level_filter_clear_button']")
	WebElement levelClear;
	
	@FindBy(xpath = "//button[contains(text(),'Clear All')]")
	WebElement clearAll;
	
	public LanguageAndLevel() {
		
			PageFactory.initElements(driver, this);
	}
	
public void clickSearchbox() {
		
		search.click();
		//return new PageCourses();
		
		
	}
public boolean languageCheckBox() {
	
	languageFilter.click();
	english.click();	
	boolean flag= English.isDisplayed();
	clearAll.click();
	return flag;
}
public boolean languageClear() {
	languageFilter.click();
	english.click();
	languageFilter.click();
	languageClear.click();	
	boolean flag= english.isSelected();
	languageFilter.click();
	return flag;
}
public boolean languageShowAll() {
	languageFilter.click();
	showAll.click();
	boolean flag= showAllLanguage.isDisplayed();
	return flag;
}
public boolean levelCheckBox() {
	
	levelFilter.click();
	beginner.click();	
	boolean flag= Beginner.isDisplayed();
	clearAll.click();
	return flag;
}
public boolean levelClear() {
	levelFilter.click();
	beginner.click();
	levelFilter.click();
	levelClear.click();	
	boolean flag= beginner.isSelected();
	levelFilter.click();
	return flag;
}
public int levelList(){	
	levelFilter.click();
	int count=0;
	WebElement level=driver.findElement(By.xpath("//*[@id=\"react-select-3--list\"]"));
	List<WebElement> Levels=level.findElements(By.tagName("div"));
	int i=0;
	int j=2;
	int k=3;
	String lvl=null,cnt= null;
	boolean flag1=false;
	boolean flag2=false;
	for(WebElement skil:Levels){
		String text=skil.getText();
		if(i!=0 && i%j==0) {
			lvl=text;
			j=j+4;
			flag1=true;
		}
		if(i!=0 && i%k==0) {
			cnt=text;
			k=k+4;
			flag2=true;
		}
		i++;
		if(flag1 && flag2) {
			System.out.println(lvl+" "+cnt);
			count++;
			flag1=false;
			flag2=false;
		}	
	}
	levelFilter.click();
	return count;
}

public int languageListLeft(){
	int count=0;
	WebElement language=driver.findElement(By.xpath("//div[@class='filters-modal-content horizontal-box']/div[1]"));
	List<WebElement> Languages=language.findElements(By.tagName("div"));
	int i=0;
	int j=1;
	int k=2;
	String lng=null,cnt= null;
	boolean flag1=false;
	boolean flag2=false;
	for(WebElement skil:Languages){
		String text=skil.getText();
		if(i!=0 && i%j==0) {
			lng=text;
			j=j+3;
			flag1=true;
		}
		if(i!=0 && i%k==0) {
			cnt=text;
			k=k+3;
			flag2=true;
		}
		i++;
		if(flag1 && flag2) {
			System.out.println(lng+" "+cnt);
			count++;
			flag1=false;
			flag2=false;
		}
	}
	return count;
}

public int languageListRight(){	
	int count=0;
	WebElement language=driver.findElement(By.xpath("//div[@class='filters-modal-content horizontal-box']/div[2]"));
	List<WebElement> Languages=language.findElements(By.tagName("div"));
	int i=0;
	int j=1;
	int k=2;
	String lng=null,cnt= null;
	boolean flag1=false;
	boolean flag2=false;
	for(WebElement skil:Languages){
		String text=skil.getText();
		if(i!=0 && i%j==0) {
			lng=text;
			j=j+3;
			flag1=true;
		}
		if(i!=0 && i%k==0) {
			cnt=text;
			k=k+3;
			flag2=true;
		}
		i++;
		if(flag1 && flag2) {
			System.out.println(lng+" "+cnt);
			count++;
			flag1=false;
			flag2=false;
		}
	}
	languageShowAllX.click();
	return count;
}
}
