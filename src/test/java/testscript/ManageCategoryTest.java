package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.FileUploadUtility;
import utilities.WaitUtility;

public class ManageCategoryTest extends Base {

	@Test(groups= {"smoke"},retryAnalyzer=retry.Retry.class)

	public void verifyUploadFile() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");

		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.username(usernamevalue);
		loginpage.pswrd(passwordvalue);
		loginpage.clickOnSignin();

		ManageCategoryPage managecategory = new ManageCategoryPage(driver);

		managecategory.getmanageCategory();
		managecategory.getNewButton();
		managecategory.getCategory("fruit");
		WaitUtility wait = new WaitUtility();
		wait.waitForElementToBeClickable(driver, managecategory.discountgroupoption);
		managecategory.getDiscountGroup();
		managecategory.upLoadImage(Constant.APPLEIMAGE);
		managecategory.setSaveButton();
		boolean successalertmsg = managecategory.isSuccessMessageDisplayed();
		Assert.assertTrue(successalertmsg);

		/*
		 * FileUploadUtility upload=new FileUploadUtility();
		 * upload.fileUploadBySendKeys(managecategory.getChooseFile(),
		 * Constant.APPLEIMAGE);
		 */

	}

}
