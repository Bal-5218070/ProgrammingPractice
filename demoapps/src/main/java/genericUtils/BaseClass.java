package genericUtils;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
public WebDriver driver ;
public 	FileUtility fUtils = new FileUtility();
@BeforeClass
public void bc() throws IOException {
	String browserName = fUtils.fetchDatafromPropertyFile("browser");
	String url = fUtils.fetchDatafromPropertyFile("url");
	if (browserName.equals("chrome")) {
		driver = new ChromeDriver();
	}
	if (browserName.equals("edge")) {
		driver = new EdgeDriver();
}
	System.out.println("browser is launched");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

driver.get(url);
System.out.println("navigated to the url");
}
@AfterClass
public void ac() {
	driver.quit();
	System.out.println("browser closed");
}
}

 