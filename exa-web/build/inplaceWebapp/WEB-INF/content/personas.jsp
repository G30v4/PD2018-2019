<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Programación Distribuida - Examen primer hemisemestre</title>
	
	<link rel="stylesheet" href="/exa-web/css/bootstrap.min.css">

	<style type="text/css">
		.btn-toolbar .btn{
		    margin-right: 5px;
		}
		.btn-toolbar .btn:last-child{
		    margin-right: 0;
		}
	</style>
</head>
<body>
	<br/>
	
	<div class="container">
		
		<div class="alert alert-secondary" role="alert">
  			<h4>Lista Personas</h4>
		</div>

		<br/>
		<table class="table table-striped table-hover">
			<thead class="thead-dark">
				<tr>
			      	<th scope="col">ID</th>
			      	<th scope="col">Identificación</th>
			    	<th scope="col">Nombre</th>
			    	<th scope="col">Fecha Nac.</th>
			    	<th></th>
				</tr>
			</thead>
			<c:forEach var="p" items="${personas}">
				<s:url var="editurl" action="personaEditar">
				    <s:param name="id">${p.id}</s:param>
				</s:url>
				
				<s:url var="deleteurl" action="personaEliminar">
				    <s:param name="id">${p.id}</s:param>
				</s:url>
				
				<s:url var="dirurl" action="direcciones">
				    <s:param name="id">${p.id}</s:param>
				</s:url>

				<tr>
					<td>${p.id}</td>
					<td>${p.nombre}</td>
					<td>${p.identificacion}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${p.fechaNacimiento}"/></td>
					<td>
						<a href="${editurl}" >EDITAR </a> 
						| 
						<a href="${deleteurl}" >ELIMINAR </a>
						|
						<a href="${dirurl}" >DIRECCIONES </a>
						
					</td>
				</tr>
			</c:forEach>
			
		</table>
		
		<div class="btn-toolbar" role="group" aria-label="Basic example">
			<s:url var="newurl" action="personaNueva.action"/>
			<a class="btn btn-primary btn-sm" href="${newurl}">Nueva persona</a>
			<a class="btn btn-primary btn-sm" href="home.action">Refrescar</a>
		</div>
			
		<br/>
		
		<div class="alert alert-info" role="alert">
			Programación Distribuida 2018-2019
		</div>
	</div>
    
</body>

</html>
