package authtest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class digestiveAuthTest {
	@Test
	public void sampleTest() {
		given()
		.log().all()
		//before hiting this api i  need to pass my basic auth
		.auth().digest("rmgyantra", "rmgy@9999")//backend it is using md5 protocol to encryte the data
		// but it is not visible
		.when()
		.get("http://49.249.29.5:8091/login")
		.then()
		.log().all();
}
}