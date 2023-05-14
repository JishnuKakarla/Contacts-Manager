package com.techlab.contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Contact {
	public void display() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/swabhav", "root", "");

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select * from contact");

			while (rs.next()) {
				System.out.println(rs.getString("fname") + " " + rs.getString("lname") + " " + rs.getInt("number") + " "
						+ rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

	public void add() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/swabhav", "root", "");
			System.out.println("connection successfull");
			Statement stmt = conn.createStatement();
			String fname = null;
			String lname = null;
			int number = 0;
			String email = null;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the fname : ");
			fname = sc.next();
			System.out.println("Enter the lname : ");
			lname = sc.next();
			System.out.println("Enter the number : ");
			number = sc.nextInt();
			System.out.println("Enter the email : ");
			email = sc.next();
			String sql = "INSERT INTO contact(fname,lname,number,email) " + "VALUES('" + fname + "','" + lname + "',"
					+ number + ",'" + email + "');";
			stmt.execute(sql);
		} catch (Exception e) {
			System.out.println("Failed to Insert");
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

	public void delete() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/swabhav", "root", "");

			Statement stmt = conn.createStatement();

			Scanner sc = new Scanner(System.in);

			System.out.println("Enter the fname to delete : ");
			String fname = sc.next();

			stmt.execute("Delete from contact where fname='" + fname + "'");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}
}
