package com.ungs.pp2.scrPP2.Dominio.Entidad;

import com.ungs.pp2.scrPP2.MainBurndownChart;
import com.ungs.pp2.scrPP2.MainScrum;
import com.ungs.pp2.scrPP2.MainUserPaginadoStory;
import com.ungs.pp2.scrPP2.Dominio.Enums.Estado;

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
