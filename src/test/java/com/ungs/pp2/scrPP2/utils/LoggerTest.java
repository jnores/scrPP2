package com.ungs.pp2.scrPP2.utils;

import java.io.ByteArrayOutputStream;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class LoggerTest extends TestCase {
	ByteArrayOutputStream outStream;
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public LoggerTest( String testName ) {
	    super( testName );
	}
	
	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
	    return new TestSuite( LoggerTest.class );
	}
	
	public void  setUp() {
		outStream = new ByteArrayOutputStream(1024);
		Logger.setOutStream(outStream);
		Logger.init();
		Logger.log("mensaje 1");
		Logger.close();
	}
	
	/**
	 * Verifico El orden en que estan cargadas
	 */
	public void testLogger() {
		String textLogged="Logger Iniciado\nmensaje 1\nLogger Finalizado\n";
		assertEquals(outStream.toString(),textLogged);
		
	}
		
	/**
	 * Verifico El orden en que estan cargadas
	 */
	public void testLoggerClosed() { 
		
	}

	
}