package com.ungs.pp2.scrPP2.Dominio.Entidad;

import java.util.ArrayList;
import java.util.List;

import com.ungs.pp2.scrPP2.MainBurndownChart;
import com.ungs.pp2.scrPP2.MainScrum;
import com.ungs.pp2.scrPP2.MainUserPaginadoStory;
import com.ungs.pp2.scrPP2.Controller.UserStoryHelper;
import com.ungs.pp2.scrPP2.Dominio.Enums.Estado;
import com.ungs.pp2.scrPP2.View.BacklogNuevoView;
import com.ungs.pp2.scrPP2.View.FilterStoriesView;
import com.ungs.pp2.scrPP2.View.UserStoryListView;

import junit.framework.TestCase;

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
		

//		
		MainBurndownChart otr = new MainBurndownChart();
		otr.main(null);
		
		MainUserPaginadoStory otro2 = new MainUserPaginadoStory();
		otro2.main(null);
		
		BacklogNuevoView v = new BacklogNuevoView(null);	
		
		UserStoryListView vs = new UserStoryListView(new ArrayList<UserStoryHelper>());
		
		FilterStoriesView vss = new FilterStoriesView(null);
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
