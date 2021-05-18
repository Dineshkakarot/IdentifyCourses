package Scenario1;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.PageBase;
import Scenario1Pages.HomePage;
import Scenario1Pages.HomePage2;

public class HomePageTest2 extends PageBase {

	HomePage homePage;
	HomePage2 homePage2;
	
	public HomePageTest2() {
		super();
	}
	
	@BeforeClass
	public void setup() {
		setupBrowser();
		homePage2=new HomePage2();
		homePage2.click();
	}
	
	@Test
	public void checkcourse() {
		
		boolean flag1=homePage2.operation();
		Assert.assertTrue(flag1);
		
		homePage2.courseDisplay();
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
}