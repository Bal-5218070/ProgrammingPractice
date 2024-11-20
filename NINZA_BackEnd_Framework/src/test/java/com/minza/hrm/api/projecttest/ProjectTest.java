package com.minza.hrm.api.projecttest;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;
import com.ninja.hrm.api.pojoclass.ProjectPojo;
import com.ninja.hrm.constants.endpoint.IEndPoint;
import com.ninza.hrm.api.baseClass.BaseApiClass;
import com.ninza.hrm.api.generic.DataBaseUtility;
import com.ninza.hrm.api.generic.FileUtility;
import com.ninza.hrm.api.generic.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class ProjectTest extends BaseApiClass{
	String baseUri;

	
	ProjectPojo pObj;
	
	
	
	
	
	
	
	@Test
	public void addSingleProjectWithCreated() throws SQLException, IOException {
		//create an object via pojo class
	//baseUri	=futil.getDataFromPropertyFile("BASEUri");
		
		
		 String ExpectedsucMsg="Successfully Added"; 
		 String projectName ="AABB"+jutl.getRandomNumber();
		 
		 //create an object to pojo class 
		 
		  pObj= new ProjectPojo(projectName, "Created", "Saurav", 0);
		  
		  
		  //verify the projectName in API layer
		 Response resp = given()
				 .spec(specREQUESTObj)//this spec is always by given as per rule
				 .body(pObj)
		 
		  .when().post(IEndPoint.Add_PROJ);
		  
		  resp.then() .assertThat().statusCode(201)
		  .assertThat().time(Matchers.lessThan(3000L))
		.spec(specRESonceObj)//this is last line
		  
		  .log().all(); 
		  String actmsg =resp.jsonPath().get("msg");
		  
		  Assert.assertEquals(ExpectedsucMsg, actmsg);
		 
         
         ////verify the projectName in Data base layer(it is standard rule to validate project
         //in data base
         //use rdp in windows
         //use ip address 49.249.28
			/*
			 * boolean flag=false; Driver driverRef = new Driver();
			 * DriverManager.registerDriver(driverRef); Connection con
			 * =DriverManager.getConnection(
			 * "jdbc:mysql://49.249.28.218:8091:3333/ninza_hrm", "root@%", "root");
			 * ResultSet result =con.createStatement().executeQuery("select* from project");
			 * while(result.next()) { System.out.println(result.getString(4));
			 * if(result.getString(4).equals(projectName)) { flag=true; break; } }
			 * con.close(); Assert.assertTrue(flag,"project in db is not verified ");
			 */
         
		}
	@Test(dependsOnMethods ="addSingleProjectWithCreated" )
	public void createduplicateProjectTest() {
		
		
		
		given().spec(specREQUESTObj).body(pObj)
		  
		  .when()
		  .post(IEndPoint.Add_PROJ)
		  .then()
		  .assertThat().statusCode(409)
		  .log().all();
		  
	}
	
	}

