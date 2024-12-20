package vtiger1.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(linkText="Leads")
	private WebElement leadLinks;
	public WebElement getLeadLinks() {
		return leadLinks;
	}
	public void  clickOnLeadModule() {
		leadLinks.click();
	}
	
}
