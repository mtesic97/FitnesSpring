<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Zakazivanje treninga</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">
</head>
<body>

<form action="/clan/zakaziTrening" method="POST">
	Odaberite trenera: <br>
	<p><select name="trener" style="width:210px">
				<c:forEach items="${trener}" var="t">
						<option value="${t.idtrener}">${t.ime} ${t.prezime}</option>
				</c:forEach>
	</select></p>
	
	Datum treninga: <br>
	<p><input type="date" name="datumTreninga"></p>
	Vreme treninga:
	<p><input type="text" name="vremeTreninga"></p>
	<p><input type="submit" value="Zakazi trening"></p>
</form>
 <c:if test="${!empty t}">
			<font style="color:black">${poruka}</font>
</c:if>
 <c:if test="${empty t}">
			<font style="color:black">${porukaGreska}</font>
</c:if>
 <c:if test="${empty t}">
			<font style="color:black">${greska}</font>
</c:if><br>
<a href="/ulogovaniClan.jsp"> Povratak</a>
</body>
</html>