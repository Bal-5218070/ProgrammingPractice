package com.ninza.hrm.api.generic;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class JsonUtility {
	
	
	/**
	 * get the JsonData from the based on Json complex Xpath
	 * @param resp
	 * @param jsonXpath
	 * @return
	 */
	public String getDataOnJsonPath(Response resp,String jsonXpath)
	{
		List<Object> list = JsonPath.read(resp.asString(), jsonXpath);
		return list.get(0).toString();
	}
	
	/**
	 * get the xmlData from the based on complex path
	 * @param resp
	 * @param xmlXpath
	 * @return
	 */
	public String getDataOnXmlPath(Response resp, String xmlXpath)
	{
		return resp.xmlPath().get(xmlXpath);
	}
	
	public boolean verifyDataOnJsonPath(Response resp,String jsonXpath,String expectedData)
	{
		List<String> list = JsonPath.read(resp.asString(), jsonXpath);
		boolean flag = false;
		for(String str : list)
		{
			if(str.equals(expectedData))
			{
				
				flag = true;
				System.out.println(expectedData + "is available = pass");
			}
		}
		if(flag==false)
		{
			System.out.println(expectedData + "is not available = fail");
		}
		return flag;
	}
	
	/**
	 * @return
	 * @throws IOException 
	 */
	public String getAccessToken() throws IOException
	{
		FileUtility fLib =new FileUtility();
		
		 Response resp = given()
							.formParam("client_id", fLib.getDataFromPropertyFile("ClientId"))
							.formParam("client_secret", fLib.getDataFromPropertyFile("ClientSecret"))
							.formParam("grant_type", "client_credentials")
				
						.when()
							.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
				
		 				resp.then()
		 					.log().all();
		 
		 //Capture the data from the response
		 String token = resp.jsonPath().get("access_token");
		 return token;
	}
	
}