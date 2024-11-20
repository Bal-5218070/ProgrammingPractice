package requestChaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClassUtility.EmployeePojo;
import pojoClassUtility.ProjectPojo;

public class Scenario_2_AddEmployeeToProject {
@Test
public void sample() {
	Random random =new Random();
	int ranNum = random.nextInt(5000);
	ProjectPojo pobj =new ProjectPojo("Airtel_"+ranNum, "Created", "Deepak", 0);
//Api-1==>add a project inside the server
//try to automate precondion 1 .its a rule of automation
	//first create project and the delete
Response	resp=given()
	.contentType(ContentType.JSON)
	.body(pobj)
	.when()
	.post("http://49.249.28.218:8091/addProject");//after excution of any http method is going to return 
//object of response. let me put a break here to end the method chaining by;

	resp.then()
	.assertThat().statusCode(201)
	.and()
	.assertThat().body("msg", Matchers.equalTo("Successfully Added"))
	.log().all();
	//capture the data(projectName) from the response and pass thAT DATA INTO ANOTHER REQUEST
	String projectName = resp.jsonPath().get("projectName");
	System.out.println(projectName);
	
	//Api-2==> add employee to same Project
	/*
	 * String designation, String dob, String email, String empName, double
	 * experience, String mobileNo, String project, String role, String username
	 */
	EmployeePojo empObj= new EmployeePojo("Arcietect","10/02/1992", "deepak123@gmail.com", "user"+ranNum, 18.5, "9889310349", projectName, "ROLE_EMPLOYEE","user"+ranNum );
	
	given()
			.contentType(ContentType.JSON)
			.body(empObj)
			.when()
			.post("http://49.249.28.218:8091/employees")
			.then()
			.assertThat().statusCode(201)
			.log().all();
	
}
}
