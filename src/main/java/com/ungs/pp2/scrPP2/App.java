package com.ungs.pp2.scrPP2;

import com.ungs.pp2.scrPP2.controller.StudentController;
import com.ungs.pp2.scrPP2.model.Student;
import com.ungs.pp2.scrPP2.view.StudentView;

public class App {
	   public int tres()
	   {
			return 3;
	   }
	   public static void main(String[] args) {

	      //fetch student record based on his roll no from the database
	      Student model  = retriveStudentFromDatabase();

	      //Create a view : to write student details on console
	      StudentView view = new StudentView();

	      StudentController controller = new StudentController(model, view);

	      controller.updateView();

	      //update model data
	      controller.setStudentName("John");

	      controller.updateView();
	   }

	   private static Student retriveStudentFromDatabase(){
	      Student student = new Student();
	      student.setName("Robert");
	      student.setRollNo("10");
	      return student;
	   }
	}