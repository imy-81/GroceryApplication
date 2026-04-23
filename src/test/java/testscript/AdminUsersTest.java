package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base {

	@Test
	public void verifyAdminUsers() throws IOException {

		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");

		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.username(usernamevalue);
		loginpage.pswrd(passwordvalue);
		loginpage.clickOnSignin();

		String username = ExcelUtility.getStringData(1, 0, "adminuser");
		String password = ExcelUtility.getStringData(1, 1, "adminuser");
		String value = ExcelUtility.getStringData(1, 2, "adminuser");

		AdminUsersPage adminuser = new AdminUsersPage(driver);
		adminuser.adminUser();
		adminuser.newButton();
		adminuser.userName(username);
		adminuser.password(password);
		adminuser.selectDropDown();
		adminuser.selectStaff(value);
		String selectedvalue = adminuser.selectUserDropdown();
		Assert.assertEquals(selectedvalue, value); // here value is from String value = ExcelUtility.getStringData(1, 2,
													// "adminuser");, and here the "selectedvalue" is actualvalue and "value"
													// is expectedvalue

		/*
		 * boolean staffdropdown = adminuser.isStaffOptionSelected();
		 * Assert.assertTrue(staffdropdown);
		 */

	}

}
