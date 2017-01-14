package pp2.scrum.pluginsTest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pp2.scrum.controller.UserStoryHelper;
import pp2.scrum.model.Estado;
import pp2.scrum.model.UserStory;
import pp2.scrum.plugins.ExportToText;


public class ExportToTextTest extends TestCase {
	UserStory userStory;
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public ExportToTextTest( String testName ) {
	    super( testName );
	}
	
	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
	    return new TestSuite( ExportToTextTest.class );
	}
	
	public void  setUp() { 
		userStory = new UserStory("Titulo1", "Detalle1");
	}
	
	/**
	 * Verifico el texto logueado
	 */
	public void testExportToText() {
		UserStoryHelper userStoryHelper = new UserStoryHelper(this.userStory,null,Estado.getDefault());
		
		ExportToText exporter = new ExportToText();
		
		assertTrue(exporter.toString().equals("Exportar a texto"));
		
		String path="./prueba";
		File f = new File(path+".txt");
		if (f.exists())
		    f.delete();
		List<UserStoryHelper> lst = new ArrayList<>();
		try {
		   exporter.export(path, lst);
		}
		catch(Exception e){
		   assertEquals(e.getMessage(),"No existen historias de usuario para exportar.");
		}
		lst.add(userStoryHelper);
		exporter.export(path, lst);
			
	}
	
}