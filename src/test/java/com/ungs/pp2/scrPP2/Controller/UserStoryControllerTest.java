package com.ungs.pp2.scrPP2.Controller;

import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;
import com.ungs.pp2.scrPP2.Dominio.Enums.Estado;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IConsulta;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import mockit.MockUp;


public class UserStoryControllerTest 
extends TestCase
{
	private MockUp<IConsulta> consultaMock;
	private UserStory model;

	
/**
 * Create the test case
 *
 * @param testName name of the test case
 */
public UserStoryControllerTest( String testName )
{
    super( testName );
}

/**
 * @return the suite of tests being tested
 */
public static Test suite()
{
    return new TestSuite( UserStoryControllerTest.class );
}

public void  setUp()
{
	consultaMock = new MockUp<IConsulta>(){};
	model = new UserStory("Titulo1", "Detalle1", "Autor1", "Responsable1", 10, 40, 1, Estado.ToDo, null, null);
}


public void testUserStoryController()
{
   UserStoryController controller = new UserStoryController(consultaMock.getMockInstance(),model);

   assertTrue(true);
}


public void testUserStoryControllerSets()
{
	String  studentName="Roger",
			studentRoll="11";
	
   UserStoryController controller = new UserStoryController(consultaMock.getMockInstance(),model);

   assertTrue(true);
}
}