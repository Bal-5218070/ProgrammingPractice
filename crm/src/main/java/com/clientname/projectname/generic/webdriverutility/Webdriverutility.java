package com.clientname.projectname.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriverutility {
public void waitForPageToLoad(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}
public void waitforElementPresent(WebDriver driver,WebElement element) {
	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(element));
}
public void switchnewBrowsertabonchild(WebDriver driver,String partialUrl) {
	Set<String> allids = driver.getWindowHandles();
	for(String id:allids) {
		driver.switchTo().window(id);
		String actualurl =driver.getCurrentUrl();
		if(actualurl.contains("module=Accounts&action")) 
		{
			break;
		}
	}
}
	public void switchnewBrowsertabBasedonparent(WebDriver driver,String partialparenturl) {
		
		Set<String> allids1 = driver.getWindowHandles();
		Iterator<String> it2 = allids1.iterator();
		while(it2.hasNext()) {
			String windowid2 = it2.next();
			driver.switchTo().window(windowid2);
			String parenturl = driver.getCurrentUrl();
			if(parenturl.contains("module=Contacts"));
			{
				break;
			}
		}
		}
	public void switchtoFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	public void switchtoFrame(WebDriver driver,String nameId) {
		driver.switchTo().frame(nameId);
	}
	public void switchtoFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
}
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
}
	public void select(WebElement element,String text) {
		Select sel =new Select(element);
		sel.selectByVisibleText(text);
	}
	public void select(WebElement element,int index) {
		Select sel =new Select(element);
		sel.selectByIndex(index);
	}
	public void mousemoveElement(WebDriver driver,WebElement element) {
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
}
	public void doubleclick(WebDriver driver,WebElement element) {
		Actions act= new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	
}