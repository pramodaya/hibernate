package com.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String usr = "hbstudent";
		String pass = "hbstudent";		

		try {
			
			System.out.println("coneection to db: "+jdbcUrl);
			Connection myconn = DriverManager.getConnection(jdbcUrl,usr,pass);
			System.out.println("connection success");
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
