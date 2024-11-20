package requestChaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Scenario_3_getPayRollInfo {
@Test
public void samppleTest() {
	// Api-1 get Auth Api-1
Response	resp=given()
	//precondition i want to pass authentication which is given by developer
	.formParam("client_id", "ninza-client")
	.formParam("client_secret","gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
	.formParam("grant_type", "client_credentials")
	
	
	.when()
	.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
	//authentication protocol url
	resp.then()
	.log().all();
	//capture the token from the response
	
	String token =resp.jsonPath().get("access_token");
	
	
	//Api-2 get payroll info
	given()
	.auth().oauth2(token)
	.get("http://49.249.28.218:8091/admin/payrolls")
	.then()
	.log().status()
	.log().all();
	
	
}
}
