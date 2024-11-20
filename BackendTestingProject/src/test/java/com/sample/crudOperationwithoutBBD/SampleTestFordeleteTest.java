package com.sample.crudOperationwithoutBBD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTestFordeleteTest {
@Test
public void getDataFromServer() {
	Response resp = RestAssured.delete("http://49.249.28.218:8091/project/NH_PROJ_4277");
//	System.out.println(resp.prettyPrint());//entire response is converted into json format
	//System.out.println(resp.asString());//entire response willbe converted into string//
	
	
	resp.then().assertThat().statusCode(204);
	resp.then().log().all();
}
}
