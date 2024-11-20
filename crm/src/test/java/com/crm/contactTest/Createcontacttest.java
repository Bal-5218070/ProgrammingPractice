package com.crm.contactTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.generic.fileutility.ExcelUtility;
import com.crm.generic.fileutility.FileUtility;

public class Createcontacttest {
	public static void main(String[] args) throws IOException {
		FileUtility flib =new FileUtility();
		
		ExcelUtility elib= new ExcelUtility();
		String BROWSER	=flib.getDataFrompropertyFile("browser");
		String URL = flib.getDataFrompropertyFile("url");
		String USERNAME =flib.getDataFrompropertyFile("username");
		String PASSWORD = flib.getDataFrompropertyFile("password");
		
		Random random =new Random();
		int randomint = random.nextInt(1000);
		
		
		String lastname=elib.getDataFromExcel("org", 1, 5)+randomint;
		
		WebDriver driver=null;
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String actuallastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if(actuallastName.equals(lastname)) {
			System.out.println(lastname+"information is verified");
		}
		else
		{
			System.out.println(lastname+"information is not verified");
		}
		driver.quit();
}
}
