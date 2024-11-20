package typesOfParameter;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class QueryParamTest {
	@Test
	public void sampleTest() {
		given()
		.queryParam("teamSize", 0)
		.when().get("http://49.249.28.218:8091/project")//instead of hardcoding data
		//team size i am going to use queryparam
		//no need to hardcode quey param data at the end of url
		.then().log().headers()
		.log().all();
	}
}

