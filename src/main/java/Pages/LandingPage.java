package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.PageBase;

public class LandingPage extends PageBase{
	
	
	@FindBy(xpath = "//a[contains(text(),'Log In')]")
	WebElement loginBtn;
	
	@FindBy(xpath = "//img[@class='rc-CourseraLogo _1j095b7']")
	WebElement pageLogo;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement userMail;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement userPass;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginSubmit;
		
	
	@FindBy(xpath = "//a[@id='enterprise-link']")
	WebElement forEnterpriseLink;
	
	//Initializing the Page Objects
	public LandingPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLandingPageTitle() {
		
		return driver.getTitle();
	}
	
	
	public HomePage doLogin(String un, String pwd) {
		
		loginBtn.click();
		userMail.sendKeys(un);
		userPass.sendKeys(pwd);
		loginSubmit.click();
		return new HomePage();
	}
	
	public ProductsHome navigateToForEnterprise() {
		
		forEnterpriseLink.click();
		return new ProductsHome();
	}
}
