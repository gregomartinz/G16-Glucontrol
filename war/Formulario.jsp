<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>

<%
    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
%>   
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Subida de control</title>
  <link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
  <link rel="stylesheet" href="css/style.css" type="text/css" media="all">
</head>
  <body>
  
  
  <header>
    <div class="container">
      <h1><a href="index.html">GluControl</a></h1>
      <nav>
        <ul>
          <li><a href="Index.jsp">Home</a></li>
          <li><a href="Formulario.jsp" class="current">Subida</a></li>
          <li><a href="/stats" >Estadísticas</a></li>
          <li><a href="Profile.jsp">Perfil</a></li>
        </ul>
      </nav>
    </div>
  </header>
  <!-- Si estas autenticado (tienes usuario en la session) puedes acceder al formulario -->
  	
  
    <form action="/upload" method="post" acceptcharset="utf-8" class="form-container">
      <div class="form-title"><h2>Subida de controles</h2></div>
      <div class="form-title">Valor de glucosa</div>
        <input class="form-field" ="text" placeholder="Desayuno" name="glucosaDesayuno" id="glucosa" maxlength="5" autofocus class="campo"required>
        <input class="form-field" ="text" placeholder="Comida" name="glucosaComida" id="glucosa" maxlength="5" autofocus class="campo"required>
       <input class="form-field" ="text" placeholder="Cena" name="glucosaCena" id="glucosa" maxlength="5" autofocus class="campo"required>
      <div class="form-title">Fecha de la medida</div>
        <input class="form-field" type="text" size="20" placeholder="dd" maxlength="2" id="fecha_dia" name="fecha_dia" required>
        <select class="form-field" id="fecha_mes" name="fecha_mes">
                <option value="1">Enero</option>
                <option value="2">Febrero</option>
                <option value="3">Marzo</option>
                <option value="4">Abril</option>
                <option value="5">Mayo</option>
                <option value="6">Junio</option>
                <option value="7">Julio</option>
                <option value="8">Agosto</option>
                <option value="9">Septiembre</option>
                <option value="10">Octubre</option>
                <option value="11">Noviembre</option>
                <option value="12">Diciembre</option></select>
        <input class="form-field" type="text" size="20" placeholder="aaaa" maxlength="4" id="fecha_ano" name="fecha_ano" required>

        <div class="form-title"><for="descripción">Descripción del día:</div>
          <div class="form-title">
            <input class="form-title" type="radio" name="descripcion" value="normal" checked="checked" /> No he sufrido alteraciones en el día.<br/>
          </div>
          <div class="form-title">
            <input class="form-title" type="radio" name="descripcion" value="bajada" /> He sufrido una bajada de azúcar con valor 
              <input class="form-field"type="text" placeholder="medición" name="glucosa" id="glucosa" maxlength="5" autofocus class="campo">
              <input class="form-field" type="time" placeholder="hh:mm"name="hora" id="hora" class="campo" >
          </div>
          <div class="form-title">
            <input class="form-title" type="radio" name="descripcion" value="subida" /> He sufrido una subida de azúcar
              <input class="form-field" type="text" placeholder="medición" name="glucosa" id="glucosa" maxlength="5" autofocus class="campo">
              <input class="form-field" type="time" placeholder="hh:mm"name="hora" id="hora" class="campo">
          </div>
          <div class="submit-container">
            <input class="submit-button" type="submit" value="Submit" />
          </div>
        </form>
        <form action="<%= blobstoreService.createUploadUrl("/file") %>" method="post" enctype="multipart/form-data" class="form-container">
          <p class="form-title">Adjuntar fichero</p>
            <input type="file" name="myFile">
          <div class="submit-container">
            <input class="submit-button" type="submit" value="Submit" />
          </div>
        </form>
  </body>
</html>