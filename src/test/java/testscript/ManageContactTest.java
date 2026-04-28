package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageContactTest extends Base {
	HomePage homepage;
	ManageContactPage managecontact;

	@Test(description = "ManageContact Testcase")
	public void verifyManageContact() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");

		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.username(usernamevalue).pswrd(passwordvalue);

		homepage = loginpage.clickOnSignin();

		// ManageContactPage managecontact = new ManageContactPage(driver);

		managecontact = homepage.clickOnManageContact();
		managecontact.getActionButton();

		FakerUtility utility = new FakerUtility();
		String phonenumber = utility.generatePhoneNumber();
		String email = utility.generateEmail();
		String address = utility.generateAddress();
		String deliverytime = ExcelUtility.getStringData(1, 0, "managecontact");
		String deliverycharge = ExcelUtility.getIntegerData(1, 1, "managecontact");

		managecontact.getPhoneNumber(phonenumber).getEmailMsg(email).getTextArea(address).getDeliveryTime(deliverytime)
				.getDeliveryCharge(deliverycharge).clickUpdateMsg();

		boolean alertupdatedmsg = managecontact.isAlertUpdateMsgdisplayed();
		Assert.assertTrue(alertupdatedmsg, Constant.MANAGECONTACTFAIL);

		/*
		 * managecontact.getPhoneNumber(phonenumber); String email =
		 * utility.generateEmail(); managecontact.getEmailMsg(email); String address =
		 * utility.generateAddress(); managecontact.getTextArea(address); String
		 * deliverytime = ExcelUtility.getStringData(1, 0, "managecontact");
		 * managecontact.getDeliveryTime(deliverytime);
		 * 
		 * String deliverycharge = ExcelUtility.getIntegerData(1, 1, "managecontact");
		 * managecontact.getDeliveryCharge(deliverycharge);
		 * managecontact.clickUpdateMsg();
		 */

	}

}
