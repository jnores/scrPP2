package pp2.scrum.view;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pp2.scrum.model.UserStory;

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
	   List<UserStory> lista = new ArrayList<>();
	   lista.add(new UserStory("titulo1", "detalle1"));
	   lista.add(new UserStory("titulo2", "detalle2"));
		vista = new UserStoryListView(lista);
	}
	
	public void testVista(){
	   ;
	   vista.update(null,null);
	}

}


