<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import="java.util.ArrayList"%>
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
  <script type="text/javascript" src="js/cufon-yui.js"></script>
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
          <li><a href="index.html" class="current">Home</a></li>
          <li><a href="upload.html">Subida</a></li>
          <li><a href="stats.html">Estadísticas</a></li>
          <li><a href="profile.html">Pefil</a></li>
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
		
		ArrayList<String> f = (ArrayList<String>)session.getAttribute("statsFecha");
		ArrayList<String> m = (ArrayList<String>)session.getAttribute("statsMedidas");
		ArrayList<String> h = (ArrayList<String>)session.getAttribute("statsHoras");
		String fs = "";
		String hs = "";
		String ms = "";
		for(String s: f){
			fs += s + ","; 
		}
		for(String s: h){
			hs += s + ","; 
		}
		for(String s: m){
			ms += s + ","; 
		}
		System.out.println(fs);
		System.out.println(hs);
		System.out.println(ms);

	%>
	<script type="text/javascript">
			google.charts.load('current', {'packages':['line']});
		    google.charts.setOnLoadCallback(drawChart);
		    var jsf = "<%=f%>";
		    var jsm = "<%=m%>";
		    var jsh = "<%=h%>";
		    jsf = jsf.substring(1);
		    jsh = jsh.substring(1);
		    jsm = jsm.substring(1);
		    var f = [] = jsf.split(",");
		    var m = [] = jsm.split(",");
		    var h = [] = jsh.split(",");
		   
		  function drawChart() {
		
		    var data = new google.visualization.DataTable();
		    data.addColumn('number', 'Fecha');
		    data.addColumn('number', 'Desayuno');
		    data.addColumn('number', 'Comida');
		    data.addColumn('number', 'Cena');
		
		    data.addRows([
		      [1,  parseInt(m[0]), parseInt(m[1]), parseInt(m[2])],
		      [2,  parseInt(m[3]), parseInt(m[4]), parseInt(m[5])],
		      [3,  parseInt(m[6]), parseInt(m[7]), parseInt(m[8])],
		      [4,  parseInt(m[9]), parseInt(m[10]), parseInt(m[11])]
		    ]);
		
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




