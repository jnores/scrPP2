package com.ungs.pp2.scrPP2.Dominio;

import java.security.InvalidParameterException;

import junit.framework.TestCase;

public class RequestTest extends TestCase {

	Request request;
		
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public RequestTest( String testName )
	{
	    super( testName );
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		request = new Request();
		
	}

	public final void testRequest() {
		try{ 
			request.contieneParametro(null);
			fail("No se debe obtener un valor cuando el parametro es null");
		} catch (NullPointerException e){
		}
		
	}

	public final void testAgregarParametro() {
		
		// agrego un nuevo parametro
		request.agregarParametro("accion", "exportar");
		try{ 
			request.contieneParametro("accion");
			assertTrue(request.obtenerParametro("accion").equals("exportar"));
		} catch (NullPointerException e){
			fail("No se encontro el aprametro solicitado.");
		}
		// reemplazo un parametro existente
		request.agregarParametro("accion", "agregar");
		try{ 
			request.contieneParametro("accion");
			assertFalse(request.obtenerParametro("accion").equals("exportar"));
			assertTrue(request.obtenerParametro("accion").equals("agregar"));
		} catch (NullPointerException e){
			fail("No se encontro el parametro solicitado.");
		}
		
		// cargo valores nulos
		try{ 
			request.agregarParametro(null, "agregar");
			fail("No se puede agregar un parametro nulll.");
		} catch (NullPointerException e){
			
		}
		
		try{ 
			request.agregarParametro("accion", null);
			fail("No se puede agregar un valor nulll.");
		} catch (NullPointerException e){
			
		}

		
	}

	public final void testContieneParametro() {
		request.agregarParametro("accion", "agregar");
		try{ 
			assertTrue(request.contieneParametro("accion"));
		} catch (NullPointerException e){
			fail("No se encontro el parametro solicitado.");
		}	
		try{ 
			assertFalse(request.contieneParametro("titulo"));
		} catch (NullPointerException e){
			fail("No se encontro el parametro solicitado.");
		}
	}

	public final void testObtenerParametro() {
		request.agregarParametro("accion", "exportar");
		try{ 
			request.contieneParametro("accion");
			assertTrue(request.obtenerParametro("accion").equals("exportar"));
		} catch (NullPointerException e){
			fail("No se encontro el aprametro solicitado.");
		}
		// reemplazo un parametro existente
		request.agregarParametro("accion", "agregar");
		try{ 
			request.contieneParametro("accion");
			assertFalse(request.obtenerParametro("accion").equals("exportar"));
			assertTrue(request.obtenerParametro("accion").equals("agregar"));
		} catch (NullPointerException e){
			fail("No se encontro el parametro solicitado.");
		}
		
		try{ 
			request.obtenerParametro("titulo");
			fail("No se debe retornar un valor cuando el parametro no existe.");
		} catch (InvalidParameterException e){
		}
	
	}

}
