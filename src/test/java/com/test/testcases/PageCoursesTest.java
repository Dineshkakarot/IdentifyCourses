package com.test.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.test.base.PageBase;
import com.test.pages.HomePage;
import com.test.pages.LandingPage;
import com.test.pages.PageCourses;

public class PageCoursesTest extends PageBase{

	LandingPage landingPage;
	HomePage homePage;
	PageCourses pageCourses;
	public PageCoursesTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		setupBrowser();
		landingPage = new LandingPage();
		homePage = new HomePage();
		pageCourses = new  PageCourses();
		pageCourses = homePage.clickSearchbox();
		
	}
	
	@Test(priority = 0, groups= {"Smoke"})
	public void validatePageTitle() {
		
		String title = pageCourses.validatePageTitle();
		Assert.assertEquals(title, "Top Web Development Courses Courses - Learn Web Development Courses Online | Coursera");
	}
	
	@Test(priority = 1, groups= {"Smoke"})
	public void selectFilter() {
		
		pageCourses.selectLanguage();
		pageCourses.selectLevel();
		boolean flag1 = pageCourses.languangeDisplayed();
		Assert.assertTrue(flag1);
		boolean flag2 = pageCourses.levelDisplayed();
		Assert.assertTrue(flag2);
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}

