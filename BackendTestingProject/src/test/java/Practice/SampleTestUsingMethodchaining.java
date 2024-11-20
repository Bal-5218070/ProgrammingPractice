package Practice;

import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;

public class SampleTestUsingMethodchaining {
@Test
public void getRequestTest() {
	/*
	 * Response resp=RestAssured.get("https://reqres.in/api/users?page=2");
	 * System.out.println(resp.prettyPrint());
	 */
	get("https://reqres.in/api/users?page=2")
	.then().log().all();//it will return response header and also body of response
	//it will complete information about respondse
}
}
