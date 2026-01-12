package com.hcl.jdbc_student_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayAllData {
	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;

		try {
			// step-1 load/register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// step-2 create connection
			String url = "jdbc:mysql://localhost:3306/student";
			String username = "root";
			String password = "Kumar@123";

			connection = DriverManager.getConnection(url, username, password);

			// step-3 create statement

			statement = connection.createStatement();
			String getAlldata = " SELECT * FROM student ";

			//step-4 Execute Query
			ResultSet rs = statement.executeQuery(getAlldata);
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				System.out.println("name:" + name);
				System.out.println("age:" + email);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			//step-5 close connection
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
