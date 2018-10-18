<html>
    <body>
        <h2>Ejemplo Spring 04!</h2>
        <hr>
        
        <form action="${pageContext.request.contextPath}/index.jsp" method="GET">
        
        	La suma es: ${resp}
        	<br/>
        	<br/>
        	<input type="submit" value="Regresar"/>
        </form>
    </body>
</html>
