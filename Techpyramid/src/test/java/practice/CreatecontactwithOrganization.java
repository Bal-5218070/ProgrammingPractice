package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreatecontactwithOrganization {
public static void main(String[] args) throws IOException, InterruptedException {
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
	String orgnisationname = workbook.getSheet("org").getRow(13).getCell(2).toString()+randomint;
	String CONTACTlastName = workbook.getSheet("org").getRow(13).getCell(3).toString()+randomint;
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
	driver.get(URL);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys(orgnisationname); 
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	/*
	 * String headerinfo =
	 * driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
	 * if(headerinfo.contains(orgnisationname)) {
	 * System.out.println(orgnisationname+"is created==pass"); }else {
	 * System.out.println(orgnisationname+"is not created==fail"); }
	 */
	//nevigate to  contact module
	Thread.sleep(2000);
	
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	driver.findElement(By.name("lastname")).sendKeys(CONTACTlastName);
	driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
	
	//switch to window
	Set<String> allids = driver.getWindowHandles();
	/*
	 * Iterator<String> it1 = allids.iterator(); while(it1.hasNext()) { String
	 * windowid1 = it1.next();
	 */
	for(String id:allids) {
		driver.switchTo().window(id);
		String actualurl =driver.getCurrentUrl();
		if(actualurl.contains("module=Accounts&action")) 
		{
			break;
		}
	}
	
	
	driver.findElement(By.name("search_text")).sendKeys(orgnisationname);//dynamically createdd 
	driver.findElement(By.name("search")).click();
	driver.findElement(By.xpath("//a[text()='"+orgnisationname+"']")).click();
	//switch to parentwindow
	
	Set<String> allids1 = driver.getWindowHandles();
	Iterator<String> it2 = allids1.iterator();
	while(it2.hasNext()) {
		String windowid2 = it2.next();
		driver.switchTo().window(windowid2);
		String parenturl = driver.getCurrentUrl();
		if(parenturl.contains("module=Contacts"));
	}
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	//verifyHeader orgname info expectedresult
	String actualorgname = driver.findElement(By.id("mouseArea_Organization Name")).getText();
	System.out.println(actualorgname);

	if(actualorgname.trim().equals(orgnisationname)) {
		System.out.println(orgnisationname + "information is verified");
	}
	else
	{
		System.out.println(orgnisationname+"information is not verified  ");
	}
}
}
