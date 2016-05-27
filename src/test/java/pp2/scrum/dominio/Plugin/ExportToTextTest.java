package pp2.scrum.dominio.Plugin;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pp2.scrum.controller.UserStoryHelper;
import pp2.scrum.dominio.entidad.UserStory;
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
		userStory = new UserStory("Titulo1", "Detalle1", "Autor1");
	}
	
	/**
	 * Verifico el texto logueado
	 */
	public void testExportToText() {
		UserStoryHelper userStoryHelper = new UserStoryHelper(this.userStory);
		
		ExportToText exporter = new ExportToText();
		String path="./prueba.xls";
		List<UserStoryHelper> lst = new ArrayList<>();
		lst.add(userStoryHelper);
		exporter.export(path, lst);
		
//		AltaUserStoryView altv = new AltaUserStoryView(null);
//		FilterStoriesView v = new FilterStoriesView(null); 
//		ProyectoNuevoView nuev = new ProyectoNuevoView(null);
//		BacklogNuevoView bcklg = new BacklogNuevoView(null);
//		Avance a = new Avance(null);
//		DataComposite dt = new DataComposite(null);
//		Estimado e = new Estimado(null);
	
	}
	
}