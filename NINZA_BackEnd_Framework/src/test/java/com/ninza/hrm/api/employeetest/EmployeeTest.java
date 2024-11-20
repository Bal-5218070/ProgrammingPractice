package com.ninza.hrm.api.employeetest;

import static io.restassured.RestAssured.given;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;
import com.ninja.hrm.api.pojoclass.EmployeePojo;
import com.ninja.hrm.api.pojoclass.ProjectPojo;
import com.ninza.hrm.api.generic.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EmployeeTest {
	JavaUtility jutl =new  JavaUtility();
	
@Test
public void addEmployeeTest() throws SQLException {
	
	
	String projectName="Airtel_"+jutl.getRandomNumber();
	
	String username ="user"+jutl.getRandomNumber();
	ProjectPojo pobj =new ProjectPojo(projectName, "Created", "Deepak", 0);
//Api-1==>add a project inside the server
//try to automate precondion 1 .its a rule of automation
	
          given()
	.contentType(ContentType.JSON).log().all()
	.body(pobj)
	.when()
	.post("http://49.249.28.218:8091/addProject")

	.then()
	.log().all();

	

	
	
	
	
	//Api-2==> add employee to same Project
	/*
	 * String designation, String dob, String email, String empName, double
	 * experience, String mobileNo, String project, String role, String username
	 */
	EmployeePojo empObj= new EmployeePojo("Arcietect","10/02/1992", "deepak123@gmail.com", username, 18.5, "9889310349", projectName, "ROLE_EMPLOYEE",username );
	
	given()
			.contentType(ContentType.JSON)
			.body(empObj)
			.when()
			.post("http://49.249.28.218:8091/employees")
			.then()
			.assertThat().statusCode(201)
			.and()
			.time(Matchers.lessThan(3000L))
			
			.log().all();
	//verify Emp name in data base
	/*
	 * boolean flag=false; Driver driverRef = new Driver();
	 * DriverManager.registerDriver(driverRef); Connection con
	 * =DriverManager.getConnection(
	 * "jdbc:mysql://49.249.28.218:8091:3333/ninza_hrm", "root@%", "root");
	 * ResultSet result
	 * =con.createStatement().executeQuery("select* from employee ");
	 * while(result.next()) { System.out.println(result.getString(5));
	 * if(result.getString(4).equals(projectName)) { flag=true; break; } }
	 * con.close();
	 */
	//  Assert.assertTrue(flag,"employee in db is not verified ");
}
	 @Test
	  public void addEmployeeWithoutEmailTest() throws SQLException {
			
			Random random =new Random();
			int ranNum = random.nextInt(5000);
			String projectName="Airtel_"+ranNum;
			
			String username ="user"+ranNum;
			ProjectPojo pobj =new ProjectPojo(projectName, "Created", "Deepak", 0);
		//Api-1==>add a project inside the server
		//try to automate precondion 1 .its a rule of automation
			
		          given()
			.contentType(ContentType.JSON)
			.log().all()
			.body(pobj)
			.when()
			.post("http://49.249.28.218:8091/addProject")

			.then()
			.log().all();

			

			
			
			
			
			//Api-2==> add employee to same Project
			/*
			 * String designation, String dob, String email, String empName, double
			 * experience, String mobileNo, String project, String role, String username
			 */
			EmployeePojo empObj= new EmployeePojo("Arcietect","10/02/1992", "", username, 18.5, "9889310349", projectName, "ROLE_EMPLOYEE",username );
			
			given()
					.contentType(ContentType.JSON)
					.body(empObj)
					.when()
					.post("http://49.249.28.218:8091/employees")
					.then()
					.assertThat().statusCode(500)
					
					
					.log().all();
	
}
}
