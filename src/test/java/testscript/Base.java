package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.ScreenShotUtility;
import utilities.WaitUtility;



public class Base {

	public  WebDriver driver;
	
	public Properties properties;
	
	@Parameters("browser")
	@BeforeMethod(alwaysRun=true)
	
	public void browserinitialization(String browser) throws Exception
	
	
		{
		try {properties=new Properties();
		FileInputStream fileinputstream=new FileInputStream(Constant.CONFIGFILE);
		properties.load(fileinputstream);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
			
			
		}	else if(browser.equalsIgnoreCase("firefox"))
			
		{
			driver=new FirefoxDriver();
			
			
		}	else if(browser.equalsIgnoreCase("edge"))
			
		{
			
			driver=new EdgeDriver();
		}
		else {
			
			throw new Exception("invalid browser");
		}	
			
			
		//driver=new ChromeDriver();
		//driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.get(properties.getProperty("url"));//to access the value from config.properties
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICITWAIT));
		driver.manage().window().maximize();
		
		
	}
	
	
	
	
	@AfterMethod(alwaysRun=true)
	
	public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			ScreenShotUtility scrShot = new ScreenShotUtility(); // creating obj
			scrShot.getScreenShot(driver, iTestResult.getName());//retrive the name of the testcase
		}

	} }//getstatus is a method to get the status of test execution,if its failed it creates new instance of Screenshotutility
