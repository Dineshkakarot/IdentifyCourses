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

public class ProductsHomePageS5TC1  extends PageBase{
	
	LandingPage landingPage;
	String parentWindow;
	ProductsHome productsHome;
	String sheetName2 = "SecondPage";
	
	
	public ProductsHomePageS5TC1() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		setupBrowser();
		landingPage = new LandingPage();
		productsHome = landingPage.navigateToForEnterprise();
	}
	
	
	@DataProvider
	public Object[][] getSecondPageData() {
		
		Object data[][] = TestUtil.getTestData(sheetName2);
		return data;
	}
	
	@Test(dataProvider = "getSecondPageData", groups = "Regression")
	public void fillingWithoutFirstName(String Lname,String JFunc, String JTitle, String Email, 
			String Phone, String Instiname, String Institype, String disp, String country, String state) {
		
		
		parentWindow = driver.getWindowHandle();
		productsHome.clickonForCampus();
		Set<String> handles1 = driver.getWindowHandles();
		Iterator<String> itr1 = handles1.iterator();
		while (itr1.hasNext()) {

			String childWindow1 = itr1.next();
			if (!childWindow1.contentEquals(parentWindow)) {
				driver.switchTo().window(childWindow1);
				productsHome.clickGetStarted();
				try {
					Thread.sleep(1000);
					productsHome.excelInvalidFirstName(Lname, JFunc, JTitle, Email, Phone, Instiname, Institype,
							disp, country, state);
					
					Thread.sleep(2000);
					boolean flag = productsHome.firstnameErrorDisplayed();
					Assert.assertTrue(flag);
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
