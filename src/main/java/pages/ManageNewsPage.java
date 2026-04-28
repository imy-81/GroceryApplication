package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	// locators

	@FindBy(xpath = "//p[contains(text(),'Manage News')]/ancestor::div[contains(@class,'small-box')]//a")
	WebElement managemsg;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newsmsg;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement textmsg;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement savebtn;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successmsg;

	// constructor

	public WebDriver driver;

	public ManageNewsPage(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// actions

	public ManageNewsPage manageMessage() {
		managemsg.click();
		return this;
	}

	public ManageNewsPage newMessage()

	{
		newsmsg.click();
		return this;
	}

	public ManageNewsPage messageText(String newsvalue)

	{
		textmsg.sendKeys(newsvalue);
		return this;
	}

	public ManageNewsPage saveButton() {
		savebtn.click();
		return this;
	}

	public boolean isSuccessMsgDisplayed() {
		return successmsg.isDisplayed();
	}

}
