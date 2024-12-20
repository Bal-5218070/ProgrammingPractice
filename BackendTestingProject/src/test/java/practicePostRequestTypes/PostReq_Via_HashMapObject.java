package practicePostRequestTypes;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostReq_Via_HashMapObject
{
@Test
public void postDataToServer() {

	HashMap<String, Object> map =new HashMap();//for hashmap, there is no need to add dependencies
	
	map.put("createdBy", "krishna");
	map.put("status", "Created");
	map.put("teamSize",0);
	map.put("projectName", "Basdfgh_05");

	given()
	.contentType(ContentType.JSON)
	.body(map)
	.when()
	.post("http://49.249.28.218:8091/addProject")
	.then()
	.assertThat().statusCode(201)
	.log().all();
}
}
