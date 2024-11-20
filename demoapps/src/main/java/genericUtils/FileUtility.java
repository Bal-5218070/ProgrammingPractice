package genericUtils;

import java.io.FileInputStream; 
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
public String fetchDatafromPropertyFile(String key) throws IOException {
	FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\Automation\\demoapps\\src\\test\\resources\\testData\\propertydata.properties");
	Properties prop =new Properties();
	prop.load(fis);
	return prop.getProperty(key);
	
}
public String fetchDataFromExcelSheet(String sheetname,int rowno,int cellno) throws IOException {
	//sheet name common data dena hai
	FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\Automation\\demoapps\\src\\test\\resources\\testData\\Book2.xlsx");
	return WorkbookFactory.create(fis).getSheet(sheetname).getRow(rowno).getCell(cellno).getStringCellValue();
	
}
}