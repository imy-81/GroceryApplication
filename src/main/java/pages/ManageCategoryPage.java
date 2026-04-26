package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.WaitUtility;

public class ManageCategoryPage {
	/*
	 * @FindBy(xpath =
	 * ("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']//child::i[@class='fas fa-arrow-circle-right']"
	 * )) WebElement managecategory;
	 */

	@FindBy(xpath = ("//a[@class='btn btn-rounded btn-danger']"))
	WebElement newbtn;

	@FindBy(xpath = ("//input[@id='category']"))
	WebElement category;

	@FindBy(xpath = ("//div[@class='ms-selectable']//child::span[text()='discount']"))
	public WebElement discountgroupoption;

	@FindBy(xpath = ("//input[@id='main_img']"))
	WebElement choosefile;

	@FindBy(xpath = ("//button[text()='Save']"))
	WebElement savebtn;
	@FindBy(xpath = ("//div[contains(@class,'alert-dismissible')]"))
	WebElement successalertmsg;

	public WebDriver driver;
	WaitUtility wait = new WaitUtility();

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * public ManageCategoryPage getmanageCategory() { managecategory.click();
	 * return this;
	 * 
	 * }
	 */

	public ManageCategoryPage getNewButton() {
		newbtn.click();
		return this;
	}

	public ManageCategoryPage getCategory(String fruit) {

		wait.waitForElementToBeVisible(driver, category);
		category.sendKeys(fruit);
		return this;
	}

	public ManageCategoryPage getDiscountGroup() {
		wait.waitForElementToBeClickable(driver, discountgroupoption);
		discountgroupoption.click();
		return this;

	}

	public ManageCategoryPage upLoadImage(String filepath) {
		FileUploadUtility upload = new FileUploadUtility();
		upload.fileUploadBySendKeys(choosefile, filepath);
		return this;

	}

	public ManageCategoryPage setSaveButton() {
		savebtn.click();
		return this;
	}

	public boolean isSuccessMessageDisplayed() {
		return successalertmsg.isDisplayed();
	}

}
