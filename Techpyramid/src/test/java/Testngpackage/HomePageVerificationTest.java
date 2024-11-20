package Testngpackage;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageVerificationTest {
@Test
public void homePageTest(Method mtd) {
	System.out.println(mtd.getName()+"test Start");
	String expectedPage="Home Page";
	WebDriver driver =new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://localhost:8888");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	String actualtille =driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
	//hardassert
	Assert.assertEquals(actualtille, expectedPage);
	/*if(actualtille.trim().equals(expectedPage)) {
		System.out.println(expectedPage+"page is verified==pass");
	}else
	{
		System.out.println(expectedPage+"page is not verified==FAilsyso");
	}*/
	driver.close();
	System.out.println(mtd.getName()+"test End");
	
	
	
	
}
@Test
public void verifyLogoHomePageTest(Method mtd) {
	System.out.println(mtd.getName()+"test Start");
	WebDriver driver =new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://localhost:8888");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	boolean status = driver.findElement(By.xpath("//img[@src='test/logo/vtiger-crm-logo.gif']")).isEnabled();
	//Assert.assertEquals(true, status);
	Assert.assertTrue(status);
	/*if(status) {
		System.out.println("logo is verified");
	}else {
		System.out.println("logo is not verified");
	}*/
	driver.close();
	System.out.println(mtd.getName()+"test end");
	
	
	
	
	
	
	
	
	
	
	
	
}
}