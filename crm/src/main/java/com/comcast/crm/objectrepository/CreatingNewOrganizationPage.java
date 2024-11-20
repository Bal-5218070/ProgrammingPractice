package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this );//currentobjectreference of login page
	}
@FindBy(name="accountname")
private WebElement orgNameEdt;
@FindBy(xpath="(//input[@title=\"Save [Alt+S]\"])[1]")
private WebElement saveBtn;

public WebElement getOrgNameEdt() {
	return orgNameEdt;
}

public WebElement getSaveBtn() {
	return saveBtn;
}
public void createOrg(String orgnisationname) {
orgNameEdt.sendKeys(orgnisationname);
saveBtn.click();
}
}