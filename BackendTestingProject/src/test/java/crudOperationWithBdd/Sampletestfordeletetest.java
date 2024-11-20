package crudOperationWithBdd;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class Sampletestfordeletetest {
@Test
public void getDataFromServer() {
	given()
	.delete("http://49.249.28.218:8091/project/NH_PROJ_974")
	.then()
	.assertThat().statusCode(204)
	.log().all();
}
}
