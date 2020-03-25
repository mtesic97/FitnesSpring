<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registracija</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">

</head>
<body >
	<form action="/clan/registracija" method="POST">
			
					 Ime: <p><input type="text" name="ime"/></p> <br>
					 Prezime: <p><input type="text" name="prezime"/></p><br>
					 Email:<p> <input type="text" name="email"/></p><br>
					 Password:<p> <input type="password" name="password"/></p><br>
					 <font color="black"><input type="submit" value="Registracija"> </font>
		 </form>
<a href="/index.jsp"> Povratak</a>
</body>
</html>