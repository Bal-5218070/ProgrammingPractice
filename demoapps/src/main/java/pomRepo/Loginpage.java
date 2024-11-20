package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
public Loginpage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	
}
@FindBy(id="email")
private WebElement emailTextField;

@FindBy(id="password")
private WebElement passwordTextField;

@FindBy(xpath="//button[text()='Login']")
private WebElement loginButton;

@FindBy(xpath="//div[text()='Registered successfully']")
private WebElement registeredsuccessfulMsg;

@FindBy(xpath="//div[text()='Signin successful']")
private WebElement signinsuccesfulMsg;

public WebElement getEmailTextField() {
	return emailTextField;
}

public WebElement getPasswordTextField() {
	return passwordTextField;
}

public WebElement getLoginButton() {
	return loginButton;
}

public WebElement getRegisteredsuccessfulMsg() {
	return registeredsuccessfulMsg;
}

public WebElement getSigninsuccesfulMsg() {
	return signinsuccesfulMsg;
}
public void loginUser(String email,String password) throws InterruptedException {
	emailTextField.sendKeys(email);
	passwordTextField.sendKeys(password);
	loginButton.click();
	Thread.sleep(2000);
}
public boolean verifyRegisterUser() {
	return registeredsuccessfulMsg.isDisplayed();
}
public boolean verifyLoginUser() {
	return signinsuccesfulMsg.isDisplayed();   
}
}


