<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Servicio de control de glucosa</title>

<link href="css/login.css" rel="stylesheet">
<link rel="shortcut icon" href="img/favicon.ico" type="favicon/ico" />

<script
	src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
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
		<form method="post" action="index.html">
			<input type="text" placeholder="Usuario" name="user"
			required="required"><br> <input type="password"
			placeholder="Contraseña" name="password" required="required"><br>

			<a href="login" class="button"> <input type="button" value="login"
			href="login"></a>
		</form>
	</div>
	
	<form method="post" action="index.html">
        <p><input type="text" name="login" value="" placeholder="Username or Email"></p>
        <p><input type="password" name="password" value="" placeholder="Password"></p>
        <p class="remember_me">
          <label>
            <input type="checkbox" name="remember_me" id="remember_me">
            Remember me on this computer
          </label>
        </p>
        <p class="submit"><input type="submit" name="commit" value="Login"></p>
      </form>
	
	
</body>
</html>