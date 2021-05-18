package Scenario1;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.PageBase;
import Scenario1Pages.HomePage;

public class HomePageTest extends PageBase{
	
	HomePage homePage;
	
	public HomePageTest() {
		
		super();
	}
	
	@BeforeClass
	public void openBrowser() {
		
		setupBrowser();
		homePage = new HomePage();
		homePage.clickBtn();
	}
	
	@Test
	public void check() {
		
		boolean flag1 = homePage.performOpertaion();
		Assert.assertTrue(flag1);
		driver.manage().timeouts().implicitlyWait(HomePage.IMPLICIT_WAIT, TimeUnit.SECONDS);

		homePage.Display();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
