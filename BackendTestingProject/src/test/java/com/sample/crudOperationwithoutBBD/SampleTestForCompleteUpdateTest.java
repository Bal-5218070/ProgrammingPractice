package com.sample.crudOperationwithoutBBD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForCompleteUpdateTest {
	@Test
	public void putDataFromServer() {
		
		JSONObject jsonObj =new JSONObject();
		
		jsonObj.put("projectName", "Apple_01");

		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);//before sending the request i need to specify the content type
		req.body(jsonObj.toJSONString());

		Response res = req.put("http://49.249.28.218:8091/project/NH_PROJ_4277");
		res.then().log().all();//complete display 
		res.then().assertThat().statusCode(200);
	}
}
