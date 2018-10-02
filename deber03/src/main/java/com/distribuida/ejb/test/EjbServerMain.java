package com.distribuida.ejb.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

public class EjbServerMain {

	public static Map<String, Object> toMap(Context ctx ) throws NamingException {
	    
		String namespace = ctx instanceof InitialContext ? ctx.getNameInNamespace() : "";
	    
		HashMap<String, Object> map = new HashMap<String, Object>();
	    
	    NamingEnumeration<NameClassPair> list = ctx.list(namespace);
	    
	    while (list.hasMoreElements()) {
	        NameClassPair next = list.next();
	        String name = next.getName();
	        String jndiPath = namespace + name;
	        Object lookup;
	        try {
	            
	            Object tmp = ctx.lookup(jndiPath);
	            if (tmp instanceof Context) {
	                lookup = toMap( (Context) tmp );
	            } else {
	                lookup = tmp.toString();
	            }
	        } catch (Throwable t) {
	            lookup = t.getMessage();
	        }
	        
	        map.put(name, lookup);

	    }
	    
	    return map;
	}

	
	public static void main(String[] args) throws Exception {
		
		Map<String, Object> props = new HashMap<String, Object>();

		props.put("openejb.embedded.remotable", "true" );

		// change some logging
		//props.put("log4j.category.OpenEJB.options", "debug");
		//props.put("log4j.category.OpenEJB.startup", "debug");
		//props.put("log4j.category.OpenEJB.startup.config", "debug");
		
		EJBContainer container = EJBContainer.createEJBContainer( props );
		
		Properties p = new Properties();
		p.put( InitialContext.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory" );

		InitialContext ctx = new InitialContext(p);
		
		Map<String, Object> names = toMap( ctx );
		
		System.out.println();
		System.out.println( "-------------------------------------------------" );
		System.out.println( "Objectos registrados:" );
		System.out.println( "-------------------------------------------------" );
		System.out.println();
		
		names.keySet().forEach( s->{
			Object value = names.get( s );
			
			System.out.println( s + "-->" + value );
		});
		
		System.out.println();
		System.out.println( "Servidor Ejb iniciado..." );

		System.in.read();
		
		container.close();

	}

}
