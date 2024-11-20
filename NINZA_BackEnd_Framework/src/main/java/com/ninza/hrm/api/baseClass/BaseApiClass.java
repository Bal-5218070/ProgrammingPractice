package com.ninza.hrm.api.baseClass;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.ninza.hrm.api.generic.DataBaseUtility;
import com.ninza.hrm.api.generic.FileUtility;
import com.ninza.hrm.api.generic.JavaUtility;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseApiClass {
public	JavaUtility jutl =new JavaUtility();
public 	DataBaseUtility dblib =new DataBaseUtility();
 public    FileUtility futil =new FileUtility();
  public static RequestSpecification specREQUESTObj;
  public static ResponseSpecification specRESonceObj;
 
    @BeforeSuite
	public void  configBS() throws Throwable {
		dblib.getDataBaseConnection  ();
		System.out.println("=======connect to db======");
		RequestSpecBuilder builder=new RequestSpecBuilder();
		builder.setContentType(ContentType.JSON);
		//builder.setAuth(basic("username", "password"));
		//builder.addHeader("","");
		builder.setBaseUri(futil.getDataFromPropertyFile("BASEUri"));
		 specREQUESTObj = builder.build();
		 
		 
		 ResponseSpecBuilder resBuilder =new ResponseSpecBuilder();
		 resBuilder.expectContentType(ContentType.JSON);
		 specRESonceObj = resBuilder.build();
		
		
	}
    @AfterSuite
	public void configAS() {
		dblib.closeconnection();
		System.out.println("======disconnect to db ======");
	}
}
