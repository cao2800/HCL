<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.claudio.model.Employee" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management Page</title>
</head>
<body>
	<div align = "center">
	<table border="1" cellpadding="5">
		<caption><h2> List of All Employees</h2> </caption>
			<tr> 
				<th> Employee ID </th>
				<th> Employee First Name </th>
				<th> Employee Last Name </th>
				<th> Employee Username </th>
				<th> Employee Address </th>
				<th> Employee Contact Number </th>
			</tr>
			<% List<Employee> list = (List<Employee>)request.getAttribute("empList"); 
				for(Employee e: list) { %>
				<td><%=e.getId() %> </td>
				<td><%=e.getFirstName() %> </td>
				<td><%=e.getLastName() %> </td>
				<td><%=e.getUsername() %> </td>
				<td><%=e.getPassword() %> </td>
				<td><%=e.getAddress() %> </td>
				<td><%=e.getContactNo() %> </td>		
				<%
				}
				%>	
		</table>
	</div>
</body>
</html>