<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Basic Struts 2 Application - Welcome</title>
</head>
<body>
	<h2>STRUTS: ejemplo suma!</h2>
	
	<s:form action="/sumar.action">
      <s:textfield name="n1" label="First name" />
      <s:textfield name="n2" label="Last name" />
      <s:submit/>
    </s:form>	
    
</body>
</html>
