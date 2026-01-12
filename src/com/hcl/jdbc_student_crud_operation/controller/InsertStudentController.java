/*
package com.hcl.jdbc_student_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStudentController {

	public static void main(String[] args) {
	
		//step-1 Load/Register
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		//Step-2 create connection
		String url = "jdbc:mysql://localhost:3306/jdbc-m16";
		String username = "root";
		String password = "Kumar@123";
		
		Connection connection = DriverManager.getConnection(url,username,password);
		System.out.println(connection);
		
		//step-3   create statement by Statement or 
		
		Statement statement = connection.createStatement();
		
		//step-4  ExecuteQuery
		
		String insertStudentQuery = "insert into student(id,name,email,phone,dob,address) values(2345,'Shubh','shubh@gmail.com', 1234567890,'1947-08-15','Noida')";
		
		int a=statement.executeUpdate(insertStudentQuery);
		
		String msg = a!=0?"data inserted":"something went wrong";
		
		System.out.println(msg);
		
		
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}

*/

/* Method - 2
----------------------------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------------------------
________________________________________________________________________________________________________________________________________________________________
----------------------------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------------------------
________________________________________________________________________________________________________________________________________________________________
----------------------------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------------------------
________________________________________________________________________________________________________________________________________________________________
----------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
package com.hcl.jdbc_student_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStudentController {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;

		try {

			// step-1 load/register driver from mysql -connector
			Class.forName("com.mysql.cj.jdbc.Driver");

			// step-2 create connection
			String url = "jdbc:mysql://localhost:3306/student";
			String userName = "root";
			String passWord = "Kumar@123";

			connection = DriverManager.getConnection(url, userName, passWord);
			System.out.println(connection);

			// step-3 Create the statement
			statement = connection.createStatement();
			String insertQuery = "insert into student(id,name,phone,dob,email,address) values(121,'Tommy',276855587676,'2001-12-18','tom@gmail.com','London')";

			// step-4 execute Query
			int x = statement.executeUpdate(insertQuery);
			System.out.println(x);

			String msg = x != 0 ? "data is inserted" : "something went wrong ";
			System.out.println(msg);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		} finally {

			// step-5 close the connetcion

			try {
				if (connection != null && statement != null) {
					statement.close();
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
