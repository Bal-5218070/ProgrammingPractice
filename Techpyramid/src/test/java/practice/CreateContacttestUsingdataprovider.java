package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContacttestUsingdataprovider {
@Test(dataProvider="getData")
public void createContactTest(String firstName,String lastName) {
	System.out.println("FirstName :"+firstName +",LastName"+lastName);
}
@DataProvider
public Object [] [] getData(){
	Object [] [] arr=new Object [3] [2];//here 2 is  two parameter how many parameter you want to pass
	arr [0][0]="balkrishna";
	arr [0] [1]="sharma";
	
	
	arr [1] [0]="saurav";//dataprovider alwyas return one row of data
	arr [1] [1]="garg";
	
	
	arr [2] [0]="subham";
	arr [2] [1]="singh";
	return arr;
	
}
}
