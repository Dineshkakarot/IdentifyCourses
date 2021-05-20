package com.test.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.test.base.PageBase;
import com.test.pages.LanguageAndLevel;

public class LanguageAndLevelTest extends PageBase {
	LanguageAndLevel languageAndlevel;
	
	public LanguageAndLevelTest() {
		
			super();
		}
	
	@BeforeTest
	public void setUp() {
		
		setupBrowser();
		languageAndlevel=new LanguageAndLevel();
		languageAndlevel.clickSearchbox();
	}
	
	@Test(priority=1)
	public void testLanguageCheckBox() {
		boolean result=languageAndlevel.languageCheckBox();
		Assert.assertTrue(result);
	}
	
	@Test(priority=2)
	public void testLanguageClear() {
		boolean result=languageAndlevel.languageClear();
		Assert.assertFalse(result);
	}
	
	@Test(priority=0)
	public void testLanguageShowAll() {
		boolean result=languageAndlevel.languageShowAll();
		Assert.assertTrue(result);
		System.out.println("List of Languages");
		int count1=languageAndlevel.languageListLeft();
		int count2=languageAndlevel.languageListRight();
		System.out.println("Total no of Languages: "+(count1+count2));
	}
	
	@Test(priority=3)
	public void testLevelCheckBox() {
		System.out.println("List of Levels");
		int count=languageAndlevel.levelList();
		System.out.println("Total no of Levels: "+count);
		boolean result=languageAndlevel.levelCheckBox();
		Assert.assertTrue(result);
	}
	
	@Test(priority=4)
	public void testLevelClear() {
		boolean result=languageAndlevel.levelClear();
		Assert.assertFalse(result);
	}
	
	@AfterTest
	public void closeBrowser() {
		
		driver.quit();
	}
	
}
