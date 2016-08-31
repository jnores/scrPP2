package pp2.scrum.view;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import mockit.MockUp;
import pp2.scrum.app.AppScrum;
import pp2.scrum.controller.MailGateway;
import pp2.scrum.controller.UserStoryHelper;
import pp2.scrum.controller.UserStoryPaginadoController;
import pp2.scrum.model.Tarea;
import pp2.scrum.model.UserStory;
import pp2.scrum.utils.EnviadorMail;
import pp2.scrum.utils.ObservadorDeHistoria;
import pp2.scrum.utils.UserStoryHelperComparator;

public class UserStoryListViewTest extends TestCase
{
	private UserStoryListView vista;

	public UserStoryListViewTest( String testName ) {
		super( testName );
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite( UserStoryListViewTest.class );
	}

	protected void setUp()
	{
	   List<UserStoryHelper> lista = new ArrayList<>();
	   lista.add(new UserStoryHelper(new UserStory("titulo1", "detalle1")));
	   lista.add(new UserStoryHelper(new UserStory("titulo2", "detalle2")));
		vista = new UserStoryListView(lista);
	}
	
	public void testVista(){
	   vista.ordenarPorOpcion(UserStoryHelperComparator.TITULO_SORT , true);
	   vista.ordenarPorOpcion(UserStoryHelperComparator.TITULO_SORT , false);
	   vista.update(null,null);
	}

}
