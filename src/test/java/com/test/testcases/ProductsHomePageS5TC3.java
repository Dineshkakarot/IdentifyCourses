package com.test.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.test.base.PageBase;
import com.test.pages.LandingPage;
import com.test.pages.ProductsHome;
import com.test.util.TestUtil;

public class ProductsHomePageS5TC3 extends PageBase{

	LandingPage landingPage;
	String parentWindow;
	ProductsHome productsHome;
	String sheetName4 = "FourthPage";
	
	public ProductsHomePageS5TC3() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		setupBrowser();
		landingPage = new LandingPage();
		productsHome = landingPage.navigateToForEnterprise();
	}
	
	@DataProvider
	public Object[][] getFourthPageData() {
		
		Object data[][] = TestUtil.getTestData(sheetName4);
		return data;
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}
