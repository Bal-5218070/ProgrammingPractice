 package typesOfParameter;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class ParamParameterTest {
@Test
public void sampleTest() {
	given()
	.param("teamSize", 0)
	.log().all()
	.when()
	//.post("http://49.249.28.218:8091/project")//along with post it behaives like form parameter
	.get("http://49.249.28.218:8091/project")//along with get it behaive like queryparameter
	.then()
	.log().all();
}
}
