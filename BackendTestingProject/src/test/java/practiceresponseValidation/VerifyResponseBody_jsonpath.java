package practiceresponseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class VerifyResponseBody_jsonpath {
@Test
public void SampleTest() {
	
Response	resp=given()
	.get("http://49.249.28.218:8091/projects-paginated");
	resp.then()
	.log().headers()
    .log().all();
	resp.then().assertThat().body("numberOfElements", Matchers.greaterThan(19));
	
	resp.then().assertThat().body("pageable.sort.unsorted", Matchers.equalTo(true) );
	resp.then().assertThat().body("content[0].projectId", Matchers.equalTo("NH_PROJ_932"));
	
	/*
	 * int data = resp.jsonPath().get("numberofElements");
	 * 
	 * 
	 * 
	 * System.out.println(data); System.out.println("======================");
	 * 
	 * boolean data1=resp.jsonPath().get("pageable.sort.unsorted");
	 * System.out.println(data1); String
	 * data3=resp.jsonPath().get("content[0].projectId"); System.out.println(data3);
	 */
	//iwant to capture all project id
	ArrayList<String> Lst = resp.jsonPath().get("content.projectId");
	System.out.println(Lst);
	
}
}
