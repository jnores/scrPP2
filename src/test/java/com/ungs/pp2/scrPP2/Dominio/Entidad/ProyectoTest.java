package com.ungs.pp2.scrPP2.Dominio.Entidad;

import java.util.Collection;
import java.util.Set;

import com.ungs.pp2.scrPP2.View.ProyectoNuevoView;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class ProyectoTest extends TestCase {
	
	Proyecto proyecto;
	Miembro miembro1
		   ,miembro2
		   ;
	UserStory userStory1
			 ,userStory2
			 ,userStory3
			 ,userStory4
			 ;
	
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public ProyectoTest( String testName ) {
	    super( testName );
	}
	
	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
	    return new TestSuite( ProyectoTest.class );
	}
	
	public void  setUp() {
		miembro1 = new Miembro("Victoria","Desarrollador");
		miembro2 = new Miembro("Ivo","Diseñador");
		userStory1 =  new UserStory("Titulo1", "Detalle1", "Autor1");
		userStory2 =  new UserStory("Titulo2", "Detalle2", "Autor2");
		userStory3 =  new UserStory("Titulo3", "Detalle3", "Autor3");
		userStory4 =  new UserStory("Titulo4", "Detalle4", "Autor4");

		userStory1.setId(1);
		userStory2.setId(2);
		userStory3.setId(3);
		userStory4.setId(4);
		
		proyecto= new Proyecto();
		proyecto.addMiembro(miembro1);
		proyecto.addMiembro(miembro2);
		
		proyecto.addUserStory(userStory1);
		proyecto.addUserStory(userStory2);
		proyecto.addUserStory(userStory3);
		proyecto.addUserStory(userStory4);
		
		proyecto.asignarUserStory(userStory2, miembro1);
		proyecto.asignarUserStory(userStory4, miembro2);
		
	}
	
	/**
	 * Verifico que se asignen bien los atributos en el setUp
	 */
	public void testPryecto() {
		
		Collection<Miembro> miembros = this.proyecto.getMiembros();
		assertEquals(miembros.size(),2);
		
		Set<String> nombresMiembros = this.proyecto.getNombresMiembros();
		assertEquals(nombresMiembros.size(),2);
		
//		ProyectoNuevoView p = new ProyectoNuevoView(null);
		
	}
	
	/**
	 * Verifico que se puedan obtener las user stories asignadas al proyecto.
	 */
	public void testProyectoGetUserStories() {
		Collection<UserStory> userStories = this.proyecto.getAllUserStories();
		assertEquals(userStories.size(),4);
		
		Set<UserStory> userStoriesFromMiembro1= this.proyecto.getAllUserStoriesFromMiembro(miembro1);
		assertEquals(userStoriesFromMiembro1.size(),1);
		assertTrue(userStoriesFromMiembro1.contains(userStory2));
	}
	
	/**
	 * Verifico que se puedan obtener las Miembros pos su nombre
	 */
	public void testProyectoGetMiembro() {
		Miembro miembro = this.proyecto.getMiembroPorNombre("Ivo");
		assertEquals(miembro,this.miembro2);
		
	}	
}