<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
  <title>GluControl</title>
  <meta charset="utf-8">
  <link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
  <link rel="stylesheet" href="css/style.css" type="text/css" media="all">
  
  <script type="text/javascript" src="js/jquery-1.4.2.min.js" ></script>
  <script type="text/javascript" src="js/Humanst521_BT_400.font.js"></script>
  <script type="text/javascript" src="js/Humanst521_Lt_BT_400.font.js"></script>
  <script type="text/javascript" src="js/roundabout.js"></script>
  <script type="text/javascript" src="js/roundabout_shapes.js"></script>
  <script type="text/javascript" src="js/gallery_init.js"></script>
  <script type="text/javascript" src="js/cufon-replace.js"></script>
</head>

<body>
  <!-- header -->
  <header>
    <div class="container">
    	<h1><a href="Index.jsp">GluControl</a></h1>
      <nav>
        <ul>
          <li><a href="Index.jsp" class="current">Home</a></li>
          <li><a href="Formulario.jsp">Subida</a></li>
          <li><a href="/stats">Estadísticas</a></li>
          <li><a href="Profile.jsp">Perfil</a></li>
          <li><a href="Login.jsp">Logout</a></li>
        </ul>
      </nav>
    </div>
	</header>
  <div class="main-box">
    <div class="container">
      <div class="inside">
        <div class="wrapper">
        	<!-- aside -->
          <aside>
            <h2>Noticias <span>Recientes</span></h2>
            <!-- .news -->
            <ul class="news">
            	<li>
              	<figure><strong>22</strong>Junio</figure>
                <h3><a href="#">Nuevos dispositivos compatibles</a></h3>
                Se han desarrollado unos dispositivos que permiten acceder rápidamente a su nivel del glucosa <a href="#">...</a>
              </li>
              <li>
              	<figure><strong>09</strong>Junio</figure>
                <h3><a href="#">El futuro de la diabetes</a></h3>
                Recientes investigaciones apuntan al IoT para entrar en el mercado de la diabetes<a href="#">...</a>
              </li>
              <li>
              	<figure><strong>30</strong>Mayo</figure>
                <h3><a href="#">Oferta en medidores compatibles</a></h3>
                Aquí podrás encontrar ofertas en medidores compatibles con GluControl<a href="#">...</a>
              </li>
              <li>
              	<figure><strong>21</strong>Mayo</figure>
                <h3><a href="#">Arranca el XXIV congreso internacional de la diabetes</a></h3>
                Tiene lugar en Móstoles y se reúnen las mejores marcas del mercado<a href="#">...</a>
              </li>
            </ul>
            <!-- /.news -->
          </aside>
          <!-- content -->
          <section id="content">
            <article>
            	<h2>Bienvenido a <span>GluCOntrol</span>, <c:out value="${usuario}"/></h2>
              <p>Esta web te permitirá entender tus controles de glucosa y tu estado de salud de una forma que siempre habías imaginado</p>
              <figure><a href="#"><img src="images/banner11.jpg" alt=""></a></figure>
              
              Tienes la opción de subir tus datos de forma manual o sincronizando tu dispositivo de control.
            </article> 
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
  <script type="text/javascript"> Cufon.now(); </script>
</body>
</html>