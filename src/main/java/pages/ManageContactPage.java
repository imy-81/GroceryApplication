package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContactPage {
	@FindBy(xpath = ("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']//child::i[@class='fas fa-arrow-circle-right']"))
	WebElement managecontact;
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
	@FindBy(xpath = ("//button[@name='Update']"))
	WebElement updatemsg;
	@FindBy(xpath = ("//div[@class='alert alert-success alert-dismissible']"))
	WebElement alertupdatedmsg;
	
	
	// constructor
	public WebDriver driver;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// actions

	public void getManageContact() {
		managecontact.click();}
	public void getActionButton() {
		actionbtn.click();}
	public void getPhoneNumber(String number) {
		phonenumber.clear();
		phonenumber.sendKeys(number);
	}
	public void getEmailMsg(String email) {
		emailmsg.clear();
		emailmsg.sendKeys(email);}
	public void getTextArea(String message) {
		textarea.clear();
		textarea.sendKeys(message);
	}
	public void getDeliveryTime(String time) {
		deliverytime.clear();
		deliverytime.sendKeys(time);
	}
	public void getDeliveryCharge(String charge) {
		deliverycharge.clear();
		deliverycharge.sendKeys(charge);
	}
	public void getUpdateMsg()  {
		updatemsg.click();
	}
	public boolean  isAlertUpdateMsgdisplayed() {
		return alertupdatedmsg.isDisplayed();
	
		
	}

}
