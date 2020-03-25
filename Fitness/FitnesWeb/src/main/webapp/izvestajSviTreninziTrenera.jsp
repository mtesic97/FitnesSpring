<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">
<title>Izvestaj</title>
</head>
<body>

<form action="/radnik/izvestajSviTreninziTrenera" method="GET">
	Trener: <br>
	<select name="trener" style="width:150px">
				<c:forEach items="${treneri}" var="t">
						<option value="${t.idtrener}">${t.ime} ${t.prezime}</option>
				</c:forEach>
	</select> <br>
	<input type="submit" value="Izvestaj">
</form>
<a href="/ulogovanRadnik.jsp"> Povratak</a>
</body>
</html>