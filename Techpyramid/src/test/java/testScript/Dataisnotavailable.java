package testScript;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Dataisnotavailable {
	public static void main(String[] args) throws IOException {
		String expectedtestid="TC_100";
		String data1="";
		String data2="";
		String data3="";
		boolean flag=false;
		FileInputStream fis =new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\Automation\\Techpyramid\\techpyramid2.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	Sheet sheet = workbook.getSheet("Sheet1");
	int rowcount = sheet.getLastRowNum();
	for(int i=0;i<=rowcount;i++) {
		String data="";
		try {
		 data = sheet.getRow(i).getCell(0).toString();
		 if(data.equals(expectedtestid)) {
			 flag=true;
			 data1 = sheet.getRow(i).getCell(1).toString();
			 data2 = sheet.getRow(i).getCell(2).toString();
			 data3 = sheet.getRow(i).getCell(3).toString();
		 }
		}catch (Exception e) {}
		
	}
	if(flag==true) {
		System.out.println(data1);
		System.out.println(data2);
		System.out.println(data3);
		}
	else {
		System.out.println((expectedtestid+"data is not avaliable"));
	}
	workbook.close();
}
}