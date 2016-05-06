package com.ungs.pp2.scrPP2.Controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;
import com.ungs.pp2.scrPP2.Dominio.Plugin.Exporter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import jxl.read.biff.BiffException;


public class UserStoryHelperTest 
extends TestCase
{
	private UserStory userStory;
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public UserStoryHelperTest( String testName )
	{
	    super( testName );
	}
	
	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
	    return new TestSuite( UserStoryHelperTest.class );
	}
	
	public void  setUp()
	{
	   this.userStory = new UserStory("Titulo1", "Detalle1", "Autor1");
	}
	
	/**
	 * Verifico que se pueda acceder a los datos de la user story desde el helper
	 */
	public void testUserStoryHelper()
	{
		UserStoryHelper userStoryHelper = new UserStoryHelper(this.userStory);
		assertTrue(userStoryHelper.getTitulo().equals(this.userStory.getTitulo()));
		assertTrue(userStoryHelper.getDetalle().equals(this.userStory.getDetalle()));
		assertTrue(userStoryHelper.getAutor().equals(this.userStory.getAutor()));
	}
	
	/**
	 * Modifico el modelo y verifico que el cambio se ve reflejado desde el helper
	 * @throws IOException 
	 * @throws BiffException 
	 */
	public void testUserStoryHelperUpdateStory() throws BiffException, IOException
	{
		UserStoryHelper userStoryHelper = new UserStoryHelper(this.userStory);
		
		String   titulo = "testUserStoryHelper update model"
				,detalle= "Se probara el acceso al modelo posterior a la modificacion de datos"
				,autor  = "Nores"
				;
		
		assertFalse(userStoryHelper.getTitulo().equals(titulo));
		this.userStory.setTitulo(titulo);
		assertTrue(userStoryHelper.getTitulo().equals(titulo));
		assertFalse(userStoryHelper.getDetalle().equals(detalle));
		this.userStory.setDetalle(detalle);
		assertTrue(userStoryHelper.getDetalle().equals(detalle));
		assertFalse(userStoryHelper.getAutor().equals(autor));
		this.userStory.setAutor(autor);
		assertTrue(userStoryHelper.getAutor().equals(autor));
		
		
		
			    
		//test basico de exportacion. Esto despues va en otro lado.
		//esto rompió el commit
		
		String path="./prueba.xls";
		List<UserStoryHelper> lst = new ArrayList<>();
		lst.add(userStoryHelper);
		Exporter.INSTANCE.export(path, lst);
		//esto rompió el commit- creo que es porque exporta a un path que no existe en el repo de la nube, cuando
		//ejecuta todas lsa pruebas
		
//		
//		//Esto lo voy a usar despues para testear que los datos del excel que exporté sean correctos y
//		//cotejarlos con los criterios de aceptación
//		Workbook workbook = Workbook.getWorkbook(new java.io.File(path));
//	    Sheet sheet = workbook.getSheet(0);
	}
}