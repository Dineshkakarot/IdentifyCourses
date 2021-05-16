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

public class FirstCourseTest extends PageBase {
	
	LandingPage landingPage;
	HomePage homePage;
	PageCourses pageCourses;
	String parentWindow;
	
	public FirstCourseTest() {
		
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
	public void firstCourse() {
		
		Reporter.log("Name of the first course :" + pageCourses.CourseName1());
		Reporter.log("Ratings of the first course :" + pageCourses.CourseRating1());
		WebDriverWait wait = new WebDriverWait(driver, 20);
		parentWindow = driver.getWindowHandle();
		wait.until(ExpectedConditions.elementToBeClickable(pageCourses.firstCourseName));
		pageCourses.firstCourseName.click();
		Set<String> handles1 = driver.getWindowHandles();
		Iterator<String> itr1 = handles1.iterator();
		while(itr1.hasNext()) {
			
			String childWindow1 = itr1.next();
			if (!childWindow1.contentEquals(parentWindow)) {
				driver.switchTo().window(childWindow1);
				String fhours = pageCourses.firstCourseHours.getText();
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
