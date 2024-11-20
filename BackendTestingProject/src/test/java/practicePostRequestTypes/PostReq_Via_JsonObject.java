package practicePostRequestTypes;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostReq_Via_JsonObject {
@Test
public void postDataToServer() {

	JSONObject jsonObj =new JSONObject();
	
	jsonObj.put("createdBy", "krishna");
	jsonObj.put("status", "Created");
	jsonObj.put("teamSize",0);
	jsonObj.put("projectName", "Banana_05");

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
