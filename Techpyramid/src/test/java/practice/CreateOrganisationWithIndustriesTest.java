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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganisationWithIndustriesTest {
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
	String industry = workbook.getSheet("org").getRow(4).getCell(3).toString();
	String type = workbook.getSheet("org").getRow(4).getCell(4).toString();
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
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys(orgnisationname);
	WebElement webele = driver.findElement(By.name("industry"));
	Select select =new Select(webele);
	select.selectByVisibleText(industry);
	WebElement webelement2 = driver.findElement(By.name("accounttype"));
	Select select2=new Select(webelement2);
	select2.selectByVisibleText(type);
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//verify the dropdown industry and type info
	
	
			 String actualindustries = driver.findElement(By.id("dtlview_Industry")).getText();
			 if(actualindustries.equals(industry)) {
					System.out.println(industry+"information is verified==pass");
				}else {
					System.out.println(industry+" information is not verified==fail");
				}
			 String actualType = driver.findElement(By.id("dtlview_Type")).getText();
			 if(actualType.equals(type)) {
					System.out.println(type+" information is verified==pass");
				}else {
					System.out.println(type+"information is not verified==fail");
				}
			 driver.quit();
}
}
