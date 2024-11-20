package authtest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class BearerTokenTest {
	@Test
		public void sampleTest() {
			
			given()
		.auth().oauth2("eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJsZUN3YUNPai00RXVlbzJkTFFrTmZuLXh2M0F3Nm5ZdWZtS0pINXBFWkNNIn0.eyJleHAiOjE3Mjk3NzMwODEsImlhdCI6MTcyOTc3MTI4MSwianRpIjoiOTM1YTVjYjMtODZkOC00YjA1LWI5ODktOGVhZTRlM2M2OGUwIiwiaXNzIjoiaHR0cDovLzQ5LjI0OS4yOC4yMTg6ODE4MC9hdXRoL3JlYWxtcy9uaW56YSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiI0ODVlYTJhYi1kY2MzLTQwOGItOTUxZi04NGMwM2JmZDAwMmYiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJuaW56YS1jbGllbnQiLCJzZXNzaW9uX3N0YXRlIjoiODk1NDVjZDUtYzk4OS00MTk4LTkwNzItNjUxNjYwMDQxNWQ2IiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwOi8vNDkuMjQ5LjI4LjIxODo4MDkxIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJkZWZhdWx0LXJvbGVzLW5pbnphIiwib2ZmbGluZV9hY2Nlc3MiLCJhZG1pbiIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJlbWFpbCBwcm9maWxlIiwic2lkIjoiODk1NDVjZDUtYzk4OS00MTk4LTkwNzItNjUxNjYwMDQxNWQ2IiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJybWd5YW50cmEifQ.bs2V898OrGRgkr5QGgUQLevzYqx-xNhNp6LR_fwhCcgHIOKDR22m0o7wp8U8WitUtzWuXzipQY8M8BiOpnegsL3QWU2ZVa967tuoyPYf484xmnzCpcG1z5PGuY2DJltve3Ku2hTMZ5EX-9wCtwuND0eRSsp92yxee1vwNADT8zSTpcEjxsbj2g5N-ixBy5mbDaZWlBfo2WOQ-6yjdRI-KGXla0adA_V73j5M3sVhEp3CYxypK7L20WzuQxa75o4ZjJxg09noyKN6ganjWZNSIWNHK9nJmCJUIoHz26ksDqd-2M381tRgO4cWkdLZeEtxUt2-s-xOdpKnRCaLFfeWAQ")
			.log().all()
			.when()
			.get("http://49.249.28.218:8091/projects")//hrm application provides bearer tokens
			.then()
			.log().all();
	}
}
//after logging to ninza hrm app we have option called setting
//here we have option  we create bearer token and we can select the life span
//oauth2 is a method
//using this bearer token i can execute this request n no of times .so somebody got to know  about token .he can doany thing/
//using this token we can execute multiple api