package authtest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class BasicAuthTest {
@Test
public void sampleTest() {
	given()
	.log().all()
	//before hiting this api i  need to pass my basic auth
	.auth().basic("rmgyantra", "rmgy@9999")
	.when()
	.get("http://49.249.29.5:8091/login")//ninzapay application
	.then()
	.log().all();
}
}
