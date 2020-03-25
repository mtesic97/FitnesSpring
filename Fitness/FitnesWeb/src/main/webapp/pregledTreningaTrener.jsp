<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pregled treninga</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">

</head>
<body>

<form action="/trener/pregledTreningaTrener" method="GET">
	<table border="1" align="center" width="60%">
		<tr>
			<th>Datum treninga</th>
			<th>Vreme Treninga</th>
			<th>Clan</th>
		</tr>
		<c:forEach items="${treninzi}" var="t">
			 <tr >
				<td>${t.datumTreninga} </td>
				<td>${t.vremeTreninga}</td>
				<td>${t.clan.ime} ${t.clan.prezime }</td>
			</tr> 
		</c:forEach>
	</table>
</form>
</body>
</html>