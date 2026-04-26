package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage {

//locators

	//@FindBy(xpath = ("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']//i[@class='fas fa-arrow-circle-right']"))
	//WebElement adminuser;
	@FindBy(xpath = ("//a[@class='btn btn-rounded btn-danger']"))
	WebElement newbtn;

	@FindBy(xpath = ("//input[@id='username']"))
	WebElement username;
	@FindBy(xpath = ("//input[@id='password']"))
	WebElement pswrd;

	@FindBy(xpath = ("//select[@id='user_type']"))
	WebElement selectdropdown;

	
	//  @FindBy(xpath = ("//option[@value='staff']")) WebElement staffdropdown;
	 

	// constructor

	public WebDriver driver;

	public AdminUsersPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// actions

	/*public void clickOnAdminUserInfo() {
		adminuser.click();
	}*/

	public AdminUsersPage newButton() {
		newbtn.click();
		return this;
	}

	public AdminUsersPage userName(String userName) {
		username.sendKeys(userName);
		return this;
	}

	public AdminUsersPage password(String pwd) {
		pswrd.sendKeys(pwd);
		return this;

	}

	public AdminUsersPage selectDropDown() {
		selectdropdown.click();
		return this;
	}

	public void selectStaff(String value) {
		PageUtility pageutility = new PageUtility();
		pageutility.selectByValue(selectdropdown, value);
	}

	public String selectUserDropdown() {
		Select select = new Select(selectdropdown);
		return select.getFirstSelectedOption().getAttribute("value");
	}

	
	 // public boolean isStaffOptionDisplayed() { return staffdropdown.isDisplayed(); }
	 

}