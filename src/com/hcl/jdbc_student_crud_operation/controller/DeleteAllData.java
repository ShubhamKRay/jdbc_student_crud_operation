package com.hcl.jdbc_student_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteAllData {
	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;

		try {

			// step-1 Load/Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// step-2 create connection
			String url = "jdbc:mysql://localhost:3306/student";
			String username = "root";
			String password = "Kumar@123";

			connection = DriverManager.getConnection(url, username, password);

			// step-3 create statement
			statement = connection.createStatement();

			String deleteStudentById = " delete  FROM student  where id =12";

			// step-4 Execute Query
			int t = statement.executeUpdate(deleteStudentById);
			String temp = t != 0 ? " data deleted" : "given data is not correct";
			System.out.println(temp);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			// step-5 close connection
			if (connection != null && statement != null)
				try {
					connection.close();
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}

	}

}
