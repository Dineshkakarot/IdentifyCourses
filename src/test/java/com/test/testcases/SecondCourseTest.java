package com.test.testcases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.base.PageBase;
import com.test.pages.HomePage;
import com.test.pages.LandingPage;
import com.test.pages.PageCourses;

public class SecondCourseTest extends PageBase{

	LandingPage landingPage;
	HomePage homePage;
	PageCourses pageCourses;
	String parentWindow;
	
	public SecondCourseTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		setupBrowser();
		landingPage = new LandingPage();
		homePage = new HomePage();
		pageCourses = new  PageCourses();
		pageCourses = homePage.clickSearchbox();
		pageCourses.selectLanguage();
		pageCourses.selectLevel();
	}
	
	@Test(priority = 0)
	public void secondcourse() {
		
		Reporter.log("Name of the second course :" + pageCourses.CourseName2());
		Reporter.log("Ratings of the second course :" + pageCourses.CourseRating2());
		WebDriverWait wait = new WebDriverWait(driver, 20);
		parentWindow = driver.getWindowHandle();
		wait.until(ExpectedConditions.elementToBeClickable(pageCourses.secondCourseName));
		pageCourses.secondCourseName.click();
		Set<String> handles2 = driver.getWindowHandles();
		Iterator<String> itr2 = handles2.iterator();
		while(itr2.hasNext()) {
			
			String childWindow1 = itr2.next();
			if (!childWindow1.contentEquals(parentWindow)) {
				driver.switchTo().window(childWindow1);
				String fhours = pageCourses.secondCourseHours.getText();
				Reporter.log("Total learning hours of first course: "+fhours);
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
