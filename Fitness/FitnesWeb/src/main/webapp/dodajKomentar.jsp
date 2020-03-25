<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Komentar</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">
</head>
<body>

<form action="/clan/dodajKomentarZaTrenera" method="POST">
	Trener: <br>
	<select name="trener" style="width:150px">
				<c:forEach items="${sviTreneri}" var="t">
						<option value="${t.idtrener}">${t.ime} ${t.prezime}</option>
				</c:forEach>
	</select> <br>
	
	Komentar: <br>
	<textarea rows="4" cols="30" name="tekst"> </textarea><br>
	<br>
	<input type="submit" value="Dodaj komentar" >
	<br> 
</form>
 <c:if test="${!empty k}">
			<center><font style="color:black">${poruka}</font></center>
</c:if>
<a href="/ulogovaniClan.jsp"> Povratak</a>
</body>
</html>