package practiceresponseValidation;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class Verifydata_ComplexJsonxpath {
@Test
public void SampleTest(){
	Response	resp=given()
			.get("http://49.249.28.218:8091/projects-paginated");
			resp.then()
			.log().headers()
		    .log().all();
	List<String>	Lst=JsonPath.read(resp.asString(), ".content[*].projectName");
	for(String data:Lst) {
		System.out.println(data);
	}
	//System.out.println(Lst);
	//based on condition json xpath
	List<String>	Lst1=JsonPath.read(resp.asString(), ".content[*].[?(@.projectName=='ABB_461)].projectId");
	String actualProjectId=Lst1.get(0);
	//if any projectname contains Abb_461 then display the id
	 Assert.assertEquals(actualProjectId, "NH_PROJ_024");
	 // iam extracting the data from response then i want to validate in such cases we go for
	 //testng validation
	  
	 //Db valiadation
	 //request chaining
}
}
