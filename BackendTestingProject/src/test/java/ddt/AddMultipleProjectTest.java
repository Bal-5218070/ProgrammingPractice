package ddt;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddMultipleProjectTest {
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
public Object[][] getData() {
	Object[][] obarr = new Object[3][2];
	obarr[0][0]="AirIndia_1";
	obarr[0][1]="Created";
	obarr[1][0]="AirIndia_2";
	obarr[1][1]="Created";
	obarr[2][0]="AirIndia_3";
	obarr[2][1]="Created";
	return obarr;
}
}
