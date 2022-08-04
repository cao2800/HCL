<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.claudio.model.Employee" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
				<th> Employee Password</th>
				<th> Employee Address </th>
				<th> Employee Contact Number </th>
			</tr>
			<c:forEach items="${empList}" var="employee">
				<td><c:out value="${employee.id}" /></td>
				<td><c:out value="${employee.firstName}" /></td>
				<td><c:out value="${employee.lastName}" /></td>
				<td><c:out value="${employee.username}" /></td>
				<td><c:out value="${employee.password}" /></td>
				<td><c:out value="${employee.address}" /></td>
				<td><c:out value="${employee.contactNo}"/></td>																	
			</c:forEach>
		</table>
	</div>
</body>
</html>