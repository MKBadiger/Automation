package com.SampleProjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class selectDataFrom_DB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
				String dbUrl = "jdbc:mysql://localhost:5050/automation";

				// Database Username
				String username = "root";

				// Database Password
				String password = "maheshkb005";

				// Query to Execute
				String query = "select * from test;";

				// Load mysql jdbc driver
				Class.forName("com.mysql.jdbc.Driver");

				// Create Connection to DB
				Connection con = DriverManager.getConnection(dbUrl, username, password);

				// Create Statement Object
				Statement stmt = con.createStatement();

				// Execute the SQL Query. Store results in ResultSet
				ResultSet rs = stmt.executeQuery(query);

				// While Loop to iterate through all data and print results
				while (rs.next()) {
					String empID = rs.getString(1);
					String empName = rs.getString(2);
					System.out.println(empID + "  " + empName);
				}

				// closing DB Connection
				con.close();
				//return rs;

	}

}
