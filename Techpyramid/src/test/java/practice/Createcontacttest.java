package practice;

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

public class Createcontacttest {
	public static void main(String[] args) throws IOException {
		FileInputStream fis =new FileInputStream("./commondata.properties");
		Properties prop =new Properties();
		prop.load(fis);
		String BROWSER = prop.getProperty("browser");
		String URL=prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		Random random =new Random();
		int randomint = random.nextInt(1000);
		FileInputStream fis1=new FileInputStream("./loginexcel.xlsx");
		Workbook workbook = WorkbookFactory.create(fis1);
		String orgnisationname = workbook.getSheet("org").getRow(1).getCell(2).toString()+randomint;
		String lastname=workbook.getSheet("org").getRow(1).getCell(5).toString();
		workbook.close();
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
