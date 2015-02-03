<%@ page import="database.Character"%>
<%@ page import="database.CharacterDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Edit</title>
		<link href="${pageContext.request.contextPath}/css/table.css" rel="stylesheet"></link>
		<script type="text/javascript" src="./js/edit.js"></script>
		<script type="text/javascript" src="http://scriptjava.net/source/scriptjava/scriptjava.js"></script>
	</head>
	<body>
		<% 
		String id = null;
		if ((id = request.getParameter("id")) != null) {
			CharacterDAO dao = new CharacterDAO();
			Character c = dao.getCharacter(Integer.valueOf(id));
			request.setAttribute("c", c);
		}
		%>
		<h1 align="center">Edit</h1>
		<table border=1 id="tbl">
			<tr><td>Name</td> <td>Surname</td> <td>Sex</td> <td>Original air date</td> <td>Job</td> <td>Salary</td> </tr>
			<tr>
				<td style="display: none;" id="id">${c.id }</td>
				<td><input type="text" value="${c.firstName}" id="firstName"></td> 
				<td><input type="text" value="${c.lastName}" id="lastName"></td>
				<td><select id="sex">
						<option value="m" ${c.sex == "m" ? "selected" : "" }>m</option>
						<option value="w" ${c.sex == "w" ? "selected" : "" }>w</option>
					</select></td>
				<td><input type="text" value="${c.date}" id="date"></td>
				<td><input type="text" value="${c.job}" id="job"></td>
				<td><input type="text" value="${c.salary}" id="salary"></td>
			</tr>
		</table>
		<br>
		<c:choose>
			<c:when test="${c.id != null }">
				<input type="button" onclick="save()" value="Save" class="button"/>
			</c:when>
			<c:otherwise>
				<input type="button" onclick="add()" value="Add" class="button"/>
			</c:otherwise>
		</c:choose>	

		<input type="button" onclick="document.location.href = 'table.jsp'" value="Cancel" class="button"/>

	</body>
</html>