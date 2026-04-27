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
		//convert webdriver to screenshot mode.selenium webdriver cannot take screeenshot.so we typecast into screenshot
		
		
		TakesScreenshot scrShot = (TakesScreenshot) driver; // TakesScreenshot capture the current situation of the
															// browser
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//capture the screenshot.it stored temporarily as a file
		
		
		//create date and time
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		
		//
		
		File f1 = new File(System.getProperty("user.dir") + "//outputScreenShot"); //// OutputScreenShot"-the scrrenshot
																					//// is generated in this folder ie
																					//// the loctn only
		if (!f1.exists()) {
			f1.mkdirs(); // create a folder if it  doesnot exists
		}
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
				+ ".png";//decide final screenshot path
		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination); // FileHandler-class 
		//used to copy the final destination,screenshot was temporarily and now saved permantely in the folder
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
