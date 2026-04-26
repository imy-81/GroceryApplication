package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomePageTest extends Base {

	@Test(groups = { "regression" }, description = "Logout Testcase")
	public void verifyLogoutTest() throws IOException, InterruptedException

	{

		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");

		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.username(usernamevalue);
		loginpage.pswrd(passwordvalue);
		loginpage.clickOnSignin();

		HomePage lp = new HomePage(driver);

		lp.dropdown();

		lp.clickLogOut();
		System.out.println("Logout successfully");

		boolean signinbtn = lp.isSignInBtnVisible();
		Assert.assertTrue(signinbtn);

	}
}
























/*
 * String currentUrl = driver.getCurrentUrl(); System.out.println(currentUrl);
 * 
 * Assert.assertTrue(currentUrl.contains("login"), "Logout failed!");
 */

/*
 * try { Thread.sleep(3000); } catch (InterruptedException e) {
 * e.printStackTrace(); }
 */
