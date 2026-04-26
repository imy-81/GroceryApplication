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

public class HomePage {

	// locators

	// @FindBy(xpath = "//p[contains(text(),'Settings')]")
	/*
	 * @FindBy(xpath="//title[text()='Login | 7rmart supermarket']") WebElement
	 * logintitle;
	 */
	@FindBy(xpath = "//a[@data-toggle='dropdown']")

	WebElement btndropdown;

	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
	WebElement logoutbtn;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signinbtn;

	@FindBy(xpath = ("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']//i[@class='fas fa-arrow-circle-right']"))
	WebElement adminuser;
	@FindBy(xpath = ("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']//child::i[@class='fas fa-arrow-circle-right']"))
	WebElement managecategory;
	@FindBy(xpath = ("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']//child::i[@class='fas fa-arrow-circle-right']"))
	WebElement managecontact;
	@FindBy(xpath = ("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext']//child::i[@class='fas fa-arrow-circle-right']"))

	WebElement managefooter;

	public WebDriver driver;
	WaitUtility waitutil = new WaitUtility();

	// constructors
	public HomePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	// actions
	public AdminUsersPage clickOnAdminUserInfo() {
		adminuser.click();
		return new AdminUsersPage(driver);
	}

	public ManageCategoryPage clickOnManageCategory() {
		managecategory.click();
		return new ManageCategoryPage(driver);

	}

	public ManageContactPage clickOnManageContact() {
		managecontact.click();
		return new ManageContactPage(driver);
	}

	public ManageFooterTextPage clickOnManageFooter() {

		managefooter.click();
		return new ManageFooterTextPage(driver);
	}

	public HomePage dropdown() {
		waitutil.waitForElementToBeClickable(driver, btndropdown); // Ensure it's ready

		btndropdown.click();
		return this;

	}

	/*
	 * public LoginPage clickLogout()
	 * 
	 * {
	 * 
	 * logoutbtn.click();
	 * 
	 * return new LoginPage(driver); }
	 */

	public HomePage clickLogOut() {
		logoutbtn.click();
		return this;
	}

	public boolean isSignInBtnVisible() {
		waitutil.waitForElementToBeVisible(driver, signinbtn);
		return signinbtn.isDisplayed();
	}

}
