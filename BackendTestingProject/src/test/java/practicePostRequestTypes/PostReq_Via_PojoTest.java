package practicePostRequestTypes;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import pojoClassUtility.ProjectPojo;

public class PostReq_Via_PojoTest {
	@Test
	public void postDataToServer() {
	
		Random random= new Random();
		int ranNumber = random.nextInt(5000);
		
		//create an object to pojo class
		ProjectPojo pObj= new ProjectPojo("AABB"+ranNumber, "Created", "Saurav", 0);
		
		given().contentType(ContentType.JSON).body(pObj)

				.when().post("http://49.249.28.218:8091/addProject")

				.then().assertThat().statusCode(201).log().all();

	}
}
