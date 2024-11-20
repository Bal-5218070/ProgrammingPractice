package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
public CreatingNewContactPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(name="lastname")
private WebElement lastnametextfield;
@FindBy(xpath = "(//input[@title=\"Save [Alt+S]\"])[1]")
private WebElement savebutton;
@FindBy(name="support_start_date")
private WebElement startdate;
@FindBy(name="support_end_date")
private WebElement enddate;


public WebElement getStartdate() {
	return startdate;
}


public WebElement getEnddate() {
	return enddate;
}
/**
 * @return the lastnametextfield
 */
public WebElement getLastnametextfield() {
	return lastnametextfield;
}
/**
 * @return the savebutton
 */
public WebElement getSavebutton() {
	return savebutton;
}

public void createcontactwithsupportdate(String lastName ,String StartDate,String EndDate) {
	lastnametextfield.sendKeys(lastName);
	startdate.clear();
	startdate.sendKeys(StartDate);
	enddate.clear();
	enddate.sendKeys(EndDate);
	savebutton.click();
}
}
