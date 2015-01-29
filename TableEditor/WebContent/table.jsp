<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ page import="database.Character"%>
<%@ page import="database.CharacterDAO"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="./js/table.js"></script>
		<title>The Simpsons Table</title>
	</head>
	<body>
		<%
	    List<Character> characters = new CharacterDAO().getAllCharactes();
		request.setAttribute("characters", characters);
		%>
		<table border = 1>
		<tr><td></td> <td>Name</td> <td>Surname</td> <td>Sex</td> <td>Original air date</td> <td>Job</td> <td>Salary</td> </tr>
			<c:forEach var="c" items="${characters}">
	            <tr>
	                <td><input type='checkbox' name='character' value='${c.id}'/></td>
	                <td>${c.firstName}</td>
	                <td>${c.lastName}</td>
	                <td>${c.sex}</td>
	                <td>${c.date}</td>
	                <td>${c.job}</td>
	                <td>${c.salary}</td>
	            </tr>
            </c:forEach>
		</table>
		<br>
		<a href="${pageContext.request.contextPath}/table.jsp"><input type="button" value="refresh"></a>
		<input type="button" value="edit">
		<input type="button" value="delete" onclick="deleteCharacter()">
	</body>
</html>