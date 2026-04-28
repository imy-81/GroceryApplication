package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotUtility {

	
	public void getScreenShot(WebDriver driver, String failedTestCase) throws IOException {
		
		
		//convert webdriver to screenshot mode.selenium webdriver cannot take screeenshots directly.so we typecast into screenshot 
		TakesScreenshot scrShot = (TakesScreenshot) driver; //takesscreenshot is an interface
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//capture the screenshot and stores it temporarily as a  file
		
		
		// to create date and time
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		
		//
		
		File f1 = new File(System.getProperty("user.dir") + "//outputScreenShot"); //location
		if (!f1.exists()) {
			f1.mkdirs(); // to create a folder if it  doesnot exists
		}
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
				+ ".png";//decide final screenshot path
		
		//copy the screenshot to the final destination
		
		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination); 
		
		// FileHandler-class and copy  used to move from one location to another location
		//inside the copy(we have to add temporaryscreenshot(ie,screenshot) and final destination)
		//earlier it was temporary and  now saved as permantely in the folder
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
