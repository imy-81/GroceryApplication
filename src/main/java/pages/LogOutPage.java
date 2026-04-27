package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LogOutPage  {

	
	@FindBy(xpath = "//a[@data-toggle='dropdown']")

	WebElement btndropdown;

	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
	WebElement logoutbtn;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signinbtn;
	
	public WebDriver driver;
	WaitUtility waitutil = new WaitUtility();
	public LogOutPage(WebDriver driver)
	
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	public LogOutPage dropdown() {
		waitutil.waitForElementToBeClickable(driver, btndropdown); // Ensure it's ready

		btndropdown.click();
		return this;

	}
	
	public LogOutPage clickLogOut() {
		logoutbtn.click();
		return this;
	}
	
	public boolean isSignInBtnVisible() {
		waitutil.waitForElementToBeVisible(driver, signinbtn);
		return signinbtn.isDisplayed();
	}
	
	
	
	
	
	
}
