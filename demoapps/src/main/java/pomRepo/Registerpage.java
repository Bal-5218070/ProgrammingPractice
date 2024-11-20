package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registerpage {
public Registerpage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}

@FindBy(id="name")
private WebElement nameTestField;

@FindBy(id="email")
private WebElement emailTestField;

@FindBy(id="password")
private WebElement passwordTestField;

@FindBy(xpath="//button[text()='Register']")
private WebElement registerButton;

public WebElement getNameTestField() {
	return nameTestField;
}

public WebElement getEmailTestField() {
	return emailTestField;
}

public WebElement getPasswordTestField() {
	return passwordTestField;
}

public WebElement getRegisterButton() {
	return registerButton;
}
public void registerUser(String name,String email,String password) {
	nameTestField.sendKeys(name);
	emailTestField.sendKeys(email);
	passwordTestField.sendKeys(password);
	registerButton.click(); 
}
}
