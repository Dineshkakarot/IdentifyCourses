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

public class ProductsHomeTest extends PageBase {

	LandingPage landingPage;
	String parentWindow;
	ProductsHome productsHome;

	String sheetName1 = "FirstPage";
	String sheetName2 = "SecondPage";
	String sheetName3 = "ThirdPage";
	String sheetName4 = "FourthPage";
	String sheetName5 = "FifthPage";
	String sheetName6 = "SixthPage";
	String sheetName7 = "SeventhPage";
	String sheetName8 = "8th Page";

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
	public Object[][] getFirstPageData() {

		Object data[][] = TestUtil.getTestData(sheetName1);
		return data;
	}

	@Test(priority = 12, dataProvider = "getFirstPageData", groups ="Regression")
	public void fillingFormUsingValidDetails(String Fname, String Lname, String JFunc, String JTitle, String Email,
			String Instiname, String Institype, String disp, String country, String state) {

		parentWindow = driver.getWindowHandle();
		productsHome.clickonForCampus();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		while (itr.hasNext()) {

			String childWindow1 = itr.next();
			if (!childWindow1.contentEquals(parentWindow)) {
				driver.switchTo().window(childWindow1);
				productsHome.clickGetStarted();
				try {
					Thread.sleep(1000);
					productsHome.execelAllValidDetails(Fname, Lname, JFunc, JTitle, Email, Instiname, Institype, disp,
							country, state);

				} catch (Exception e) {
					e.printStackTrace();
				}
				driver.close();
			}
			driver.switchTo().window(parentWindow);
		}
	}

	@DataProvider
	public Object[][] getSecondPageData() {

		Object data[][] = TestUtil.getTestData(sheetName2);
		return data;
	}

	@Test(priority = 1, dataProvider = "getSecondPageData", groups = "Regression")
	public void fillingWithoutFirstName(String Lname, String JFunc, String JTitle, String Email,
			String Instiname, String Institype, String disp, String country, String state) {

		parentWindow = driver.getWindowHandle();
		productsHome.clickonForCampus();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		while (itr.hasNext()) {

			String childWindow1 = itr.next();
			if (!childWindow1.contentEquals(parentWindow)) {
				driver.switchTo().window(childWindow1);
				productsHome.clickGetStarted();
				try {
					Thread.sleep(1000);
					productsHome.excelInvalidFirstName(Lname, JFunc, JTitle, Email, Instiname, Institype, disp,
							country, state);

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

	// It will provide the data present in sheet3
	@DataProvider
	public Object[][] getThirdPageData() {

		Object data[][] = TestUtil.getTestData(sheetName3);
		return data;
	}

	
	@Test(priority = 2, dataProvider = "getThirdPageData", groups = "Regression")
	public void fillingWithoutLastName(String Fname, String JFunc, String JTitle, String Email,
			String Instiname, String Institype, String disp, String country, String state) {

		parentWindow = driver.getWindowHandle();
		productsHome.clickonForCampus();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		while (itr.hasNext()) {

			String childWindow1 = itr.next();
			if (!childWindow1.contentEquals(parentWindow)) {
				driver.switchTo().window(childWindow1);
				productsHome.clickGetStarted();
				try {
					Thread.sleep(1000);
					productsHome.excelInvalidLastName(Fname, JFunc, JTitle, Email, Instiname, Institype, disp,
							country, state);

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

	@DataProvider
	public Object[][] getFourthPageData() {

		Object data[][] = TestUtil.getTestData(sheetName4);
		return data;
	}

	@Test(priority = 3, dataProvider = "getFourthPageData", groups ="Regression")
	public void fillingWithoutJobFunction(String Fname, String Lname, String JTitle, String Email,
			String Instiname, String Institype, String disp, String country, String state) {

		parentWindow = driver.getWindowHandle();
		productsHome.clickonForCampus();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		while (itr.hasNext()) {

			String childWindow1 = itr.next();
			if (!childWindow1.contentEquals(parentWindow)) {
				driver.switchTo().window(childWindow1);
				productsHome.clickGetStarted();
				try {
					Thread.sleep(1000);
					productsHome.excelInvalidJobFunction(Fname, Lname, JTitle, Email, Instiname, Institype, disp,
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

	@DataProvider
	public Object[][] getFifthPageData() {

		Object data[][] = TestUtil.getTestData(sheetName5);
		return data;
	}

	@Test(priority = 4, dataProvider = "getFifthPageData", groups = "Regression")
	public void fillingWithoutJobTitle(String Fname, String Lname, String JFunc, String Email,
			String Instiname, String Institype, String disp, String country, String state) {

		parentWindow = driver.getWindowHandle();
		productsHome.clickonForCampus();
		Set<String> handles= driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		while (itr.hasNext()) {

			String childWindow1 = itr.next();
			if (!childWindow1.contentEquals(parentWindow)) {
				driver.switchTo().window(childWindow1);
				productsHome.clickGetStarted();
				try {
					Thread.sleep(1000);
					productsHome.execelInvalidJobTitle(Fname, Lname, JFunc, Email, Instiname, Institype, disp,
							country, state);

					Thread.sleep(2000);
					boolean flag = productsHome.jobTitleErrorDisplayed();
					Assert.assertTrue(flag);
				} catch (Exception e) {
					e.printStackTrace();
				}
				driver.close();
			}
			driver.switchTo().window(parentWindow);
		}
	}

	@DataProvider
	public Object[][] getSixthPageData() {

		Object data[][] = TestUtil.getTestData(sheetName6);
		return data;
	}

	@Test(priority = 5, dataProvider = "getSixthPageData", groups = "Regression")
	public void fillingWithoutEmail(String Fname, String Lname, String JFunc, String JTitle,
			String Instiname, String Institype, String disp, String country, String state) {

		parentWindow = driver.getWindowHandle();
		productsHome.clickonForCampus();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		while (itr.hasNext()) {

			String childWindow1 = itr.next();
			if (!childWindow1.contentEquals(parentWindow)) {
				driver.switchTo().window(childWindow1);
				productsHome.clickGetStarted();
				try {
					Thread.sleep(1000);
					productsHome.execelInvalidEmail(Fname, Lname, JFunc, JTitle, Instiname, Institype, disp,
							country, state);

					Thread.sleep(2000);
					boolean flag = productsHome.emailErrorDisplayed();
					Assert.assertTrue(flag);
				} catch (Exception e) {
					e.printStackTrace();
				}
				driver.close();
			}
			driver.switchTo().window(parentWindow);
		}
	}

	@DataProvider
	public Object[][] getSeventhPageData() {

		Object data[][] = TestUtil.getTestData(sheetName7);
		return data;
	}

	@Test(priority = 6, dataProvider = "getSeventhPageData", groups ="Regression")
	public void fillingWithoutPhone(String Fname, String Lname, String JFunc, String JTitle, String Email,
			String Instiname, String Institype, String disp, String country, String state) {

		parentWindow = driver.getWindowHandle();
		productsHome.clickonForCampus();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr= handles.iterator();
		while (itr.hasNext()) {

			String childWindow1 = itr.next();
			if (!childWindow1.contentEquals(parentWindow)) {
				driver.switchTo().window(childWindow1);
				productsHome.clickGetStarted();
				try {
					Thread.sleep(1000);
					productsHome.execelInvalidPhone(Fname, Lname, JFunc, JTitle, Email, Instiname, Institype, disp,
							country, state);

					Thread.sleep(2000);
					boolean flag = productsHome.phoneErrorDisplayed();
					Assert.assertTrue(flag);
				} catch (Exception e) {
					e.printStackTrace();
				}
				driver.close();
			}
			driver.switchTo().window(parentWindow);
		}
	}

	@DataProvider
	public Object[][] getEighthPageData() {

		Object data[][] = TestUtil.getTestData(sheetName8);
		return data;
	}

	@Test(priority = 7, dataProvider = "getEighthPageData", groups = "Regression")
	public void fillingWithoutIntituteName(String Fname, String Lname, String JFunc, String JTitle, String Email,
			String Institype, String disp, String country, String state) {

		parentWindow = driver.getWindowHandle();
		productsHome.clickonForCampus();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		while (itr.hasNext()) {

			String childWindow1 = itr.next();
			if (!childWindow1.contentEquals(parentWindow)) {
				driver.switchTo().window(childWindow1);
				productsHome.clickGetStarted();
				try {
					Thread.sleep(1000);
					productsHome.execelInvalidInstituteName(Fname, Lname, JFunc, JTitle, Email, Institype, disp,
							country, state);

					Thread.sleep(2000);
					boolean flag = productsHome.instituteNameErrorDisplayed();
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
