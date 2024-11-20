package practice;

import org.testng.annotations.Test;

public class OrderTest {
@Test
public void createOrderTest() {
	System.out.println("execute createordertest====>>>>123");
	String str=null;
	System.out.println(str.equals("123"));
}
@Test(dependsOnMethods="createOrderTest")
public void billingAnorderTest() {
	System.out.println("executebillingordertest===>123");
}
}
