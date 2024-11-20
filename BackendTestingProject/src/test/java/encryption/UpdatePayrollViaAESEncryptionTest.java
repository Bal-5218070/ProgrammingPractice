package encryption;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UpdatePayrollViaAESEncryptionTest {
	@Test
	public void sampletest() throws Throwable {
		String privateKey = "Ac03tEam@j!tu_#1";
		
		
		EnryptAnddecryptUtility ed = new EnryptAnddecryptUtility();

		String jBody = "{ \"employee\": { \"empId\":\"string\", \"designation\": \"string\", \"dob\": \"dd/MM/yyyy\", \"email\": \"string\", \"empName\": \"string\", \"experience\": 0, \"mobileNo\": \"string\", \"project\": \"string\", \"role\": \"string\", \"username\": “string” }, \"basicPlusVda\": 0, \"hra\": 0, \"insurance\": 0, \"lta\": 0, \"lwf\": 0, \"netPay\": 0, \"payroll_id\": 0, \"pf\": 0, \"pt\": 0, \"stat_bonus\": 0, \"status\": “Active/Disabled” }";

		String jsonreqBody = ed.encrypt(jBody, privateKey);
	
		
		System.out.println(jsonreqBody);
	//i  am trying to display this because just because of debug 
		
		Response resp = given().body(jBody).put("http://49.249.28.218:8091/payroll");
		resp.then().log().all();
		
		String	resBody = ed.decrypt(resp.getBody().asString(), privateKey);
		System.out.println(resBody);
	
		//here i am getting 500 status code because he payroll is encrypted)
	}
}
