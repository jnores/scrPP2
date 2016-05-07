package com.ungs.pp2.scrPP2.Dominio.Entidad;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yoshknight
 *
 */
public class Backlog {
	List<UserStory> historias;
	List<Integer> orden;

	public Backlog() {
		historias = new ArrayList<UserStory>();
		orden = new ArrayList<Integer>();

	}
	
}


// agregar al sprint un board que asocie estados con US

// que diferencia hay entre el sprint backlog y el product backlog??

// hola
