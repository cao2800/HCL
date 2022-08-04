package com.claudio.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.claudio.dao.EmployeeDAO;
import com.claudio.model.Employee;

 
 
@WebServlet("/")
public class EmployeeController extends HttpServlet {
  
    private EmployeeDAO employeeDAO;//HAS A

    public void init() {
        employeeDAO = new EmployeeDAO();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	doGet(req, res);
    }
    
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	String action = req.getServletPath();
    	
    	try {
    		switch(action) {
    		case "/registerEmployee":
    			registerEmployees(req, res);
    			break;
    		case "/getAllEmployees":
    			getAllEmployees(req, res);
    			break;
    		case "/updateEmployee":
    			updateEmployee(req, res);
    			break;
    		case "/deleteEmployee":
    			deleteEmployee(req, res);
    			break;
    		default:
    			break;	
    		}
    	} catch (SQLException | ClassNotFoundException e) {
    		throw new ServletException(e);
    	}
    }
  
    protected void registerEmployees(HttpServletRequest req, HttpServletResponse res)
    throws IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String address = req.getParameter("address");
        String contact = req.getParameter("contact");

        Employee employee = new Employee();//model object
  
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setUsername(username);
        employee.setPassword(password);
        employee.setContactNo(contact);
        employee.setAddress(address);

        try {
            employeeDAO.registerEmployee(employee);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        res.sendRedirect("success.jsp");
    }
    
    protected void getAllEmployees(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException, ClassNotFoundException {
    	List<Employee> empList = employeeDAO.getAllEmployees();
    	req.setAttribute("empList", empList);
    	RequestDispatcher dispatcher = req.getRequestDispatcher("/listAllEmployees.jsp");
    	dispatcher.forward(req, res);
    }
    
    protected void updateEmployee(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException, ClassNotFoundException {
    	Employee employee = getEmployee(req, res);
    	employeeDAO.updateEmployee(employee);
    	res.sendRedirect("updateSuccess.jsp");
    }
    
    protected void deleteEmployee(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException, ClassNotFoundException {
    	int id = Integer.parseInt(req.getParameter("id"));
    	employeeDAO.deleteEmployee(id);
    	res.sendRedirect("deleteSuccess.jsp");
    }
    
    protected Employee getEmployee(HttpServletRequest req, HttpServletResponse res) {
    	int id = Integer.parseInt(req.getParameter("id"));
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String address = req.getParameter("address");
        String contactNo = req.getParameter("contactNo");
        
        return new Employee(id, firstName, lastName, username, password, address, contactNo);
    	
    }
}