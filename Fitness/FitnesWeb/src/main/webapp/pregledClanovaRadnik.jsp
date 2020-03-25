<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pregled clanova</title>
 <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">
</head>
<body>

<form action="/radnik/pregledSvihClanova" method="POST">
	<table border="1" align="center" width="50%">
		<tr>
			<th>Ime</th>
			<th>Prezime</th>
			<th>Email</th>
		</tr>
		<c:forEach items="${clanovi}" var="c">
			 <tr >
				<td>${c.ime} </td>
				<td>${c.prezime}</td>
				<td>${c.email}</td>
			</tr> 
		</c:forEach>
	</table>
	
</form>
</body>
</html>