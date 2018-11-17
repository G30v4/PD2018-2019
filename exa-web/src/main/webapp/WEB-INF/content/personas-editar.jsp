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
  			<h4>Editar Persona</h4>
		</div>

		<br/>
		
		<s:form action="/personaGuardar.action" theme="simple">
			<s:url var="homeurl" action="home"/>
				
			<div class="form-group">
				<label for="id">ID:</label>
				<s:textfield name="persona.id" class="form-control" disabled="true"/>
				<s:hidden name="persona.id"/>
			</div>
			
			<div class="form-group">
				<label for="identificacion">Identificacion:</label>
				<s:textfield name="persona.identificacion" class="form-control"/>
			</div>
			
			<div class="form-group">
				<label for="nombre">Nombre:</label>
				<s:textfield name="persona.nombre" class="form-control"/>
			</div>
			
			<div class="form-group">
				<label for="fechaNacimiento">Fecha nacimiento:</label>
				<s:date name="persona.fechaNacimiento" format="dd/MM/yyyy" var="ff"/>
				<s:textfield name="persona.fechaNacimiento" value="%{#ff}" class="form-control"/>
			</div>
			
			<div class="btn-toolbar" role="group" aria-label="Basic example">
				<s:submit class="btn btn-primary btn-sm" value="Guadar" theme="simple"/>
				
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
