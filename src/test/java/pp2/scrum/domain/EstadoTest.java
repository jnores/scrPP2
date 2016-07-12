package pp2.scrum.domain;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pp2.scrum.app.AppScrum;
import pp2.scrum.model.Estado;


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
		AppScrum.main(null);
		
		Estado estado = Estado.ToDo;
		assertEquals(estado,Estado.ToDo);
		estado = estado.avanzar();
		assertEquals(estado,Estado.Doing);
		estado = estado.avanzar();
		assertEquals(estado,Estado.Done);
		try {
			estado=estado.avanzar();
		} catch (RuntimeException e) {
			//no se si esta linea que sigue esta bien
	   		assertTrue(e.getMessage().equals("No existe un estado posterior a Done."));
			
		}
	}
}