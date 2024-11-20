package crudOperationWithBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class SampleTestForCreateTest {
	@Test
	public void postDataFromServer() {
		
		JSONObject jsonObj =new JSONObject();
		
		jsonObj.put("createdBy", "krishna");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize",0);
		jsonObj.put("projectName", "Banana_02");

	given()
		.contentType(ContentType.JSON)
		.body(jsonObj.toJSONString())
		.when()
		.post("http://49.249.28.218:8091/addProject")
.then()
		.assertThat().statusCode(201)
		.log().all();

	
		
	}
}
