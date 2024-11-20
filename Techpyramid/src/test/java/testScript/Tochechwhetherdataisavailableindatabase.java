package testScript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class Tochechwhetherdataisavailableindatabase {
@Test
public void projectCheckTest() throws SQLException {
	String expectedemployeeid="Tc_05";
	boolean flag = false;
		//step1 load/register the database driver
		Driver driverref =new Driver();
		DriverManager.registerDriver(driverref);
		//step 2: connect to  database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger", "root", "root");
		System.out.println("===done====");
		//step3:create sql statement
		Statement stat = conn.createStatement();
		//step:4execute select query and get result
		ResultSet resultset = stat.executeQuery("select*from Employee");
		while(resultset.next()) {
		String	actualEmployeeid=resultset.getString(1);
		if(expectedemployeeid.equals(actualEmployeeid)) {
			flag=true;
			System.out.println(expectedemployeeid+"is available==PASS");
		}
		}
		if(flag==false) {
			System.out.println(expectedemployeeid+"is not available==Fail");
			Assert.fail();

		}

		//step5 :close connection
		conn.close();

}
}
