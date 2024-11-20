package webElement;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtils.BaseClass;
import pomRepo.Loginpage;
import pomRepo.Registerpage;
//script hai.testcase
public class ToRegisterAndLoginUserTest extends BaseClass {
	
@Test(priority = 1)
public void toRegisterAnUserTest() throws IOException, InterruptedException {
	String name =fUtils.fetchDataFromExcelSheet("CommonData", 1, 0);
	String email = fUtils.fetchDataFromExcelSheet("CommonData", 1, 1);
	String password = fUtils.fetchDataFromExcelSheet("CommonData", 1, 2);

	Registerpage register= new Registerpage(driver);
	register.registerUser(name, email, password);;
	Thread.sleep(2000);
	Loginpage login =new Loginpage(driver);
	Assert.assertTrue(login.verifyRegisterUser());
	System.out.println("pass: the user has registered");
}
@Test(priority=2 )
public void toLoginUserTest() throws IOException, InterruptedException {
	String email = fUtils.fetchDataFromExcelSheet("CommonData", 1, 1);
	String password = fUtils.fetchDataFromExcelSheet("CommonData", 1, 2);
	
	Loginpage  login =new Loginpage(driver);
	login.loginUser(email,password);
	Thread.sleep(2000);
	Assert.assertTrue(login.verifyLoginUser());
	System.out.println("pass:the user has loggedin");
}
}
     