package com.distribuida.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		req.setAttribute( "resp", n1+n2 );
		
		req.getRequestDispatcher( "/suma.jsp" ).forward( req, resp );
	}
}
