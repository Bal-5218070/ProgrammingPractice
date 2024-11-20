package practiceresponseValidation;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;




public class VerifyResponseTime {
@Test
public void verifyHeader() {
	
	
	Response resp = given()
			.get("http://49.249.28.218:8091/projects");
			resp.then().log().status();
			resp.then().log().all();
			long timeTaken = resp.time();
			System.out.println(timeTaken);
			long timeTakensec = resp.timeIn(TimeUnit.SECONDS);
			System.out.println(timeTakensec);
			resp.then().assertThat().time(Matchers.lessThan(900L));
			resp.then().assertThat().time(Matchers.greaterThan(400L));
			resp.then().assertThat().time(Matchers.both(Matchers.lessThan(900L)).and(Matchers.greaterThan(300L)));
}
}
