<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <h2>STRUTS: ejemplo suma!</h2>
        <hr>
        
        <form action="${pageContext.request.contextPath}/home.action" method="GET">
        
        	La suma es: <s:property value="resultado"/>
        	<br/>
        	<br/>
        	<input type="submit" value="Regresar"/>
        </form>
    </body>
</html>
