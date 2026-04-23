package testscript;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test(priority=1,groups= {"regression"},retryAnalyzer=retry.Retry.class)
	public void verifyTheUserIsAbleToLoginUsingValidCred() throws IOException
	{
		
		//String usernamevalue="admin";
		//String passwordvalue="admin";
		
		String usernamevalue=ExcelUtility.getStringData(1, 0, "loginpage");
		
		String passwordvalue=ExcelUtility.getStringData(1, 1,"loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.username(usernamevalue);
		loginpage.pswrd(passwordvalue);
		loginpage.clickOnSignin();
		boolean homepage=loginpage.isHomePageDisplayed();
		Assert.assertTrue(homepage);
		
		
	}
	
	
	@Test(priority=2)
	public void verifyTheUserIsAbleToLoginUsingInValidPswrd() throws IOException
	{
		
		//String usernamevalue="admin";
		//String passwordvalue="admin123";
		String usernamevalue=ExcelUtility.getStringData(2, 0, "loginpage");
		String passwordvalue=ExcelUtility.getStringData(2, 1, "loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.username(usernamevalue);
		loginpage.pswrd(passwordvalue);
		loginpage.clickOnSignin();
		boolean alertmsg=loginpage.isAlertMsgDisplayed();
		Assert.assertTrue(alertmsg);
	}
	@Test(priority=3)
	
	public void verifyTheUserIsAbleToLoginUsingInValidUser() throws IOException
			
			{
		//String usernamevalue="admin123";
		//String passwordvalue="admin";
		String usernamevalue=ExcelUtility.getStringData(3, 0, "loginpage");
		String passwordvalue=ExcelUtility.getStringData(3, 1, "loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.username(usernamevalue);
		loginpage.pswrd(passwordvalue);
		loginpage.clickOnSignin();
		boolean greendashboard=loginpage.isDashBoardDisplayed();
		Assert.assertTrue(greendashboard);
		
			}	
			
@Test(priority=4)
	
	public void verifyTheUserIsAbleToLoginUsingInValidBoth() throws IOException
			
			{
		//String usernamevalue="admin123";
		//String passwordvalue="admin456";
	String usernamevalue=ExcelUtility.getStringData(4, 0, "loginpage");
	String passwordvalue=ExcelUtility.getStringData(4, 1, "loginpage");
	
		LoginPage loginpage=new LoginPage(driver);
		loginpage.username(usernamevalue);
		loginpage.pswrd(passwordvalue);
		loginpage.clickOnSignin();
		boolean alertvisible = loginpage.isAlertVisibilityDisplayed();
		Assert.assertTrue(alertvisible);
		
			}	

}