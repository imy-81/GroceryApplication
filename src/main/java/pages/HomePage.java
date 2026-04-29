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

	@FindBy(xpath = "//a[@data-toggle='dropdown']")

	WebElement btndropdown;

	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
	WebElement logoutbtn;

	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboardHeader;

	@FindBy(xpath = ("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']//i[@class='fas fa-arrow-circle-right']"))
	WebElement adminuser;
	@FindBy(xpath = ("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']//child::i[@class='fas fa-arrow-circle-right']"))
	WebElement managecategory;
	@FindBy(xpath = ("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']//child::i[@class='fas fa-arrow-circle-right']"))
	WebElement managecontact;
	@FindBy(xpath = ("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext']//child::i[@class='fas fa-arrow-circle-right']"))

	WebElement managefooter;
	
	@FindBy(xpath = "//p[contains(text(),'Manage News')]/ancestor::div[contains(@class,'small-box')]//a")
	WebElement managemsg;
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboard;
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

	
	public ManageNewsPage clickOnManageMessage() {
		managemsg.click();
		return new ManageNewsPage(driver);
	}

	public HomePage dropdown() {
		waitutil.waitForElementToBeClickable(driver, btndropdown);
		btndropdown.click();
		return this;
	}

	public LoginPage clickLogOut() {
		waitutil.waitForElementToBeVisible(driver, logoutbtn); 
	    logoutbtn.click();
		
		return new LoginPage(driver); // Landing back on Login page
	}

	

	public boolean isDashboardVisible() {
		waitutil.waitForElementToBeVisible(driver, dashboardHeader);
		return dashboardHeader.isDisplayed();
	}

}
