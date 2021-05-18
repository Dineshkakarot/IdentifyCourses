package Scenario4;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.PageBase;
import Pages.HomePage;
import Pages.LandingPage;
import Pages.PageCourses;

public class ExtractCourseTest extends PageBase{

	
	LandingPage landingPage;
	HomePage homePage;
	PageCourses pageCourses;
	String parentWindow;
	
	public ExtractCourseTest() {
		
		super();
	}
	
	@BeforeClass
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
		
		System.out.println("Name of the first course :" + pageCourses.CourseName1());
		System.out.println("Ratings of the first course :" + pageCourses.CourseRating1());
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
				System.out.println("Total learning hours of first course: "+fhours);
				driver.close();
			}
			driver.switchTo().window(parentWindow);
		}
	}
	
	@Test(priority = 1)
	public void secondcourse() {
		
		System.out.println("Name of the second course :" + pageCourses.CourseName2());
		System.out.println("Ratings of the second course :" + pageCourses.CourseRating2());
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
				System.out.println("Total learning hours of first course: "+fhours);
				driver.close();
			}
			driver.switchTo().window(parentWindow);
		}
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}
}
