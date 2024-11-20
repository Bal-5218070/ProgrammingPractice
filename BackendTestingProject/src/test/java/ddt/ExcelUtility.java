package ddt;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
String testDataPath ="./BackendtestingTestdata.xlsx";
/**
 * 
 * @param SheetName
 * @param rowNum
 * @param cellNum
 * @return
 * @throws Throwable
 */
public String getDataFromExcel (String SheetName,int rowNum,int cellNum) throws Throwable {
	
	
	FileInputStream fis =new FileInputStream(testDataPath);
	Workbook wb=WorkbookFactory.create(fis);
	String data= wb.getSheet(SheetName).getRow(rowNum).getCell(cellNum).toString();
	wb.close();
	return data;
}
/**
 * 
 * @param sheetName
 * @return
 * @throws Throwable
 */
public int getRowCount(String sheetName) throws Throwable {
	FileInputStream fis =new FileInputStream(testDataPath);
	Workbook wb=WorkbookFactory.create(fis);
	int rowCount =wb.getSheet(sheetName).getLastRowNum();
	wb.close();
	return rowCount;
}
/**
 * @author DELL
 * @param sheetName
 * @param RowNum
 * @param cellNum
 * @throws Throwable
 */
public void setDataIntoExcel(String sheetName,int RowNum,int cellNum) throws Throwable {
	FileInputStream fis =new FileInputStream(testDataPath);
	Workbook wb=WorkbookFactory.create(fis);
	wb.getSheet(sheetName).getRow(RowNum).createCell(cellNum);
	FileOutputStream fos =new FileOutputStream(testDataPath);
	wb.write(fos);
	wb.close();
	
	
	
}

}
