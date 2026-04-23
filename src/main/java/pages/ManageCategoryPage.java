package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;

public class ManageCategoryPage {
	@FindBy(xpath = ("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']//child::i[@class='fas fa-arrow-circle-right']"))
	WebElement managecategory;

	@FindBy(xpath = ("//a[@class='btn btn-rounded btn-danger']"))
	WebElement newbtn;

	@FindBy(xpath = ("//input[@id='category']"))
	WebElement category;

	@FindBy(xpath = ("//div[@class='ms-selectable']//child::span[text()='discount']"))
	public WebElement discountgroupoption;

	
	 /* @FindBy(xpath = ("//li[@class='ms-elem-selection ms-selected ms-hover']"))
	 * WebElement discountmoved;
	 */
	/*@FindBy(xpath = ("//li[@id='134-selectable']"))
	WebElement discountoption;*/
	
	@FindBy(xpath = ("//input[@id='main_img']"))
	WebElement choosefile;

	@FindBy(xpath = ("//button[text()='Save']"))
	WebElement savebtn;
	@FindBy(xpath = ("//div[contains(@class,'alert-dismissible')]"))
	WebElement successalertmsg;

	public WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void getmanageCategory() {
		managecategory.click();

	}

	public void getNewButton() {
		newbtn.click();
	}

	public void getCategory(String fruit) {
		category.sendKeys(fruit);
	}

	public void getDiscountGroup() {
		discountgroupoption.click();
	}

	public void upLoadImage(String filepath) {
		choosefile.sendKeys(filepath);
	}

	public void setSaveButton() {
		savebtn.click();
	}

	public boolean isSuccessMessageDisplayed() {
		return successalertmsg.isDisplayed();
	}

	/*
	 * public WebElement getChooseFile() { return choosefile; }
	 */

}
