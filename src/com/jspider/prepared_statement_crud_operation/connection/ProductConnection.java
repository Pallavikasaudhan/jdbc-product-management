package com.jspider.prepared_statement_crud_operation.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class ProductConnection {
public static Connection getProductConnection() {
	System.out.println("getProductConnection started");
	try {
	//step-1 Register Driver
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
//	step-2 Create connection 
	return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-m13","root","root");
	
	}catch(SQLException e) {
		e.printStackTrace();
		return null;
	}
//	return null;
}
}
