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

public class ProductsHomePageS5TC2 extends PageBase{

	LandingPage landingPage;
	String parentWindow;
	ProductsHome productsHome;
	String sheetName3 = "ThirdPage";
	
	
	public ProductsHomePageS5TC2() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		setupBrowser();
		landingPage = new LandingPage();
		productsHome = landingPage.navigateToForEnterprise();
	}
	
	@DataProvider
	public Object[][] getThirdPageData() {
		
		Object data[][] = TestUtil.getTestData(sheetName3);
		return data;
	}
	
	@Test(dataProvider = "getThirdPageData", groups = "Regression")
	public void fillingWithoutFirstName(String Fname,String JFunc, String JTitle, String Email, 
			String Phone, String Instiname, String Institype, String disp, String country, String state) {
		
		
		parentWindow = driver.getWindowHandle();
		productsHome.clickonForCampus();
		Set<String> handles2 = driver.getWindowHandles();
		Iterator<String> itr2 = handles2.iterator();
		while (itr2.hasNext()) {

			String childWindow1 = itr2.next();
			if (!childWindow1.contentEquals(parentWindow)) {
				driver.switchTo().window(childWindow1);
				productsHome.clickGetStarted();
				try {
					Thread.sleep(1000);
					productsHome.excelInvalidLastName(Fname, JFunc, JTitle, Email, Phone, Instiname, Institype,
							disp, country, state);
					
					Thread.sleep(2000);
					boolean flag = productsHome.lastnameErroDisplayed();
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
