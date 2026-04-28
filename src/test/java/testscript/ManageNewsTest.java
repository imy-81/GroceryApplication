package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageNewsTest extends Base {
	HomePage homepage;
	ManageNewsPage managenew;

	@Test(description = " Managenews TestCase")

	public void verifyManageNewsTest() throws IOException

	{

		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");

		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.username(usernamevalue).pswrd(passwordvalue);
		// loginpage.pswrd(passwordvalue);
		homepage = loginpage.clickOnSignin();

		String newsContent = ExcelUtility.getStringData(0, 0, "managenews");
		// ManageNewsPage managenew = new ManageNewsPage(driver);
		managenew.manageMessage().newMessage().messageText(newsContent).saveButton();

		boolean message = managenew.isSuccessMsgDisplayed();
		Assert.assertTrue(message, Constant.NEWSFAILED);

		// managenew.messageText(newsContent);
		// managenew.saveButton();
		//// managenew.newMessage().messageText(newsContent).saveButton();

	}

}
