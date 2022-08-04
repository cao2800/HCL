<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Delete Form</title>
</head>
<body>
  <h1>Employee Delete Form</h1>
  <form action="<%= request.getContextPath() %>/deleteEmployee" method="post">
   <table style="with: 80%">
    <tr>
     <td>Enter Employee ID To Delete</td>
     <td><input type="text" name="id" /></td>
    </tr>
   </table>
   <input type="submit" value="Delete" />
  </form>
</body>
</html>