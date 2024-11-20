package requestChaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClassUtility.ProjectPojo;

public class Scenario_1_Delete_Project {
@Test
public void postDataToServer() {

	
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
	.log().all();
	//capture the data(projectName) from the response and pass thAT DATA INTO ANOTHER REQUEST
	String projectId = resp.jsonPath().get("projectId");
	System.out.println(projectId);
	
	//aApi-2==> add employee to same project
	//with in the same test case again i m trying to execute another request
	given()
	.delete("http://49.249.28.218:8091/project/"+projectId)
	
	.then()
	.log().all();
	
}
}
