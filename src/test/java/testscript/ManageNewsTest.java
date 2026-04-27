package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageNewsTest extends Base {

	@Test(description=" Managenews TestCase")
	
	public void verifyManageNewsTest() throws IOException
	
	{
		
		String usernamevalue=ExcelUtility.getStringData(1, 0, "loginpage");
		
		String passwordvalue=ExcelUtility.getStringData(1, 1,"loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.username(usernamevalue);
		loginpage.pswrd(passwordvalue);
		loginpage.clickOnSignin();

		String newsContent = ExcelUtility.getStringData(0, 0, "managenews");
		ManageNewsPage managenew=new ManageNewsPage(driver);
		managenew.manageMessage();
		managenew.newMessage();
		//mg.messageText("special offer:50% off ");
		managenew.messageText(newsContent);
		managenew.saveButton();
		
		boolean message= managenew.isSuccessMsgDisplayed();
		Assert.assertTrue(message,Constant.NEWSFAILED);
		
	/*	FakerUtility utility=new FakerUtility();
		String username=utility.createRandomFirstName();*/
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
