package com.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;
import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection con;
public void getDbconnection(String url,String username,String password) throws SQLException {
	//dont hardcode
	try {
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	 con = DriverManager.getConnection(url, username, password);
	}catch (Exception e) {
		
	}
}
//two tpye we cane write 2nd way hardcode
public void getDbconnection() throws SQLException {
	
	try {
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	}catch (Exception e) {
		
	}
}
public void closeconnection() throws SQLException {
	try {
	con.close();
	}catch (Exception e) {
		
	}
}
public ResultSet executeSelectQuery(String query) throws Throwable {
	ResultSet result=null;
	try {
	Statement stat = con.createStatement();
 result=	 stat.executeQuery(query);
	}catch (Exception e) {
		
	}
	return result;//in this case it is going to return entire table
}
public int executeNonSelectQuery(String query) {
	int result=0;
	try {
	Statement stat = con.createStatement();
	 result=	 stat.executeUpdate(query);
	}catch (Exception e) {
	
	}
	return result;
}
}
