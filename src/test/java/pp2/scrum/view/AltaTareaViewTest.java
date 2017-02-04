package pp2.scrum.view;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AltaTareaViewTest extends TestCase
{
	private AltaTareaView vista;

	public AltaTareaViewTest( String testName ) {
		super( testName );
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite( AltaTareaViewTest.class );
	}

	protected void setUp()
	{
	   vista = new AltaTareaView();
	}

	public void testVista() 
	{  
	   vista.getTareas();
	}

}
