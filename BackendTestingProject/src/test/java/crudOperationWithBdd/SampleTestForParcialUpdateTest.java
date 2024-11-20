package crudOperationWithBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class SampleTestForParcialUpdateTest {
	@Test
	public void putDataFromServer() {
		
		JSONObject jsonObj =new JSONObject();
		
		jsonObj.put("createdBy", "krishna122");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize",0);
		jsonObj.put("projectName", "Banana_023");

		given()
		.contentType(ContentType.JSON)
		.body(jsonObj.toJSONString())
		.when()
		.patch("http://49.249.28.218:8091/project/NH_PROJ_974")
		.then()
		.assertThat().statusCode(200)
		.log().all();

	
		
	}
}
