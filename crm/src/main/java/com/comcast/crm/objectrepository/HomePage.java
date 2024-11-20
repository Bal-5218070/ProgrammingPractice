package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this );//currentobjectreference of home page
	}
@FindBy(linkText="Organizations")
private WebElement orgLink;
@FindBy(linkText="Contacts")
private WebElement contactlink;
@FindBy(linkText="Campaigns")
private WebElement campaign;
@FindBy(linkText="More")
private WebElement morelink;
@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement administratorlinks;

@FindBy(xpath ="//a[@href='index.php?module=Users&action=Logout']")
private WebElement signoutBtn;


public WebElement getSignoutBtn() {
	return signoutBtn;
}

public WebElement getAdministratorlinks() {
	return administratorlinks;
}

public WebElement getCampaign() {
	return campaign;
}

public WebElement getOrgLink() {
	return orgLink;
}

public WebElement getContactlink() {
	return contactlink;
}

public WebElement getMorelink() {
	return morelink;
}

public void nevigateToCampaignPage() {
	Actions action= new Actions(driver);
	action.moveToElement(morelink).perform();;
	
}
public void logout() throws InterruptedException {
	Actions action =new Actions (driver);
	Thread.sleep(2000);
	action.moveToElement(administratorlinks).perform();
	signoutBtn.click();
	
}

}
