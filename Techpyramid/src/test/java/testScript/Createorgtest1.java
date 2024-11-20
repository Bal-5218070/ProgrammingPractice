package testScript;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Createorgtest1 {
	
	public static void main(String[] args) throws IOException, ParseException {
		
		JSONParser parser =new JSONParser();
		FileReader file =new FileReader("./appcommondata.json");
		Object obj = parser.parse(file);
		JSONObject map = (JSONObject)obj;
		String Browser = map.get("browser").toString();
		String URL = map.get("url").toString();
		String USERNAME = map.get("username").toString();
		String PASSWORD =map.get("password").toString();
		
		
		FileInputStream fis1=new FileInputStream("./loginexcel.xlsx");
		Workbook workbook = WorkbookFactory.create(fis1);
		Sheet sh = workbook.getSheet("sheet1");
		Row row = sh.getRow(0);
		String sheetname= row.getCell(0).toString();
		
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
		driver.findElement(By.linkText("Organizations"));
		driver.findElement(By.xpath("//img[@title='Create Organization...']"));
		driver.findElement(By.name("accountname")).sendKeys(sheetname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@ src='themes/softed/images/mainSettings.PNG'])"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
}
