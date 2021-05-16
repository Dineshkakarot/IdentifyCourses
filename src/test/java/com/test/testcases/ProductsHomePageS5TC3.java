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
	
	
	// Fill the details except JobFunction and check for error gets displayed or not.
	
	@Test(dataProvider = "getFourthPageData", groups = "Regression")
	public void fillingWithoutFirstName(String Fname, String Lname, String JTitle, String Email, String Phone,
			String Instiname, String Institype, String disp, String country, String state) {

		parentWindow = driver.getWindowHandle();
		productsHome.clickonForCampus();
		Set<String> handles3 = driver.getWindowHandles();
		Iterator<String> itr3 = handles3.iterator();
		while (itr3.hasNext()) {

			String childWindow1 = itr3.next();
			if (!childWindow1.contentEquals(parentWindow)) {
				driver.switchTo().window(childWindow1);
				productsHome.clickGetStarted();
				try {
					Thread.sleep(1000);
					productsHome.excelInvalidJobFunction(Fname, Lname, JTitle, Email, Phone, Instiname, Institype, disp,
							country, state);

					Thread.sleep(2000);
					boolean flag = productsHome.jobFunctionErrorDisplayed();
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
