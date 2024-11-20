package com.crm.comcast.contactTest;


import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.comcast.crm.objectrepository.ContactInformationPage;
import com.comcast.crm.objectrepository.ContactPage;
import com.comcast.crm.objectrepository.CreatingNewContactPage;
import com.comcast.crm.objectrepository.HomePage;
import com.crm.generic.baseutility.BaseClass;



 public class CreateContactTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void createContact() throws EncryptedDocumentException, IOException {
		// read testscript data from excel file
		String lastname = elib.getDataFromExcel("org", 10, 5) + jlib.getRandomNum();

		HomePage page = new HomePage(driver);
		page.getContactlink().click();
		// create contact page
		ContactPage page1 = new ContactPage(driver);
		page1.getCreatecontactbutton().click();
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.getLastnametextfield().sendKeys(lastname);
		cncp.getSavebutton().click();

		ContactInformationPage cip = new ContactInformationPage(driver);
		String contactname = cip.getActuallastname().getText();

		if (contactname.equals(lastname)) {
			System.out.println(lastname + "information is verified");
		} else {
			System.out.println(lastname + "information is not verified");
		}
		System.out.println("execute create contact and verify");
	}

	@Test(groups = "regressionTest")
	public void createContactWithSupportDate() throws Throwable, IOException {
		String lastname = elib.getDataFromExcel("org", 10, 5) + jlib.getRandomNum();
		String enddate = jlib.getSystemDateYYYYDDMM();
		String startDate = jlib.getRequiredDateYYYYMMDD(30);

		HomePage page = new HomePage(driver);
		page.getContactlink().click();
		// create contact page
		ContactPage page1 = new ContactPage(driver);
		page1.getCreatecontactbutton().click();
		// enter all thedetails and create new contact
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.createcontactwithsupportdate(lastname, startDate, enddate);

		// verify actual start date with startdA

	}

}
