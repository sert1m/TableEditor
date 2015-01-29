<%@ page import="database.Character"%>
<%@ page import="database.CharacterDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Edit</title>
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
		<table border=1 id="tbl">
			<tr><td>Name</td> <td>Surname</td> <td>Sex</td> <td>Original air date</td> <td>Job</td> <td>Salary</td> </tr>
			<tr>
				<td style="display: none;" id="id">${c.id }</td>
				<td><input type="text" value="${c.firstName}" id="firstName"></td> 
				<td><input type="text" value="${c.lastName}" id="lastName"></td>
				<td><input type="text" value="${c.sex}" id="sex"></td>
				<td><input type="text" value="${c.date}" id="date"></td>
				<td><input type="text" value="${c.job}" id="job"></td>
				<td><input type="text" value="${c.salary}" id="salary"></td>
			</tr>
		</table>
		<% if (id != null) {%>
		<input type="button" onclick="save()" value="Save"/>
		<% } else {%>
		<input type="button" onclick="add()" value="Add"/>
		<% }%>
		<input type="button" onclick="history.back(-1);" value="Cancel"/>

	</body>
</html>