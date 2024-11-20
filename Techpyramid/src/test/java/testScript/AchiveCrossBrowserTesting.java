package testScript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AchiveCrossBrowserTesting {
public static void main(String[] args) throws IOException {
	FileInputStream fis =new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\Automation\\Techpyramid\\commondata.properties");
	Properties prop =new Properties();
	prop.load(fis);
	String BROWSER = prop.getProperty("browser");
	String URL = prop.getProperty("url");
	String USERNAME = prop.getProperty("username");
	String PASSWORD = prop.getProperty("password");
	WebDriver driver =null;
	if(BROWSER.equals("chrome")) {
		driver=new ChromeDriver();
	}
	else if(BROWSER.equals("firefox")) {
		driver= new FirefoxDriver();
	}
	else if(BROWSER.equals("edge")) {
		driver=new EdgeDriver();
	}
	driver= new ChromeDriver();
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Organizations")).click();
	
}
}
