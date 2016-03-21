package com.ungs.pp2.scrPP2.controller;

import com.ungs.pp2.scrPP2.Controller.StudentController;
import com.ungs.pp2.scrPP2.controller.StudentControllerTest;
import com.ungs.pp2.scrPP2.Dominio.Dto.StudentDto;
import com.ungs.pp2.scrPP2.View.StudentView;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class StudentControllerTest 
extends TestCase
{
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
	model = new StudentDto();
	model.setName("Veronica");
	model.setRollNo("123");
	view = new StudentView();
}


/**
 * Rigourous Test :-)
 */
public void testStudentController()
{
	StudentController controller = new StudentController(model,view);
	controller.updateView();
    assertTrue( controller.getStudentName() == "Veronica" );
    assertTrue( controller.getStudentRollNo() == "123" );
}
}