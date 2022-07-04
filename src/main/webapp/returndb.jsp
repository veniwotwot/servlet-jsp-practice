<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Table Results Page</title>
</head>
<body>
<p>Returning Database Results </p>
<table>
<br>
	<tr>
		<td>First Name</td>
		<td>Last Name</td>
		<td>Username</td>
		<td>Address</td>
		<td>Contact</td>
	</tr>
    <c:forEach items="${e_list}" var="Employee">
        <tr>
        	<td>${Employee.getFirstName()}</td>
            <td>${Employee.getLastName()}</td>
            <td>${Employee.getUsername()}</td>
            <td>${Employee.getAddress()}</td>
            <td>${Employee.getContact()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>