package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
public ContactPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement createcontactbutton;

public WebElement getCreatecontactbutton() {
	return createcontactbutton;
}


}
