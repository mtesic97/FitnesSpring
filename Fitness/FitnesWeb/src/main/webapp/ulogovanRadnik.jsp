<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prijavljeni radnik</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body style="text-align: center;margin-top: 200px;">
	<a href="/dodajTrenera.jsp">Dodavanje trenera</a> <br>
	<a href="/radnik/pregledSvihClanova">Pregled svih clanova</a><br>
	<a href="/radnik/pregledSvihTreningaRadnik">Pregled svih treninga</a><br>
	<a href="/radnik/izvestajSviClanovi">Izvestaj svih clanova</a><br>
	<a href="/radnik/sviTreneri">Izvestaj svih treninga za trenera</a><br>
	<a href="/index.jsp">Odjavi se</a>
</body>
</html>