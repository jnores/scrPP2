package pp2.scrum.model;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pp2.scrum.controller.UserStoryHelper;
import pp2.scrum.model.CriterioAceptacion;
import pp2.scrum.model.Estado;
import pp2.scrum.model.Miembro;
import pp2.scrum.model.Tarea;
import pp2.scrum.model.UserStory;


public class UserStoryTest extends TestCase {

	UserStory story;
	CriterioAceptacion criterio;
	Tarea tarea1,tarea2;

	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public UserStoryTest( String testName ) {
		super( testName );
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() 
	{
		return new TestSuite( UserStoryTest.class );
	}

	public void  setUp() 
	{
	    criterio = new CriterioAceptacion("criterio1");
	    tarea1 = new Tarea();
	    tarea2 = new Tarea();
	    List<Tarea> tareas = new ArrayList<Tarea>();
	    tareas.add(tarea1);
	    tareas.add(tarea2);
	        
	    story = new UserStory("Titulo1", "Detalle1", 40, criterio, tareas);
	}

	/**
	 * Verifico que se asignen bien los atributos con el constructor completo
	 */
	public void testStory() 
	{

	   
		List<Tarea> tareas = new ArrayList<Tarea>();
		tareas.add(tarea1);

		assertTrue(tarea1.getEstado() == Estado.ToDo);
		//assertTrue(tarea1.getId() == 0);

		//tarea.setEstado(Estado.Done);
		tarea1.avanzarEstado();

		//tarea1.setId(1);

		assertTrue(criterio.getDescripcion() == "criterio1");
		assertTrue(criterio.getId() == 0);
		criterio.setDescripcion("d2");
		criterio.setId(1);

		assertTrue(story.getTitulo().equals("Titulo1"));
		assertTrue(story.getDetalle().equals("Detalle1"));
		assertTrue(story.getStoryPoints() == 40);
		//      assertTrue(story.getEstado().equals(Estado.ToDo));
		assertTrue(story.getTareas().size() == 2);

		story.setDetalle("d1");

	}

	public void testStoryTerminadaPorFinalizacionDeTareas()
	{
		assertFalse(story.estaTerminada());
	
		tarea1.avanzarEstado();
		tarea1.avanzarEstado();
		assertFalse(story.estaTerminada());
		
		tarea2.avanzarEstado();
		tarea2.avanzarEstado();
		assertTrue(story.estaTerminada());

	}

}