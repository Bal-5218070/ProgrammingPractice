package authtest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class PremtiveAuthTest {
	@Test
	public void sampleTest() {
		
		given()
		.log().all()
		//before hiting this api i  need to pass my basic auth
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.when()
		.get("http://49.249.29.5:8091/login")
		.then()
		.log().all();
}
}