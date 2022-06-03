package com.Anusuya.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAO {
 public static void main(String[] args) {
	try {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root");
		System.out.println(connection);
		Statement stmt= connection.createStatement();
//		int result = stmt.executeUpdate("insert into account values(1,'Balakrishnan','Anusuya',10000)");
//		System.out.println("Row inserted "+result);
		
//		stmt.executeUpdate("update account set bal=12000 where accno=1");
		stmt.executeUpdate("delete from account where accno=1");
		
		ResultSet rs = stmt.executeQuery("select * from account");
		while(rs.next()){
			System.out.println("Account id: "+rs.getString(1)+" LastName: "+ rs.getString(2) +" FirstName: "+rs.getString(3)+" balance: "+rs.getString(4));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
