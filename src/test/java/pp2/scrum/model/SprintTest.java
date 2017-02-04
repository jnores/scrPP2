package pp2.scrum.model;

import java.util.Date;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class SprintTest extends TestCase {
	
	UserStory userStory1
			 ,userStory2
			 ,userStory3
			 ,userStory4
			 ;
		
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


		userStory1 =  new UserStory("Titulo1", "Detalle1");
		userStory2 =  new UserStory("Titulo2", "Detalle2");
		userStory3 =  new UserStory("Titulo3", "Detalle3");
		userStory4 =  new UserStory("Titulo4", "Detalle4");

		
	}
	
	/**
	 * Verifico que se asignen bien los atributos en el setUp
	 */
	public void testSprint() {
		Sprint s = new Sprint(1,new Date(),30,new Backlog());
		assertEquals(s.getDuracion(), 30);

	}
	
}
