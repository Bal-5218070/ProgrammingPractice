package testScript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Toreadthedatamultiplerow {
public static void main(String[] args) throws Exception {
	FileInputStream fis =new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\Automation\\Techpyramid\\Product category.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	Sheet sheet = workbook.getSheet("sheet1");
	int rownum = sheet.getLastRowNum();
	for(int i=1;i<=rownum;i++) {
		Row row = sheet.getRow(i);
		String column1data = row.getCell(0).toString();
		String column2data = row.getCell(1).toString();
		System.out.println(column1data+" "+column2data);
	}
	
}
}
