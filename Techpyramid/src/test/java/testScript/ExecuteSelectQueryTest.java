package testScript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteSelectQueryTest {
public static void main(String[] args) throws SQLException {
	Connection conn=null;
	try {
	//step1 load/register the database driver
	Driver driverref =new Driver();
	DriverManager.registerDriver(driverref);
	//step 2: connect to  database
	 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger", "root", "root");
	System.out.println("===done====");
	//step3:create sql statement
	Statement stat = conn.createStatement();
	//step:4execute select query and get result
	ResultSet resultset = stat.executeQuery("select*from Employee");
	while(resultset.next()) {
		System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4));
	}
	}catch (Exception e) {
		System.out.println("handle exception");
	}finally {
		conn.close();
		System.out.println("close the connection");
	}
	
	//step5 :close connection
	
}
}