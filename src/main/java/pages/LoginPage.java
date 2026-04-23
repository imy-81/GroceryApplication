package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
	//locators
	@FindBy(xpath="//input[@placeholder='Username']")WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']")WebElement password;
	@FindBy(xpath="//button[text()='Sign In']")WebElement signin;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
	@FindBy(xpath="//div[contains(@class,' alert-dismissible')]")WebElement alertmsg;
	
	@FindBy(xpath="//i[contains(@class,'fa-th-large')]")WebElement  greendashboard;;
	
	@FindBy(xpath="//div[contains(@class,'alert-danger') or contains(@class,'alert-dismissible')]") 
	WebElement alertvisible;
	
	
	//constructor
	public WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//actions
	
	public void username(String usernamevalue)
	{
		
		username.sendKeys(usernamevalue);
	}

	public void pswrd(String passwordvalue)
	{
		password.sendKeys(passwordvalue);
	}

	public void clickOnSignin()
	{  /*WaitUtility wait=new WaitUtility();
	wait.waitForElementToBeClickable(driver, signin);*/
		signin.click();
		
		
		
		
	}
	public boolean  isHomePageDisplayed()
	
	{
		
		return dashboard.isDisplayed();
		
	}
	public boolean isAlertMsgDisplayed()
	{
		return alertmsg.isDisplayed();
		}
	
	public boolean isDashBoardDisplayed()
	{
		return greendashboard.isDisplayed();}
	
	public boolean isAlertVisibilityDisplayed()
	
	{
		return alertvisible.isDisplayed();}
	
}
	


