package com.test.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.base.PageBase;
import com.test.pages.HomePage;
import com.test.pages.LandingPage;

//Scenario 1
public class LandingPageTest extends PageBase{
	
	LandingPage landingPage;
	HomePage homePage;
	
	public LandingPageTest() {
		super();
	}
	

	@BeforeMethod
	public void setUp() {
		setupBrowser();
		landingPage = new LandingPage();
	}
	
	@Test(priority = 0)
	public void landingPageTitleTest() {
		
		String actualTitle = landingPage.validateLandingPageTitle();
		Assert.assertEquals(actualTitle, "Coursera | Online Courses & Credentials From Top Educators. Join for Free");
	}
	
	@Test(priority = 1)
	public void pageLogoTest() {
		
		boolean flag = landingPage.validatePageLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 2)
	public void loginTest() {
		
		homePage = landingPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
