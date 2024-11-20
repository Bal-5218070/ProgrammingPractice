package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;
import java.util.Random;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Createacontactwithsupportdate {
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
	
	String lastname=workbook.getSheet("org").getRow(10).getCell(5).toString()+randomint ;
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
	
	java.util.Date date =new java.util.Date();
	SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
	String startdate = sim.format(date);
	System.out.println(startdate);
	
	Calendar cal = sim.getCalendar();	
	cal.add( Calendar.DAY_OF_MONTH,30);
	String lastdate = sim.format(cal.getTime());
	
	
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	driver.findElement(By.name("lastname")).sendKeys(lastname);
	
	
	driver.findElement(By.name("support_start_date")).clear();
	driver.findElement(By.name("support_start_date")).sendKeys(startdate);
	
	driver.findElement(By.name("support_end_date")).clear();
	driver.findElement(By.name("support_end_date")).sendKeys(lastdate);
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 String ACTUALStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
	 String ACTUALendadate = driver.findElement(By.id("dtlview_Support End Date")).getText();
	 if(ACTUALStartDate.equals(startdate)) {
			System.out.println(startdate+" information is verified==pass");
		}else {
			System.out.println(startdate+"information is not verified==fail");
		}
	 if(ACTUALendadate.equals(lastdate)) {
			System.out.println(lastdate+"information is verified==pass");
		}else {
			System.out.println(lastdate+"is not verified==fail");
		}
}
}

