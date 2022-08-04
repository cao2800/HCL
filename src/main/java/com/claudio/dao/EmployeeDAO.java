package com.claudio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.claudio.model.Employee;

public class EmployeeDAO {

    public int registerEmployee(Employee employee) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO employee" +
            "  (id, firstName, lastName, username, password, address, contactNo) VALUES " +
            " (?, ?, ?, ?, ?,?,?);";

        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");
      //try with resources-> it will close automatically. You dont have handle finally block
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/julyfsd?useSSL=false", "root", "rootroot1!");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setString(4, employee.getUsername());
            preparedStatement.setString(5, employee.getPassword());
            preparedStatement.setString(6, employee.getAddress());
            preparedStatement.setString(7, employee.getContactNo());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }
    
    public List<Employee> getAllEmployees() throws ClassNotFoundException, SQLException {
    	List<Employee> employees = new ArrayList<>();
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	
    	try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/julyfsd?useSSL=false", "root", "rootroot1!");
    		PreparedStatement pst = con.prepareStatement("SELECT * FROM employee");) {
    		System.out.println(pst);
    		ResultSet rs = pst.executeQuery();
    		
    		while(rs.next()) {
    			int id = rs.getInt("id");
    			String firstName = rs.getString("firstName");
    			String lastName = rs.getString("lastName");
    			String username = rs.getString("username");
    			String password = rs.getString("password");
    			String address = rs.getString("address");
    			String contactNo = rs.getString("contactNo");
    			
    			employees.add(new Employee(id, firstName, lastName, username, password, address, contactNo));
    		}
    	} catch (SQLException e) {
    		printSQLException(e);
    	}
    	
    	return employees;
    }
    
    public boolean updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
    	boolean updatedEmp;
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/julyfsd?useSSL=false", "root", "rootroot1!");
        		PreparedStatement pst = con.prepareStatement("UPDATE employee SET firstName = ?, lastName = ?, username = ?, password = ?, address = ?, contactNo = ? WHERE id=?")) {
    		pst.setInt(1, employee.getId());
    		pst.setString(2, employee.getFirstName());
    		pst.setString(3, employee.getLastName());
    		pst.setString(4, employee.getUsername());
    		pst.setString(5, employee.getPassword());
    		pst.setString(6, employee.getAddress());
    		pst.setString(7, employee.getContactNo());
    		updatedEmp = pst.executeUpdate() > 0;

    	}
    	return updatedEmp;
    }
    
    public boolean deleteEmployee(int id) throws SQLException, ClassNotFoundException {
    	boolean deletedEmp;
    	Class.forName("com.mysql.cj.jdbc.Driver");

    	try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/julyfsd?useSSL=false", "root", "rootroot1!");
        		PreparedStatement pst = con.prepareStatement("DELETE FROM employee WHERE id=?")) {
    		pst.setInt(1, id);
    		deletedEmp = pst.executeUpdate() > 0;
    	}
    
    	return deletedEmp;
    }
    
    public Employee getEmployee(int id) throws SQLException {
    	Employee employee = null;
    	
    	try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/julyfsd?useSSL=false", "root", "rootroot1!");
        		PreparedStatement pst = con.prepareStatement("SELECT firstName, lastName, username, address, contactNo FROM employee WHERE id=?")) {
    		pst.setInt(1, id);
    		System.out.println(pst);
    		
    		ResultSet rs = pst.executeQuery();
    		
    		while(rs.next()) {
    			String firstName = rs.getString("firstName");
    			String lastName = rs.getString("lastName");
    			String username = rs.getString("username");
    			String address = rs.getString("address");
    			String contactNo = rs.getString("contactNo");
    			
    			employee = new Employee(id, firstName, lastName, username, "******", address, contactNo);
    		} 
    	}	catch(SQLException e) {
    		printSQLException(e);
    	}
    	
    	return employee;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}