package pp2.scrum.domain;

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

	UserStoryHelper story;
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
		story = new UserStoryHelper(new UserStory("Titulo1", "Detalle1", 40, null, null),new Miembro("Autor1"));
		criterio = new CriterioAceptacion("criterio1");
		tarea1 = new Tarea();
		tarea2 = new Tarea();
	}

	/**
	 * Verifico que se asignen bien los atributos con el constructor completo
	 */
	public void testStory() 
	{

		String criterios = "";
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

		assertTrue(story.getAutor().equals("Autor1"));
		assertTrue(story.getTitulo().equals("Titulo1"));
		assertTrue(story.getDetalle().equals("Detalle1"));
		assertTrue(story.getResponsable().equals("Autor1"));
		assertTrue(story.getStoryPoints() == 40);
		assertTrue(story.getIteracion() == 0);
		//      assertTrue(story.getEstado().equals(Estado.ToDo));
		assertTrue(story.getTareas().size() == 0);

		story.setAutor("au1");
		story.setCriterios(criterios);
		story.setDetalle("d1");
		story.setEstado(Estado.Doing);
		story.setHorasEstimadas(11);
		story.setIteracion(2);
		story.setResponsable("r1");    
		story.setTareas(tareas);
		story.setTitulo("t1");
		story.setStoryPoints(11);

	}

	public void testStoryNoTerminada()
	{
	   String criterios = "";
		List<Tarea> tareas = new ArrayList<Tarea>();
		tareas.add(tarea1);
		story.setTareas(tareas);
		story.setCriterios(criterios);
		assertTrue(story.getEstado().equals(Estado.ToDo));
		assertTrue(!story.estaTerminada());

	}

	public void testStoryTerminadaPorFinalizacionDeTareas()
	{
	   String criterios = "";
		List<Tarea> tareas = new ArrayList<Tarea>();
		tareas.add(tarea1);
		tareas.add(tarea2);
		story.setTareas(tareas);
		story.setCriterios(criterios);
		assertTrue(story.getEstado().equals(Estado.ToDo));
		assertTrue(!story.estaTerminada());
		assertTrue(story.getEstado().equals(Estado.ToDo));
		tarea1.avanzarEstado();
		tarea1.avanzarEstado();
		assertTrue(!story.estaTerminada());
		assertEquals(story.getEstado(), Estado.ToDo);
		tarea2.avanzarEstado();
		tarea2.avanzarEstado();
		assertTrue(story.estaTerminada());
		assertEquals(story.getEstado(), Estado.Done);

	}

	public void testStoryTerminadaPorFinalizacionDeTareasCaso2()
	{
	   String criterios = "";
		List<Tarea> tareas = new ArrayList<Tarea>();
		tareas.add(tarea1);
		tareas.add(tarea2);
		story.setTareas(tareas);
		story.setCriterios(criterios);
		assertTrue(story.getEstado().equals(Estado.ToDo));
		assertTrue(!story.estaTerminada());
		assertTrue(story.getEstado().equals(Estado.ToDo));
		tarea2.avanzarEstado();
		tarea2.avanzarEstado();
		assertTrue(!story.estaTerminada());
		assertEquals(story.getEstado(), Estado.ToDo);
		tarea1.avanzarEstado();
		tarea1.avanzarEstado();
		assertTrue(story.estaTerminada());
		assertEquals(story.getEstado(), Estado.Done);

	}

}