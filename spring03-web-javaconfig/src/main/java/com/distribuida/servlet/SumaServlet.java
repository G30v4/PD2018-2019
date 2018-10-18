package com.distribuida.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.distribuida.servicios.ServicioOperaciones;

@WebServlet(name = "SumarServlet",urlPatterns = {"/sumar"} )
public class SumaServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String _n1 = req.getParameter( "n1" );
		String _n2 = req.getParameter( "n2" );
		
		Integer n1 = Integer.valueOf( _n1 );
		Integer n2 = Integer.valueOf( _n2 );
		
		
		ServletContext sc = req.getServletContext();
		
//		ApplicationContext contex =  (ApplicationContext)sc.getAttribute( "xxx" );
		
		ApplicationContext contex = WebApplicationContextUtils.getWebApplicationContext( sc );
		
		ServicioOperaciones servicio = contex.getBean( ServicioOperaciones.class );
		
		int resultado = servicio.sumar( n1,  n2 );
		
		req.setAttribute( "resp", resultado );
		
		req.getRequestDispatcher( "/suma.jsp" ).forward( req, resp );
	}
}
