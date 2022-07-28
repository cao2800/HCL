package com.hcl.assignment6;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeManagementSystem {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/julyfsd", "root", "rootroot1!");
		
		Scanner scnr = new Scanner(System.in);
		
		//i)  Get the list of employees
		PreparedStatement pst1 = con.prepareStatement("select * from emp");
		ResultSet rs = pst1.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " + rs.getInt("age"));
			
		}
		System.out.println();
		
		//ii) Update the existing employee based in his/her id
		PreparedStatement pst2 = con.prepareStatement("update emp set name=?, age=? where id=?");
		
		System.out.println("Enter an Employee ID you would like to update: ");
		int id = scnr.nextInt();
		
		System.out.println("Enter an updated name(MAX 100 characters): ");
		String name = scnr.next();
		
		System.out.println("Enter an updated age: ");
		int age = scnr.nextInt();
		
		pst2.setString(1, name);
		pst2.setInt(2, age);
		pst2.setInt(3, id);
		
		int x = pst2.executeUpdate();
		System.out.println(x + " record(s) updated");
		System.out.println();
		
		//iii) Delete an employee based on the employee id
		PreparedStatement pst3 = con.prepareStatement("delete from emp where id=?");
		
		System.out.println("Enter an Employee ID you would like to delete: ");
		int empId = scnr.nextInt();
		
		pst3.setInt(1, empId);
		int y = pst3.executeUpdate();
		System.out.println(x + " record(s) deleted");
		System.out.println();
		
		//iv) Get the employee by id
		CallableStatement cst = con.prepareCall("{call getEmp(?)}");
		
		System.out.println("Enter an Employee ID that you would like to get: ");
		empId = scnr.nextInt();
		
		cst.setInt(1, empId);
		ResultSet rs1 = cst.executeQuery();
		while(rs1.next()) {
			System.out.println(rs1.getInt(1) + " " + rs1.getString("name") + " " + rs1.getInt("age"));
			
		}
	}
}
