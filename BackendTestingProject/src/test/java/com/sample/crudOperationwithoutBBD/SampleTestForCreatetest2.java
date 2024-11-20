package com.sample.crudOperationwithoutBBD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForCreatetest2 {
	@Test
	public void postDataFromServer() {
		
		JSONObject jsonObj =new JSONObject();
		jsonObj.put("createdBy", "Bal");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);
		jsonObj.put("projectName", "Orange_01");

		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);//before sending the request i need to specify the content type
		req.body(jsonObj.toJSONString());

		Response res = req.post("http://49.249.28.218:8091/addProject");
		res.then().log().all();//complete display 
		res.then().assertThat().statusCode(201);
	}
}
