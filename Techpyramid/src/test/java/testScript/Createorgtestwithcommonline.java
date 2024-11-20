package testScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Createorgtestwithcommonline {
	@Test
	public void createorgtest() {
		//read data from commond line
		
		String URL = System.getProperty("url");//if anybody wants to recieve data from commond line .there is java class called
		String BROWSER = System.getProperty("browser");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");s
		Random random =new Random();
		int ran=random.nextInt(1000);
		
		FileInputStream fis1=new FileInputStream("./loginexcel.xlsx");
		Workbook workbook = WorkbookFactory.create(fis1);
		Sheet sh = workbook.getSheet("sheet1");
		Row row = sh.getRow(0);
		String sheetname= row.getCell(0).toString()+ran;
		
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
}
}