package vtiger1.genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	WebDriver driver;
	public FileUtility f1 =new FileUtility();
public	ExcelUtility e1 =new ExcelUtility();
	public WebDriverUtility w1 = new WebDriverUtility();
@BeforeClass
public void bc() throws IOException { 
	String URL = f1.fetchDataFromPropertyfile("url");
	String BROWSER = f1.fetchDataFromPropertyfile("browser");
	if(BROWSER.equals("chrome")) {
		driver = new ChromeDriver();
	}
	else if (BROWSER.equals("firefox")) {
		driver =new FirefoxDriver();
	}
	if(BROWSER.equals("edge")) {
		driver=new EdgeDriver();
	}
	w1.maximizeWindow(driver);
	w1.pageToLoad(driver);
	driver.get(URL);
	System.out.println("browser is launched");
}
@BeforeMethod
public void bm() throws IOException {
	String USERNAME = f1.fetchDataFromPropertyfile("username");
	String PASSWORD = f1.fetchDataFromPropertyfile("password");
	
}
}
