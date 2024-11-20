package com.comcast.crm.objectrepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.clientname.projectname.generic.webdriverutility.Webdriverutility;

public class LoginPage extends Webdriverutility{
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this );//currentobjectreference of login page
	}
	//rule no 2object creation
@FindBy(name="user_name")
private WebElement usernameEdit;
@FindBy(name="user_password")
 private WebElement passwordEDit;
@FindBy(id="submitButton")
private WebElement loginBtn;
//objectinitialization
//rule no4 :object encapusulation

public WebElement getUsernameEdit() {
	return usernameEdit;
}

public WebElement getPasswordEDit() {
	return passwordEDit;
}

public WebElement getLoginBtn() {
	return loginBtn;
}
//rule no 5 we can provide action
public void loginToApp(String url,String username,String Password) {
	
	waitForPageToLoad(driver);
	driver.get(url);
	driver.manage().window().maximize();
	usernameEdit.sendKeys(username);
	passwordEDit.sendKeys(Password);
	loginBtn.click();
}

}
