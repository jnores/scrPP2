package pp2.scrum.view;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import mockit.MockUp;
import pp2.scrum.app.AppScrum;
import pp2.scrum.controller.MailGateway;
import pp2.scrum.controller.UserStoryPaginadoController;
import pp2.scrum.model.Tarea;
import pp2.scrum.model.UserStory;
import pp2.scrum.utils.EnviadorMail;
import pp2.scrum.utils.ObservadorDeHistoria;

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
