package panCardMock;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreditPaymentTest {
	// i am trying to develope another test case herepackage panCardMock;
	@Test
	public void sampleTest() {
	//	String body =  "";  /*
					//////	 * "{\r\n" + "\"creditcard :\"1234567891234\",\r\n" + "\"cvv\":\"123\",\r\n" +
					//	 * "\"cardName\":\"Deepak\"\r\n" + "}";
					//	 */
		// here we passing the data in the form of string
		//let me pass this data in the form of json format
		JSONObject obj =new JSONObject();
		obj.put("creditcard", "9876543211234");
		obj.put("cvv", "123");
		obj.put("cardName", "Deepak");
		given()
		.contentType(ContentType.JSON)
		.body(obj)
		.when()
		.post("http://localhost:8889/credit-card")//my mocking solution is written for post request thatswhy i am taking post
		.then().log().all();
		
		
		
}
}