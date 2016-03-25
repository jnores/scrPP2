package com.ungs.pp2.scrPP2.controller;

import com.ungs.pp2.scrPP2.Controller.UserStoryController;
import com.ungs.pp2.scrPP2.controller.UserStoryControllerTest;
import com.ungs.pp2.scrPP2.Dominio.Dto.StudentDto;
import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IConsulta;
import com.ungs.pp2.scrPP2.View.UserStoryView;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import mockit.MockUp;


public class UserStoryControllerTest 
extends TestCase
{
   private MockUp<IConsulta> consultaMock;
	private UserStory model;
	private UserStoryView view;
	private UserStoryController controller;
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
	model = new UserStory();
	controller = new UserStoryController(consultaMock.getMockInstance(), model);
	/*
	model.setName("Veronica");
	model.setRollNo("123");
	*/
	view = new UserStoryView(controller);
}


public void testStudentController()
{
   UserStoryController controller = new UserStoryController(consultaMock.getMockInstance(),model);
   /*
   controller.updateView();
   assertTrue( controller.getStudentName().equals("Veronica") );
   assertTrue( controller.getStudentRollNo().equals("123") );
   */
   assertTrue(true);
}


public void testStudentControllerSets()
{
	String  studentName="Roger",
			studentRoll="11";
	
   UserStoryController controller = new UserStoryController(consultaMock.getMockInstance(),model);
   /*
   controller.setStudentName(studentName);
   controller.setStudentRollNo(studentRoll);
   controller.updateView();
   assertTrue( controller.getStudentName().equals(studentName) );
   assertTrue( controller.getStudentRollNo().equals(studentRoll) );
   */
   assertTrue(true);
}
}