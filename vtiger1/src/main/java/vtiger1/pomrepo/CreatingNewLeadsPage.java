package vtiger1.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewLeadsPage {
public CreatingNewLeadsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(name="salutationtype")
private WebElement LeadSolutationDropdown;
@FindBy(name="firstname")
private WebElement leadFirstNameTextField;
@FindBy(name="lastname")
private WebElement leadlastNameTextField;
@FindBy(name="company")
private WebElement CompanyName;
@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement LeadSaveButton;

public WebElement getLeadSolutationDropdown() {
	return LeadSolutationDropdown;
}
public WebElement getLeadFirstNameTextField() {
	return leadFirstNameTextField;
}
public WebElement getLastNameTextField() {
	return leadlastNameTextField;
}
public WebElement getCompanyName() {
	return CompanyName;
}

public WebElement getLeadSaveButton() {
	return LeadSaveButton;
}
public void selectFromDropdown(String salutation) {
	Select select =new Select(LeadSolutationDropdown);
			select.deselectByVisibleText(salutation);
}
public void enterLeadFirstName(String leadfirstname) {
	leadFirstNameTextField.sendKeys(leadfirstname);
}
public void enterLeadlastName(String leadLastName) {
	leadlastNameTextField.sendKeys(leadLastName);
}
public void enterCompanyName(String companyname) {
	CompanyName.sendKeys(companyname);
}
public void clickOnleadSaveButton() {
	LeadSaveButton.click();
}
}
