package vtiger1.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LeadInformationPage {

	public LeadInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
