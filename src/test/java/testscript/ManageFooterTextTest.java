package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageFooterTextTest extends Base {

	@Test
	public void verifyManageFooterText() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");

		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.username(usernamevalue);
		loginpage.pswrd(passwordvalue);
		loginpage.clickOnSignin();

		ManageFooterTextPage managefooterpage = new ManageFooterTextPage(driver);

		managefooterpage.getManageFooter();

		managefooterpage.getActionButton();
		FakerUtility utility = new FakerUtility();
		String address = utility.generateAddress();
		managefooterpage.getAddressInput(address);
		String emailid = utility.generateEmail();
		managefooterpage.getEmailInput(emailid);

		String phonenumber = utility.generatePhoneNumber();

		managefooterpage.getPhoneInput(phonenumber);
		managefooterpage.getUpdateButton();
		boolean successalertmsg = managefooterpage.isSuccessMsgDisplayed();
		Assert.assertTrue(successalertmsg);

	}

}
