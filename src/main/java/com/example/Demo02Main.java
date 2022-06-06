package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Demo02Main {
	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	public static final String DB_USER = "root";
	public static final String DB_PASSWORD = "nilesh";
	
	static {
		try {
			Class.forName(DB_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try(Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			try(Statement stmt = con.createStatement()) {
				
				System.out.print("Enter Roll: ");
				int roll = sc.nextInt();
				System.out.print("Enter Name: ");
				String name = sc.next();
				System.out.print("Enter Marks: ");
				double marks = sc.nextDouble();
	
				String sql = "INSERT INTO students VALUES("+roll +",'"+name+"',"+marks+")";
				int count = stmt.executeUpdate(sql);
				System.out.println("Rows inserted: " + count);
			} // stmt.close()
		} // con.close()
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
