package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	WebDriver driver;
	public OrganizationsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this );//currentobjectreference of login page
	}
	
	@FindBy(name="search_text")
	private WebElement searchEdit;
	
	public WebElement getSearchEdit() {
		return searchEdit;
	}
	@FindBy(name="search_Field")
			private WebElement searchDropdown;
	
	public WebElement getSearchDropdown() {
		return searchDropdown;
	}
	@FindBy(name="submit")
	private WebElement searchbutton;
	
	public WebElement getSearchbutton() {
		return searchbutton;
	}
@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
private WebElement createneworgbtn;

public WebElement getCreateneworgbtn() {
	return createneworgbtn;
}

}
