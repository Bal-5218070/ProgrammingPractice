package testScript;

import org.testng.annotations.Test;

public class REadruntimeparametertest {
@Test
public void runtimeParameterTest() {
	String URL = System.getProperty("url");//if anybody wants to recieve data from commond line .there is java class called
	String BROWSER = System.getProperty("browser");
	String USERNAME = System.getProperty("username");
	String PASSWORD = System.getProperty("password");
		System.out.println("Env Data==>URL"+URL);
		System.out.println("BRowser Data==>"+BROWSER);
		System.out.println("username Data==>"+USERNAME);
		System.out.println("Password Data==>"+PASSWORD);
}
}
