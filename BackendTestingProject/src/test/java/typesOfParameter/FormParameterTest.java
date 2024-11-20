 package typesOfParameter;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class FormParameterTest {
@Test
public void sampleTest() {
	given()
	.formParam("teamSize", 0)//form parameter is used along with pos request
	.log().all()
	.when()
	.post("http://49.249.28.218:8091/project")
	.then()
	.log().all();
}
}
