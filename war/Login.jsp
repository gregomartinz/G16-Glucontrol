<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Servicio de control de glucosa</title>
		
		<link href="css/login.css" rel="stylesheet">
		<link rel="shortcut icon" href="img/favicon.ico" type="favicon/ico" />
		
		<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src="js/prefixfree.min.js"></script>
</head>
<body>
    <div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div>GluControl</div>
		</div>
		<br>
		<div class="login">
				<input type="text" placeholder="Usuario" name="user" required="required"><br>
				
				<input type="password" placeholder="Contraseña" name="password" required="required"><br>
				
				<a href="login" class="button">
				<input type="button" value="login" href="Index.jsp"></a>
		</div>
</body>
</html>