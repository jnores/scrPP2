package pp2.scrum.dominio.Entidad;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pp2.scrum.dominio.ListaPaginada;
import pp2.scrum.dominio.entidad.UserStory;
import pp2.scrum.dominio.enums.Estado;


public class ListaPaginadaTest extends TestCase 
{
	
   ListaPaginada<UserStory> lista;
   UserStory story;
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public ListaPaginadaTest( String testName ) 
	{
	    super( testName );
	}
	
	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() 
	{
	    return new TestSuite( ListaPaginadaTest.class );
	}
	
	public void  setUp() 
	{
		story = new UserStory("Titulo1", "Detalle1", "Autor1", "Responsable1", 10, 40, 1, Estado.ToDo, null, null);
		ArrayList<UserStory> stories = new ArrayList<>();
		stories.add(story);
		lista = new ListaPaginada<>(stories, 1, 5, 1);
				

	}
	
	/**
	 * Verifico que se asignen bien los atributos con el constructor completo
	 */
	public void testListaPaginada() 
	{	   
	   assertEquals(lista.getItemsPorPagina(), 5);
	   assertEquals(lista.getItemsTotales(), 1);
	   assertEquals(lista.getPagina(), 1);
	   assertEquals(lista.getItems().get(0).getDetalle(),"Detalle1");
	   assertTrue(lista.iterator() != null);

	}
		
}