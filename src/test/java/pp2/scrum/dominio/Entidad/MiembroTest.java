package pp2.scrum.dominio.Entidad;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pp2.scrum.dominio.entidad.Miembro;


public class MiembroTest extends TestCase {
	
	Miembro miembro;
	
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public MiembroTest( String testName ) {
	    super( testName );
	}
	
	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
	    return new TestSuite( MiembroTest.class );
	}
	
	public void  setUp() {
		miembro = new Miembro("Victoria","Desarrollador");
	}
	
	/**
	 * Verifico que se asignen bien los atributos con el constructor completo
	 */
	public void testMiembro() {
		Miembro miembro = new Miembro("Victoria","Desarrolladora");
		assertTrue(miembro.getNombre().equals("Victoria"));
		assertTrue(miembro.getPerfil().equals("Desarrolladora"));
	}
	
	/**
	 * Verifico que se asignen los atributos con el constructor simple
	 */
	public void testMiembroConstructor() {
		Miembro miembro = new Miembro("Victoria");
		assertTrue(miembro.getNombre().equals("Victoria"));
		assertTrue(miembro.getPerfil().equals(""));
	}
	
	/**
	 * Verifico El funionamiento de los setters
	 */
	public void testMiembrosetters() {
		assertTrue(miembro.getNombre().equals("Victoria"));
		assertEquals(miembro.getPerfil(),"Desarrollador");
		miembro.setNombre("Ivo");
		assertFalse(miembro.getNombre().equals("Victoria"));
		assertTrue(miembro.getNombre().equals("Ivo"));
		miembro.setPerfil("Diseñador");
		assertFalse(miembro.getPerfil().equals("Desarrollador"));
		assertTrue(miembro.getPerfil().equals("Diseñador"));
	}
	
	
}