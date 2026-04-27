package testscript;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base {

	HomePage homepage;
	AdminUsersPage adminuser;

	@Test(description = "AdminUser Test case")
	public void verifyAdminUsers() throws IOException {

		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.username(usernamevalue).pswrd(passwordvalue);
		// loginpage.pswrd(passwordvalue);
		homepage = loginpage.clickOnSignin();

		String username = ExcelUtility.getStringData(1, 0, "adminuser");
		String password = ExcelUtility.getStringData(1, 1, "adminuser");
		String value = ExcelUtility.getStringData(1, 2, "adminuser");

		adminuser = homepage.clickOnAdminUserInfo().newButton();
		adminuser.userName(username).password(password);
		adminuser.selectDropDown().selectStaff(value);
		String selectedvalue = adminuser.selectUserDropdown();
		Assert.assertEquals(selectedvalue, value,Constant.ADMINUSERMISMATCH);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		// AdminUsersPage adminuser = new AdminUsersPage(driver);

		// homepage=adminuser.adminUser();
		// adminuser.newButton();
		// adminuser.password(password);
		// adminuser.selectStaff(value);

		// here 'value 'is from String value = ExcelUtility.getStringData(1,
		// 2,
		// "adminuser");, and here the "selectedvalue" is actualvalue and
		// "value"
		// is expectedvalue*/

		/*
		 * boolean staffdropdown = adminuser.isStaffOptionDisplayed();
		 * Assert.assertTrue(staffdropdown);
		 */

	}

}
