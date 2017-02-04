package pp2.scrum.model;

import junit.framework.TestCase;
import pp2.scrum.model.Estado;
import pp2.scrum.model.Tarea;

public class TareaTest extends TestCase {

public void testTareaEstadoDefault() 
	{
		Tarea tarea = new Tarea();
		assertEquals(tarea.getEstado(),Estado.ToDo);
	}

	public void testTareaEstadoSiguiente() 
	{	
		Tarea tarea = new Tarea();
		//estado por defecto, todo
		assertEquals(tarea.getEstado(),Estado.ToDo);
		//siguiente estado
		tarea.avanzarEstado();
		assertEquals(tarea.getEstado(),Estado.Doing);
		
		tarea.avanzarEstado();
		assertEquals(tarea.getEstado(),Estado.Done);
		

////		
//		MainBurndownChart otr = new MainBurndownChart();
//		otr.main(null);
//		
//		MainUserPaginadoStory otro2 = new MainUserPaginadoStory();
//		otro2.main(null);
//		
//		BacklogNuevoView v = new BacklogNuevoView(null);	
//		
//		UserStoryListView vs = new UserStoryListView(new ArrayList<UserStoryHelper>());
//		
//		FilterStoriesView vss = new FilterStoriesView(null);
		//estado invalido
		//esto se puede hacer de una forma mas elegante, ver de cambiar la version de junit (4.xx)
		try 
		 {
			tarea.avanzarEstado();
		 }	 
		catch (RuntimeException e) 
		{   		
			assertTrue(true);
		}
	}

}
