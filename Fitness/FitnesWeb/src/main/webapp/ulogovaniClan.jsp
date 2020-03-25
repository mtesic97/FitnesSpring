<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prijavljeni clan</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">
<link rel="stylesheet" href="<%= request.getContextPath() %>css/bootstrap.min.css" type="text/css">
</head>
<body style="text-align: center; margin-top: 200px;">
 	<a href="/clan/sviTreneri">Zakazi trening</a><br>
 	<a href="/clan/pregledTreningaClan">Moji treninzi</a><br>
 	<a href="/clan/sviTreneriKomentar">Ostavi komentar</a><br>
 	<a href="/index.jsp">Odjavi se</a>
</body>
</html>