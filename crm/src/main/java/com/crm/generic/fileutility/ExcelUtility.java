package com.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
public String getDataFromExcel(String sheetName,int rownum,int celnum) throws EncryptedDocumentException, IOException {
	FileInputStream fis2 =new FileInputStream("./testdata/loginexcel.xlsx");
	Workbook wb = WorkbookFactory.create(fis2);
	String data = wb.getSheet(sheetName).getRow(rownum).getCell(celnum).toString()	;
	wb.close();
	return data;
}
public int getRowcount(String sheetName) throws EncryptedDocumentException, IOException {
	FileInputStream fis2 =new FileInputStream("./testdata/loginexcel.xlsx");
	Workbook wb = WorkbookFactory.create(fis2);
	int rowcount = wb.getSheet(sheetName).getLastRowNum();
	wb.close();
	return rowcount;
}
public void setDataIntoExcel(String sheetName, int rownum , int celnum ,String data) throws Throwable {
	FileInputStream fis2 =new FileInputStream("./testdata/loginexcel.xlsx");
	Workbook wb = WorkbookFactory.create(fis2);
	wb.getSheet(sheetName).getRow(rownum).createCell(celnum);
	FileOutputStream fos =new FileOutputStream("./testdata/loginexcel.xlsx");
	wb.write(fos);
	wb.close();
}
}
