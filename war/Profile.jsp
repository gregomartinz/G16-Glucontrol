<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>GluControl</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
  <link rel="stylesheet" href="css/style.css" type="text/css" media="all">

<link rel="shortcut icon" href="img/favicon.ico" type="favicon/ico" />
  
  <script type="text/javascript" src="js/jquery-1.4.2.min.js" ></script>
  <script type="text/javascript" src="js/Humanst521_BT_400.font.js"></script>
  <script type="text/javascript" src="js/Humanst521_Lt_BT_400.font.js"></script>
  <script type="text/javascript" src="js/cufon-replace.js"></script>
	<script type="text/javascript" src="js/roundabout.js"></script>
  <script type="text/javascript" src="js/roundabout_shapes.js"></script>
  <script type="text/javascript" src="js/gallery_init.js"></script>
  <script type="text/javascript" src="js/loopedslider.min.js"></script>
  
</head>

<body>
  <!-- header -->
  <header>
    <div class="container">
      <h1><a href="Index.jsp">GluControl</a></h1>
      <nav>
        <ul>
          <li><a href="Index.jsp">Home</a></li>
          <li><a href="Formulario.jsp">Subida</a></li>
          <li><a href="/stats">Estadísticas</a></li>
          <li><a href="Profile.jsp" class="current">Perfil</a></li>
        </ul>
      </nav>
    </div>
  </header>
  <div class="main-box">
    <div class="container">
      <div class="inside">
        <div class="wrapper">
          <!-- content -->
          <section id="content">
	          <script type="text/javascript">
			 	function mostrarNombre(){
			 		document.getElementById("formulario").style.visibility="visible";
			 	 	document.getElementById("formularioNombre").style.visibility="visible";
			 	}
			 	function mostrarFechaD(){
			 		document.getElementById("formulario").style.visibility="visible";
			 	 	document.getElementById("formularioFechaD").style.visibility="visible";
			 	}
			 	function mostrarTratamiento(){
			 		document.getElementById("tratamiento").style.visibilitity="visible";
			 		document.getElementById("tratamiento").style.visibility="visible";
			 	}
			  </script>
			  <p>Tus datos:</p>
			  <p>Nombre: <c:out value="${usuario}"/></p>
			  <p>Fecha diagnóstico: <c:out value="${fechaD}"/></p>
			  <p>Tratamiento actual: <c:out value="${tratamiento}"/></p>
			  <input type= "button" onclick= "mostrarNombre()" value ="Editar Nombre"/>
			  <input type= "button" onclick= "mostrarFechaD()" value ="Editar Fecha Diagnostico"/>
			  <input type= "button" onclick= "mostrarTratamiento()" value ="Editar Tratamiento"/>
			  <div id="formulario" style= "visibility:hidden">
			    <form action="/profile" method="post" acceptcharset="utf-8" class="form-container">
				  	<div id="formularioNombre" style="visibility:hidden">
					  	<div class="form-title">
				        	<input class="form-field" ="text" placeholder="Nombre" name="nombre" id="nombre" maxlength="10" autofocus >
					    </div>
				  	</div>
				  	<div id="formularioFechaD" style="visibility:hidden">
					  	<div class="form-title">
				        	<input class="form-field" ="text" placeholder="dd/mm/aaaa" name="fechaD" id="fechaD" maxlength="10" autofocus >
					    </div>
				  	</div>
				  	<div id="tratamiento" style="visibility:hidden">
					  	<div class="form-title">
				        	<input class="form-field" ="text" placeholder="Tratamiento" name="tratamiento" id="tratamiento" maxlength="10" autofocus >
					    </div>
				  	</div>
				    <input type="submit"/>       	
			  	</form>
			  </div>
			</section>
        </div>
      </div>
    </div>
  </div>
  <!-- footer -->
  <footer>
    <div class="container">
      <div class="wrapper">
        <div class="fleft">Copyright - GluControl</div>
      </div>
    </div>
  </footer>
</body>
</html>