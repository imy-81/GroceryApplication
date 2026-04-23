package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {

	@FindBy(xpath = ("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext']//child::i[@class='fas fa-arrow-circle-right']"))

	WebElement managefooter;

	@FindBy(xpath = ("//a[@href=\"https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1\"]//child::i[@class=\"fas fa-edit\"]"))
	WebElement actionbtn;

	@FindBy(xpath = ("//textarea[@id='content']"))

	WebElement addressinput;

	@FindBy(xpath = ("//input[@id='email']"))

	WebElement emailinput;

	@FindBy(xpath = ("//input[@id='phone']"))

	WebElement phoneinput;

	@FindBy(xpath = ("//button[@name='Update']"))

	WebElement updatebtn;

	@FindBy(xpath = ("//div[@class='alert alert-success alert-dismissible']"))
	WebElement successalertmsg;

	public WebDriver driver;

	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void getManageFooter() {

		managefooter.click();
	}

	public void getActionButton() {

		actionbtn.click();
	}

	public void getAddressInput(String address) {
		addressinput.clear();
		addressinput.sendKeys(address);
	}

	public void getEmailInput(String emailid) {
		emailinput.clear();
		emailinput.sendKeys(emailid);
	}

	public void getPhoneInput(String number) {
		phoneinput.clear();
		phoneinput.sendKeys(number);
	}

	public void getUpdateButton() {
		updatebtn.click();
	}

	public boolean isSuccessMsgDisplayed() {
		return successalertmsg.isDisplayed();
	}

}
