package testScript;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Seleniumtestreaddatafromruntime {
public static void main(String[] args) {
	@Test
	public void seleniumTest() {
		FileInputStream fis =new FileInputStream("./commondata.properties");
		Properties prop =new Properties();
		prop.load(fis);
		String Browser = 
		String URL = 
		String USERNAME = 
		String PASSWORD =   
		WebDriver driver =null;
		if(Browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(Browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.quit();
	}
}
}
