package pp2.scrum.dominio.Enums;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pp2.scrum.MainScrum;
import pp2.scrum.dominio.enums.Estado;


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
		MainScrum.main(null);
		
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