package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LogOutPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base {


@Test(groups= {"regression"})
public void verifyLogoutTest() throws IOException, InterruptedException

{


	String usernamevalue=ExcelUtility.getStringData(1, 0, "loginpage");
	
	String passwordvalue=ExcelUtility.getStringData(1, 1,"loginpage");
	
	LoginPage loginpage=new LoginPage(driver);
	loginpage.username(usernamevalue);
	loginpage.pswrd(passwordvalue);
	loginpage.clickOnSignin();

	
	
	LogOutPage lp=new LogOutPage(driver);
	
	lp.dropdown();
	lp.clickLogout();
	 System.out.println("Logout successfully");
	
	 boolean signinbtn=lp.isSignInBtnVisible();
	 Assert.assertTrue(signinbtn);
	 
	 
	 
	 
	 
	 
	 
	 
}} 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	

   /* String currentUrl = driver.getCurrentUrl();
    System.out.println(currentUrl);

    Assert.assertTrue(currentUrl.contains("login"), "Logout failed!");*/

   















/*try {
    Thread.sleep(3000);
} catch (InterruptedException e) {
    e.printStackTrace();
}*/






	
	
	
	
	
	
	
	
 
