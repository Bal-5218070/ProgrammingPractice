package com.crm.generic.baseutility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.clientname.projectname.generic.webdriverutility.JavaUtilty;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.LoginPage;
import com.crm.generic.databaseutility.DataBaseUtility;
import com.crm.generic.fileutility.ExcelUtility;
import com.crm.generic.fileutility.FileUtility;

public class BaseClass {
 public      DataBaseUtility dblib =new DataBaseUtility();
  public     FileUtility futils =new FileUtility();
  public    ExcelUtility elib= new ExcelUtility();
   public    JavaUtilty jlib =new JavaUtilty();


     public WebDriver driver =null;
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBs() throws SQLException {
		System.out.println("===connect to db======,report config");
		dblib.getDbconnection();
	}
	@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBc(String browser) throws IOException {//here we recieve parameter from BROWSER key
		System.out.println("===launch a browser====");
		String BROWSER = browser;
				//futils.getDataFrompropertyFile("browser");
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}
		else
			 driver= new ChromeDriver();
		
	}
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBm() throws Throwable {
		System.out.println("=====login to application====");
		String URL = futils.getDataFrompropertyFile("url");
		String USERNAME = futils.getDataFrompropertyFile("username");
		String PASSWORD = futils.getDataFrompropertyFile("password");
		LoginPage page = new LoginPage(driver);
		page.loginToApp(URL, USERNAME, PASSWORD);
	}
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAm() throws InterruptedException {
		System.out.println("==== logout from application======");
		HomePage page1 =new HomePage(driver);
		page1.logout();
		
	}
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAc() 
	{
		driver.quit();
	System.out.println("======close the browser=====");
	}
	@AfterSuite (groups = {"smokeTest","regressionTest"})
	public void configAs() {
		System.out.println("=====closedb,report backup===");
	}	
}
