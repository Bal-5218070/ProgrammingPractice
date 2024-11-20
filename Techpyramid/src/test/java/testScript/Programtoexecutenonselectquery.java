package testScript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Programtoexecutenonselectquery {
	public static void main(String[] args) throws SQLException {
		//step1 load/register the database driver
		Driver driverref =new Driver();
		DriverManager.registerDriver(driverref);
		//step 2: connect to  database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger", "root", "root");
		System.out.println("===done====");
		//step3:create sql statement
		Statement stat = conn.createStatement();
		//step4:execute update  always return +- integer
		int result = stat.executeUpdate("insert into Employee values('Tc_04','saurav','garg','techpyramid');");
		System.out.println(result);
		//step5:close the connection
		conn.close();
}
}