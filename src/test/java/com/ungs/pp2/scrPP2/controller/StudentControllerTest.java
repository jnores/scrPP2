package com.ungs.pp2.scrPP2.controller;

import com.ungs.pp2.scrPP2.controller.StudentController;
import com.ungs.pp2.scrPP2.controller.StudentControllerTest;
import com.ungs.pp2.scrPP2.model.Student;
import com.ungs.pp2.scrPP2.view.StudentView;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class StudentControllerTest 
extends TestCase
{
	private Student model;
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
	model = new Student();
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