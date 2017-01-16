package pp2.scrum.view;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pp2.scrum.controller.UserStoryHelper;
import pp2.scrum.model.Estado;
import pp2.scrum.model.UserStory;
import pp2.scrum.utils.UserStoryComparator;

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
	   lista.add(new UserStoryHelper(new UserStory("titulo1", "detalle1"),null,Estado.getDefault()));
	   lista.add(new UserStoryHelper(new UserStory("titulo2", "detalle2"),null,Estado.getDefault()));
		vista = new UserStoryListView(lista);
	}
	
	public void testVista(){
	   vista.ordenarPorOpcion(UserStoryComparator.TITULO_SORT , true);
	   vista.ordenarPorOpcion(UserStoryComparator.TITULO_SORT , false);
	   vista.update(null,null);
	}

}
