package com.hcl.jdbc_student_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertAllData {
	public static void main(String[] args) {
		Connection connection=null;
		Statement statement=null;
		try {
			//step 1 : load the driver or register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step-2 create connection
			String url="jdbc:mysql://localhost:3306/student";
			String username="root";
		     String password="Kumar@123";
		   connection=DriverManager.getConnection(url, username, password);
		    
		   //step-3 create statement
		   statement=connection.createStatement();
		   
		   // step-4 Execute Query
		   String query="insert into student(id,name,address) values(2,'xyz','Delhi')";
		   int x=statement.executeUpdate(query);
		   String msg= x!=0?"query is inserted":"something went wrong ";
		   System.out.println(msg);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//step-5 close the connection
			if(connection!=null && statement!=null)
			{
				try {
					connection.close();
					statement.cancel();
;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			}
			
		
	}
	
		
	}

}
