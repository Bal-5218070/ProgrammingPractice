package requestChaining;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Scenario_4_CreateOrderwithPaymentNimbble {
public static void main(String[] args) {
	
	//https://nimbbl.biz/docs/api-refrence/introduction/
	//set base uri
	//baseUri="https://api.nimbbl.tech/";
	System.out.println("****************Authorization Post Request*******************");
	// Authorisation post request to generate token
	String accesskey ="access_key_pKs7rWVgVpbXQvQ2";
	String accessSecret ="access_secret_DX3w55VKAkXbx7aB";
	
	String authorizationRequestBody="{\"access_key\":\""+accesskey+"\",\"access_secret\":\""+accessSecret+"\" }";    
	Response authorizationResponseBody= given()
			.body(authorizationRequestBody)
			.contentType(ContentType.JSON)
			.post("/api/v3/generate-token");
	authorizationResponseBody.then()
	.log().all();
	String bearerToken =authorizationResponseBody.jsonPath().getString("token");
			
		
		
		



}
}
