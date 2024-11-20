package vtiger1.genericutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
public void maximizeWindow(WebDriver driver) {
	driver.manage().window().maximize();
}
public void pageToLoad(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IPathConstant.IMPLICIT_WAIT));
}
public void elementToBeClickable(WebDriver driver, WebElement element) {
	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(IPathConstant.EXPLCIT_WAIT));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
public void switchToWindow(WebDriver driver,String elementToSwitch) {
	Set<String> allids = driver.getWindowHandles();
	for(String id:allids) {
	driver.switchTo().window(id);
	String currenttitle = driver.getTitle();
	if(currenttitle.contains(elementToSwitch))
	{
			break;
	}
			
	}
	
}
public static void takesScreenShot(WebDriver driver,String filename) throws IOException {
	TakesScreenshot ts= (TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target=new File(".\\src\\test\\resources\\Screenshot"+filename+".png");
	Files.copy(source, target);
}
}
