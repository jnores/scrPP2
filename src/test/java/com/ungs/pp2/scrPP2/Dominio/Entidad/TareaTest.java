package com.ungs.pp2.scrPP2.Dominio.Entidad;

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
		
		//estado invalido
		try 
		 {
			tarea.avanzarEstado();
		 }	 
		catch (RuntimeException e) 
		{   		
   		assertTrue(e instanceof RuntimeException);
		}
	}

}
