<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<head>
  <title>GluControl</title>
  <meta charset="utf-8">
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
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
  <script src="js/Chart.js"></script>
  <!--[if lt IE 7]>
  	<link rel="stylesheet" href="css/ie/ie6.css" type="text/css" media="all">
  <![endif]-->
  <!--[if lt IE 9]>
  	<script type="text/javascript" src="js/html5.js"></script>
    <script type="text/javascript" src="js/IE9.js"></script>
  <![endif]-->
</head>

<body>
  <!-- header -->
<header>
    <div class="container">
      <h1><a href="index.html">GluControl</a></h1>
      <nav>
        <ul>
          <li><a href="Index.jsp" class="current">Home</a></li>
          <li><a href="Formulario.jsp">Subida</a></li>
          <li><a href="/stats">Estadísticas</a></li>
          <li><a href="Profile.jsp">Perfil</a></li>
        </ul>
      </nav>
    </div>
  </header>
  <!-- /#gallery -->
  <div class="main-box">
    <div class="container">
      <div class="inside">
        <h2>Stadísticas sobre  <span>Controles de glucosa</span></h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        
   
     
	<%
		
		TreeMap<Long, String> stats = (TreeMap<Long, String>)session.getAttribute("stats");
		Iterator it = stats.keySet().iterator();
		String fechas = "";
		String def = "";
		String datos = "";
		while(it.hasNext()){
			Long key = (Long)it.next();
			Date date = new Date(key);
			fechas += date.getDate() + "/" + date.getMonth() + "/"+date.getYear() + ",";
			datos += stats.get(key); 
			System.out.println(stats.get(key));
			System.out.println("datos");
			System.out.println(def);
		}
		String prueba [] = def.split(" ");
		System.out.println(prueba.length);
	//	if(prueba.length > 1){
	//		for(int i = 0; i<prueba.length; i++){
	//				datos += prueba[i];
	//		}
	//	}
		System.out.println(datos);
		
	%>
	<script type="text/javascript">
			google.charts.load('current', {'packages':['line']});
		    google.charts.setOnLoadCallback(drawChart);
		    var f = "<%=fechas%>";
		    var d = "<%=datos%>";
		    var fa  = f.split(",");
		    var da  = d.split(",");
	//		var prueba = new Date(parseInt(fan[0])).getDate();
	//	    alert(prueba);
		   

		  function drawChart() {
		
		    var data = new google.visualization.DataTable();
		    data.addColumn('string', 'Fecha');
		    data.addColumn('number', 'Desayuno');
		    data.addColumn('number', 'Comida');
		    data.addColumn('number', 'Cena');
			for(var i = 0; i<fa.length-1; i++){
				data.addRow([fa[i], parseInt(da[i*3]), parseInt(da[i*3+1]), parseInt(da[i*3+2])]);
			}
		
		    var options = {
		      chart: {
		        title: 'Medidas',
		        subtitle: ''
		      },
		      width: 900,
		      height: 500
		    };
		
		    var chart = new google.charts.Line(document.getElementById('chart'));
		
		    chart.draw(data, options);
		  }
	</script>   
	
	<div id="chart" style="width: 900px; height: 500px"></div>
	<h3>Mostrar medidas de la última semana</h3>
	<input type="button" onclick="location.href='/semana'" value="Mostrar"/>  
	<form action="/genero" method="post" acceptcharset="utf-8" class="form-container">
      <div class="form-title"><h2>Estadísticas por genero</h2></div>
        <select class="form-field" id="genero" name="genero">
                <option value="hombre">Hombre</option>
                <option value="mujer">Mujer</option>
        </select>
      <div class="submit-container">
        <input class="submit-button" type="submit" value="Mostrar" />
      </div>
    </form>  

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

