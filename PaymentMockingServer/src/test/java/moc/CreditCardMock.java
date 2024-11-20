package moc;

import org.apache.commons.lang3.StringUtils;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;
import spark.Spark;

public class CreditCardMock {
	
	
	
	
public static void main(String[] args) {
	Spark.port(8889);//iam going to run this mocking solution via port number
	Spark.post("/credit-card", (req,res)->{//using this systax i am plannig to develope mocking 
		//solution
		//capture the data from response
		//you have to create a response object
		String  response="";
		String  cardNumber=JsonPath.read(req.body().toString(), "$.creditcard");
//	if(cardNumber.equals("1234567891234")) { it work for only one credit card
		//so i am using stringutils class by using this we can multiple credit card
		if(StringUtils.equalsAny(cardNumber,"1234567891234","9876543211234")) {
		response="{\"status\":\"Payment success\"}";
		res.status(200);
	}else {
		response="{\"status\":\"Payment is failed\"}";
		res.status(404);
	}
	//how to specify the json returntype there is a method called returntype
	res.type("application/json");
	return response;
});
	System.out.println("mocking solution is ready for runnig");
}
}