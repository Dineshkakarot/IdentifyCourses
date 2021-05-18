package Scenario1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.PageBase;
import Scenario1Pages.HomePage;
import Scenario1Pages.HomePage2;

public class ValidateTest extends PageBase {

	HomePage homePage;
	HomePage2 homePage2;
	Scenario1Pages.validate validate;
	
	public ValidateTest() {
		super();
	}
	
	@BeforeClass
	public void setup() {
		setupBrowser();
		validate=new Scenario1Pages.validate();
		validate.Click();
	}
	@Test
	public void searching() {
		validate.text();
		validate.Display();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	}
