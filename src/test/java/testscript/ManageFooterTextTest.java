package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageFooterTextTest extends Base {
	HomePage homepage;
	ManageFooterTextPage managefooterpage;

	@Test(description = "ManageFooterText Testcase")
	public void verifyManageFooterText() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");

		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.username(usernamevalue).pswrd(passwordvalue);
		// loginpage.pswrd(passwordvalue);
		homepage = loginpage.clickOnSignin();

		// ManageFooterTextPage managefooterpage = new ManageFooterTextPage(driver);

		managefooterpage = homepage.clickOnManageFooter();
		FakerUtility utility = new FakerUtility();

		managefooterpage.getActionButton().getAddressInput(utility.generateAddress())
				.getEmailInput(utility.generateEmail()).getPhoneInput(utility.generatePhoneNumber()).getUpdateButton();
		
		boolean successalertmsg = managefooterpage.isSuccessMsgDisplayed();
		Assert.assertTrue(successalertmsg,Constant.SUCCESSMSGNOTDISPLAYED);

	}

	/*
	 * String address = utility.generateAddress();
	 * managefooterpage.getAddressInput(address); String emailid =
	 * utility.generateEmail(); managefooterpage.getEmailInput(emailid);
	 * 
	 * String phonenumber = utility.generatePhoneNumber();
	 * 
	 * managefooterpage.getPhoneInput(phonenumber);
	 * managefooterpage.getUpdateButton();
	 */

}
