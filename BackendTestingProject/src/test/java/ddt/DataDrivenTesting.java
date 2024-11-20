package ddt;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenTesting {
	@Test(dataProvider = "getData")
	public void createProject(String projectName,String status) {
		//you have to create requestbody
		//lets take simplest way
		
		/*
		 * String projectName="Google1234"; String status ="Created";
		 */
		
		
		String RequestBody="{\r\n"
				+ "  \"createdBy\": \"Deepak\",\r\n"
				+ "  \"projectName\": \""+projectName+"\",\r\n"
				+ "  \"status\": \""+status+"\",\r\n"
				+ "  \"teamSize\": 0\r\n"
				+ "}";
		given()
		.contentType(ContentType.JSON)
		.body(RequestBody)
		.when()
		.post("http://49.249.28.218:8091/addProject")
		.then()
		.log().all();
	}
	@DataProvider
	public Object[][] getData() throws Throwable {
		ExcelUtility eutil =new ExcelUtility();
		int count=eutil.getRowCount("Sheet1");
		Object[][] obarr = new Object[count][2];
		System.out.println(count);
		
		for(int i=0;i<count;i++) {
			obarr [i][0]=eutil.getDataFromExcel("Sheet1", i+1, 0);
			obarr [i][1]=eutil.getDataFromExcel("Sheet1", i+1, 1);
			System.out.println(obarr[i][0]);
			System.out.println(obarr[i][1]);
		}
		return obarr;
} 
}