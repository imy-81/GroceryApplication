package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {

	public void fileUploadBySendKeys(WebElement element,String filepath)
	
	{
		FileUploadUtility up=new FileUploadUtility();
		
		element.sendKeys(filepath);
	}
	
	
	public void fileuploadByRobot(WebElement element,String filepath) throws AWTException
	
	{
		
		
		
		StringSelection s =new StringSelection("C:\\Users\\tomso\\Downloads\\French Project. (1).pdf");
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null );
		Robot robot=new Robot();
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
