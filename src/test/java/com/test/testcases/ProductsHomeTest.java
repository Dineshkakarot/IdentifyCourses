package com.test.testcases;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.base.PageBase;

import com.test.pages.LandingPage;
import com.test.pages.ProductsHome;
import com.test.util.TestUtil;

public class ProductsHomeTest extends PageBase{

	
	LandingPage landingPage;
	String parentWindow;
	ProductsHome productsHome;
	
	String sheetName1 = "FirstPage";
	
	public ProductsHomeTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		setupBrowser();
		landingPage = new LandingPage();
		productsHome = landingPage.navigateToForEnterprise();
	}
	
	@Test(priority = 0, groups = "Smoke")
	public void validateFEHomePageTitle() {
		
		String actualTitle = productsHome.validatePageTitle();
		Assert.assertEquals(actualTitle, "Coursera for Business | Employee Training and Development Programs");
	}
	
	@DataProvider
	public Object[][] getTestData() {
		
		Object data[][] = TestUtil.getTestData(sheetName1);
		return data;
	}
	
	@Test(priority = 12, dataProvider = "getTestData" , groups = "Regression")
	public void fillingFormUsingValidDetails(String Fname, String Lname,String JFunc, String JTitle, String Email, 
			String Phone, String Instiname, String Institype, String disp, String country, String state) {
		
		parentWindow = driver.getWindowHandle();
		productsHome.clickonForCampus();
		Set<String> handles2 = driver.getWindowHandles();
		Iterator<String> itr2 = handles2.iterator();
		while(itr2.hasNext()) {
			
			String childWindow1 = itr2.next();
			if(!childWindow1.contentEquals(parentWindow)) {
				driver.switchTo().window(childWindow1);
				productsHome.clickGetStarted();
				try {
					Thread.sleep(1000);
					productsHome.execelAllValidDetails(Fname, Lname, JFunc, JTitle, Email, Phone, Instiname, Institype, disp, country, state);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				driver.close();
			}
			driver.switchTo().window(parentWindow);
		}
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}
