package testscript;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
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
	
	public void browserCloseAndQuit()
	
	{
		
		//driver.close();
		driver.quit();
	}
}
