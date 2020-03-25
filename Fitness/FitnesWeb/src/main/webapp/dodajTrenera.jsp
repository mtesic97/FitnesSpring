<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dodavanje trenera</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
		<form action="/radnik/dodajTrenera" method="POST">
					 Ime: <p><input type="text" name="ime"/></p> <br>
					 Prezime: <p><input type="text" name="prezime"/></p><br>
					 Email:<p> <input type="text" name="email"/></p><br>
					 Password:<p> <input type="password" name="password"/></p><br>
					 <font color="black"><input type="submit" value="Dodaj trenera"> </font>
		 </form>
		 <c:if test="${!empty t}">
			<font style="color:black">${poruka}</font>
		</c:if><br>
<a href="/ulogovanRadnik.jsp"> Povratak</a>
</body>
</html>