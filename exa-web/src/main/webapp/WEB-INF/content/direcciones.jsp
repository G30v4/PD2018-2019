<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
  			<h4>Dirección "${nombre}"</h4>
		</div>

		<br/>
		
		<s:form action="/direccionGuardar.action" theme="simple">
			<s:url var="homeurl" action="home"/>
			<s:url var="borrarurl" action="direccionEliminar">
			    <s:param name="id">${id}</s:param>
			</s:url>
			<s:hidden name="id"/>
				
			<div class="form-group">
				<label for="identificacion">Calle 1:</label>
				<s:textfield name="direccion.calle1" class="form-control"/>
			</div>
			
			<div class="form-group">
				<label for="identificacion">Calle 2:</label>
				<s:textfield name="direccion.calle2" class="form-control"/>
			</div>
			
			<div class="form-group">
				<label for="identificacion">Número:</label>
				<s:textfield name="direccion.numero" class="form-control"/>
			</div>
			
			<div class="btn-toolbar" role="group" aria-label="Basic example">
				<s:submit class="btn btn-primary btn-sm" value="Guardar" theme="simple"/>
				
				<a class="btn btn-primary btn-sm" href="${borrarurl}">Borrar</a>
				<a class="btn btn-primary btn-sm" href="${homeurl}">Cancelar</a>
			</div>
		</s:form>
			
		<br/>
		
		<div class="alert alert-info" role="alert">
			Programación Distribuida 2018-2019
		</div>
	</div>
    
</body>

</html>
