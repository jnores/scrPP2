package com.ungs.pp2.scrPP2.Dominio.Enums;

import com.ungs.pp2.scrPP2.Dominio.Enums.Estado;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class EstadoTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public EstadoTest( String testName ) {
	    super( testName );
	}
	
	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
	    return new TestSuite( EstadoTest.class );
	}
	
	public void  setUp() {
	}
	
	/**
	 * Verifico que el estado por default sea ToDo
	 */
	public void testEstadoDefault() {
		Estado estadoDefault = Estado.getDefault();
		assertEquals(estadoDefault,Estado.ToDo);
	}
	
	/**
	 * Verifico que al pedir el siguiente se siga la logica de estados
	 */
	public void testEstadoSiguiente() {
		Estado estado = Estado.ToDo;
		assertEquals(estado,Estado.ToDo);
		estado = estado.siguiente();
		assertEquals(estado,Estado.Doing);
		estado = estado.siguiente();
		assertEquals(estado,Estado.Done);
	}
	

	/**
	 * Verifico que al pedir el anterior se siga la logica de estados
	 */
	public void testEstadoAnterior() {
		Estado estado = Estado.Done;
		
		assertEquals(estado,Estado.Done);
		estado = estado.anterior();
		assertEquals(estado,Estado.Doing);
		estado = estado.anterior();
		assertEquals(estado,Estado.ToDo);
	}
	
}