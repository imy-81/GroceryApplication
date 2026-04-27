package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.FileUploadUtility;
import utilities.WaitUtility;

public class ManageCategoryTest extends Base {
HomePage homepage;
ManageCategoryPage managecategory;
	@Test(groups = { "smoke" }, retryAnalyzer = retry.Retry.class,description="Managecategory Testcase")

	public void verifyUploadFile() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");

		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.username(usernamevalue).pswrd(passwordvalue);
		//loginpage.pswrd(passwordvalue);
		homepage=loginpage.clickOnSignin();
		

		//ManageCategoryPage managecategory = new ManageCategoryPage(driver);

		managecategory=homepage.clickOnManageCategory();
		managecategory.getNewButton();
		String category=ExcelUtility.getStringData(1, 0, "managecategory");
		managecategory.getCategory(category).getDiscountGroup().upLoadImage(Constant.APPLEIMAGE).setSaveButton();
		
		
		/*managecategory.getDiscountGroup();
		managecategory.upLoadImage(Constant.APPLEIMAGE);
		managecategory.setSaveButton();*/
		boolean successalertmsg = managecategory.isSuccessMessageDisplayed();
		Assert.assertTrue(successalertmsg,Constant.MANAGECATEGORYFAIL);

		
		 /* FileUploadUtility upload=new FileUploadUtility();
		 upload.fileUploadBySendKeys(managecategory.getChooseFile(),
		  Constant.APPLEIMAGE);*/
		 

	

}}
