package com.crm.comcast.orgtest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.comcast.crm.objectrepository.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.OrganizationsPage;
import com.crm.generic.baseutility.BaseClass;

public class CreateOrgTest1 extends BaseClass {
	public void createOrgTest() throws Throwable, IOException {
		String	OrganizationName=elib.getDataFromExcel("org", 1, 2)+jlib.getRandomNum();
			System.out.println("execute create orgtest and verify");
			HomePage page = new HomePage(driver);
			page.getOrgLink().click();
			OrganizationsPage op =new OrganizationsPage(driver);
			op.getCreateneworgbtn().click();
			CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
			cnop.createOrg(OrganizationName);
			
		}
		@Test
		public void createContactWithDate() {
			System.out.println("execute create org with industry & verify");
		}
}
