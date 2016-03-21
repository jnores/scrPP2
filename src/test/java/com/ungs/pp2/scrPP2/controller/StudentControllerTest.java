package com.ungs.pp2.scrPP2.controller;

import com.ungs.pp2.scrPP2.Controller.StudentController;
import com.ungs.pp2.scrPP2.controller.StudentControllerTest;
import com.ungs.pp2.scrPP2.Dominio.Dto.StudentDto;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IConsulta;
import com.ungs.pp2.scrPP2.View.StudentView;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import mockit.MockUp;


public class StudentControllerTest 
extends TestCase
{
   private MockUp<IConsulta> consultaMock;
	private StudentDto model;
	private StudentView view;
/**
 * Create the test case
 *
 * @param testName name of the test case
 */
public StudentControllerTest( String testName )
{
    super( testName );
}

/**
 * @return the suite of tests being tested
 */
public static Test suite()
{
    return new TestSuite( StudentControllerTest.class );
}

public void  setUp()
{
   consultaMock = new MockUp<IConsulta>(){};
	model = new StudentDto();
	model.setName("Veronica");
	model.setRollNo("123");
	view = new StudentView();
}


public void testStudentController()
{
   StudentController controller = new StudentController(consultaMock.getMockInstance(),model,view);
   controller.updateView();
   assertTrue( controller.getStudentName().equals("Veronica") );
   assertTrue( controller.getStudentRollNo().equals("123") );
}


public void testStudentControllerSets()
{
	String  studentName="Roger",
			studentRoll="11";
	
	StudentController controller = new StudentController(consultaMock.getMockInstance(),model,view);
	controller.setStudentName(studentName);
	controller.setStudentRollNo(studentRoll);
	controller.updateView();
   assertTrue( controller.getStudentName().equals(studentName) );
   assertTrue( controller.getStudentRollNo().equals(studentRoll) );
}
}