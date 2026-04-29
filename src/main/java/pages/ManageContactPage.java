package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageContactPage {
	/*
	 * @FindBy(xpath =
	 * ("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']//child::i[@class='fas fa-arrow-circle-right']"
	 * )) WebElement managecontact;
	 */
	@FindBy(xpath = ("//i[@class='fas fa-edit']"))
	WebElement actionbtn;

	@FindBy(xpath = ("//input[@id='phone']"))
	WebElement phonenumber;
	@FindBy(xpath = ("//input[@id='email']"))
	WebElement emailmsg;

	@FindBy(xpath = ("//textarea[@name='del_time']"))
	WebElement textarea;
	@FindBy(xpath = ("//textarea[@placeholder='Enter Delivery Time']"))
	WebElement deliverytime;
	@FindBy(xpath = ("//input[@id='del_limit']"))
	WebElement deliverycharge;
	/*@FindBy(xpath = ("//button[@name='Update']"))
	WebElement updatemsg;*/
	
	
	@FindBy(xpath = "//button[@type='submit' and contains(@class,'btn-info')]//child::i")
	WebElement updatemsg;
	/*@FindBy(xpath = ("//div[@class='alert alert-success alert-dismissible']"))
	WebElement alertupdatedmsg;*/
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	WebElement alertupdatedmsg;
	
	public WebDriver driver;
WaitUtility wait=new WaitUtility();
//constructor
	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// actions

	public ManageContactPage getActionButton() {
		actionbtn.click();
		return this;
	}

	public ManageContactPage getPhoneNumber(String number) {
		phonenumber.clear();
		phonenumber.sendKeys(number);
		return this;
	}

	public ManageContactPage getEmailMsg(String email) {
		emailmsg.clear();
		emailmsg.sendKeys(email);
		return this;
	}

	public ManageContactPage getTextArea(String message) {
		textarea.clear();
		textarea.sendKeys(message);
		return this;
	}

	public ManageContactPage getDeliveryTime(String time) {
		deliverytime.clear();
		deliverytime.sendKeys(time);
		return this;
	}

	public ManageContactPage getDeliveryCharge(String charge) {
		deliverycharge.clear();
		deliverycharge.sendKeys(charge);
		return this;
	}

	public ManageContactPage clickUpdateMsg() {
		updatemsg.click();
		return this;
	}
	
	

	public boolean isAlertUpdateMsgdisplayed() {
		wait.waitForElementToBeVisible(driver, alertupdatedmsg);
		return alertupdatedmsg.isDisplayed();

	}

}
