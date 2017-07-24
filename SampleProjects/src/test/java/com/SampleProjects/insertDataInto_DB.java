package com.SampleProjects;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class insertDataInto_DB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
				String dbUrl = "jdbc:mysql://localhost:5050/automation";

				// Database Username
				String username = "root";

				// Database Password
				String password = "maheshkb005";

				System.setProperty("webdriver.chrome.driver", "E:\\Softwares\\New_Chrome\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.get("http://google.com");

				// Load mysql jdbc driver
				Class.forName("com.mysql.jdbc.Driver");

				// Create Connection to DB
				Connection con = DriverManager.getConnection(dbUrl, username, password);

				// Create Statement Object
				Statement stmt = con.createStatement();

				// stmt.executeUpdate(sql);
				String s=driver.getTitle();
				String url = "mgmail.com";
				String empId = "006";
				CallableStatement cstmt = con.prepareCall("{call testProcedure1(?,?)}");
				System.out.println("Ist" + empId + "2nd" + url);
				// cstmt.set
				cstmt.setString(1, empId.toString());
				cstmt.setString(2, url.toString());
				ResultSet rs = cstmt.executeQuery();

	}

}
