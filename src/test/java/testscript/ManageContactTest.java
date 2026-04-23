package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageContactTest extends Base {

	@Test
	public void verifyManageContact() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");

		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.username(usernamevalue);
		loginpage.pswrd(passwordvalue);
		loginpage.clickOnSignin();

		ManageContactPage managecontact = new ManageContactPage(driver);
		managecontact.getManageContact();
		managecontact.getActionButton();
		FakerUtility utility = new FakerUtility();
		String phonenumber = utility.generatePhoneNumber();
		managecontact.getPhoneNumber(phonenumber);
		String email = utility.generateEmail();
		managecontact.getEmailMsg(email);
		String address = utility.generateAddress();
		managecontact.getTextArea(address);
		managecontact.getDeliveryTime("10 AM - 8 PM");
		managecontact.getDeliveryCharge("$50");
		managecontact.getUpdateMsg();
		boolean alertupdatedmsg = managecontact.isAlertUpdateMsgdisplayed();
		Assert.assertTrue(alertupdatedmsg);

	}

}
