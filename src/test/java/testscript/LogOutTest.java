package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LogOutPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LogOutTest extends Base{

	HomePage homepage;
	LogOutPage logout;
	
	
	@Test
	public void verifyLogOutTest() throws IOException
	
	{
		
		String usernamevalue = ExcelUtility.getStringData(1, 0, "loginpage");

		String passwordvalue = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.username(usernamevalue).pswrd(passwordvalue);
		//loginpage.pswrd(passwordvalue);
		homepage=loginpage.clickOnSignin();

	loginpage=homepage.dropdown().clickLogOut();
		boolean signinbutton=loginpage.isSignInBtnVisible();
		Assert.assertTrue(signinbutton,Constant.LOGOUTFAIL);
		
		
		
		
	}
	
	
	
	
	
}
