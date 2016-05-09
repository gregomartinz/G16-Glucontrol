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
            <article>
            	<h2>Editar <span>Perfil</span></h2>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
              <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudansam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea tium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.</p>
              Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur.
            </article> 
          </section>
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
			  </script>
			  <p>Tus datos:</p>
			  <p>Nombre: <c:out value="${usuario}"/></p>
			  <p>Fecha diagnóstico: <c:out value="${fechaD}"/></p>
			  <input type= "button" onclick= "mostrarNombre()" value ="Editar Nombre"/>
			  <input type= "button" onclick= "mostrarFechaD()" value ="Editar Fecha Diagnostico"/>
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