package Practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTest {
@Test
public void sampleGetRequestTest() {
	//thsi is supermostclass for entire rest assured
	Response resp=RestAssured.get("https://reqres.in/api/users?page=2");  
	System.out.println(resp.prettyPrint());
}
}
