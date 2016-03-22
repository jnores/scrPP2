package com.ungs.pp2.scrPP2;

import com.ungs.pp2.scrPP2.Controller.StudentController;
import com.ungs.pp2.scrPP2.Dominio.Dto.StudentDto;
import com.ungs.pp2.scrPP2.View.StudentView;

public class App {

	public static void main(String[] args) {

		//fetch student record based on his roll no from the database
		StudentDto model  = retriveStudentFromDatabase();

		//Create a view : to write student details on console
		StudentView view = new StudentView();

		StudentController controller = new StudentController(null, model, view);

		controller.updateView();

		//update model data
		controller.setStudentName("John");

		controller.updateView();
	}

	private static StudentDto retriveStudentFromDatabase(){
		StudentDto student = new StudentDto();
		student.setName("Robert");
		student.setRollNo("10");
		return student;
	}
}