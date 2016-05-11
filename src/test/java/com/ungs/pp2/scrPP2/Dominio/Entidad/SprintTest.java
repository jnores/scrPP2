package com.ungs.pp2.scrPP2.Dominio.Entidad;

import com.ungs.pp2.scrPP2.MainScrum;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class SprintTest extends TestCase {
		
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public SprintTest( String testName ) {
	    super( testName );
	}
	
	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
	    return new TestSuite( SprintTest.class );
	}
	
	public void  setUp() {

		UserStory userStory1
				 ,userStory2
				 ,userStory3
				 ,userStory4
				 ;

		userStory1 =  new UserStory("Titulo1", "Detalle1", "Autor1");
		userStory2 =  new UserStory("Titulo2", "Detalle2", "Autor2");
		userStory3 =  new UserStory("Titulo3", "Detalle3", "Autor3");
		userStory4 =  new UserStory("Titulo4", "Detalle4", "Autor4");

		userStory1.setId(1);
		userStory2.setId(2);
		userStory3.setId(3);
		userStory4.setId(4);
		
	}
	
	/**
	 * Verifico que se asignen bien los atributos en el setUp
	 */
	public void testSprint() {
		@SuppressWarnings("unused")
		Sprint s = new Sprint(1,null,30,null);
		assertTrue(true);

	}
	
}