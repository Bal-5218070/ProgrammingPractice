package Testngpackage;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Homeverification {
@Test
public void SampleTest(Method mtd) {
	
	Reporter.log(mtd.getName()+"test start");
	//Reporter.log(null);
	 SoftAssert assertOBj=new SoftAssert();
	 
	 
	Reporter.log("Step-1",true);
	Reporter.log("Step-2",true);
	Reporter.log("Step-3",true);
	//Assert.assertEquals("Home", "HomePage");
	Assert.assertEquals("Home", "Home");
	Reporter.log("Step-4",true);
	assertOBj.assertEquals("title", "title-1");
	Reporter.log("Step-5",true);
	//dont forget to print the exception at the end of script
	//how to print the exception we have an additional method that is assertall
	assertOBj.assertAll();
	Reporter.log(mtd.getName()+"test end");
}
@Test
public void sampleTest(Method mtd) {
	Reporter.log(mtd.getName()+"teststart");
	SoftAssert assertOBj=new SoftAssert();
	Reporter.log("step-1",true);
	Reporter.log("step-2",true);
	assertOBj.assertTrue(true);
	Reporter.log("step-3",true);
	Reporter.log("step-4",true);
	assertOBj.assertAll();
	Reporter.log(mtd.getName()+"testend");
}
}
