package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitUtility;

public class LogOutPage {

	// locators

	// @FindBy(xpath = "//p[contains(text(),'Settings')]")

	@FindBy(xpath = "//a[@data-toggle='dropdown']")

	WebElement btndropdown;

	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
	WebElement logoutbtn;
	/*
	 * @FindBy(xpath="//title[text()='Login | 7rmart supermarket']") WebElement
	 * logintitle;
	 */
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signinbtn;

	// constructors
	public WebDriver driver;

	public LogOutPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	// actions

	public void dropdown() {

		btndropdown.click();

	}

	public void clickLogout()

	{

		logoutbtn.click();

		WaitUtility waitutil = new WaitUtility();

		waitutil.visibilityOfallElements(driver, signinbtn);

	}

	public boolean isSignInBtnVisible() {
		return signinbtn.isDisplayed();
	}

}
